package ebayForcaster;

import org.apache.http.HttpException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub

    	DBConnect db = new DBConnect();
        WebDataGrabber wg = new WebDataGrabber();
        try {

            String str = wg.getURL("http://svcs.ebay.com/services/search/FindingService/v1?OPERATION-NAME=findCompletedItems&SERVICE-VERSION=1.7.0&SECURITY-APPNAME=QualityH-65b4-4a00-905f-ead3711cbeae&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&keywords=Garmin+nuvi+1300+Automotive+GPS+Receiver&itemFilter(0).name=SoldItemsOnly&itemFilter(0).value=true&outputSelector(0)=SellerInfo&sortOrder=EndTimeSoonest&paginationInput.entriesPerPage=500");
            JsonItemParser jp = new JsonItemParser(str);


            ArrayList items = jp.getItems();
            db.insertEbayItems(items);
            
            /*
            try {
				Instances data = db.getWekaInstance(96312835, true, true, true, true, true);
				ArffSaver saver = new ArffSaver();
	            saver.setInstances(data);
	            saver.setFile(new File("output.arff"));
	            saver.writeBatch();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
            

            //System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}