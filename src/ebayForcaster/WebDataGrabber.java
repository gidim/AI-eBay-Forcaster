import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * DOWNLOADS ITEM PAGES disables cookies
 *
 * @author dealfinder
 */
public class WebDataGrabber {

    DefaultHttpClient client;
    RequestConfig defaultReqConfig;
    BasicResponseHandler responseHandler;

    int DEFAULT_SOCKET_TIMEOUT = 30;
    int DEFAULT_CONNECTION_TIMEOUT = 30;
    int DEFAULT_CONNECTION_REQUEST_TIMEOUT = 30;

    public WebDataGrabber() {
        client = new DefaultHttpClient();
        defaultReqConfig = RequestConfig.custom()
                .setSocketTimeout(DEFAULT_SOCKET_TIMEOUT * 1000)
                .setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT * 1000)
                .setConnectionRequestTimeout(DEFAULT_CONNECTION_REQUEST_TIMEOUT * 1000)
                .setExpectContinueEnabled(true)
                .setStaleConnectionCheckEnabled(true)
                .build();
        responseHandler = new BasicResponseHandler();
    }

    public String getURL(String urlString, boolean useCookies,
            boolean mobileUserAgent, boolean jsonHeader) throws IOException,
            HttpException {
        HttpGet request = new HttpGet(urlString);

        //Use defualt configuration fo timeout handling
        request.setConfig(defaultReqConfig);

        if (useCookies == false) {
            // set the cookie policy to disable cookies
            request.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.IGNORE_COOKIES);
        }

        if (mobileUserAgent == true) {
            // Forge request header to match iPhone app
            request.addHeader("Accept-Language", "en-us");
            request.addHeader("User-Agent", "iPhone App / 4.0.0");
            request.addHeader("Pragma", "no-cache");
        } else {
            request.addHeader("Accept-Language", "en-us");
            request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64)"
                    + " AppleWebKit/537.36 (KHTML, like Gecko)"
                    + " Chrome/33.0.1750.154 Safari/537.36");
        }
        if (jsonHeader) {
            request.addHeader("Accept", "application/json");
            request.addHeader("Content-Type", "application/json");
        }

        HttpResponse response = client.execute(request);

        return processResponse(response);
    }

    private String processResponse(HttpResponse response) throws IOException, HttpException {

        //Response Code Debugging
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new HttpException();
        }

        String responseString = responseHandler.handleResponse(response);

        return responseString;
    }

    public void closeConnection() {
        client.getConnectionManager().shutdown();
    }
}
