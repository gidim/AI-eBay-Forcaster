package ebayForcaster;


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

    public String getURL(String urlString) throws IOException,
            HttpException {
        HttpGet request = new HttpGet(urlString);

        //Use defualt configuration fo timeout handling
        request.setConfig(defaultReqConfig);


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
