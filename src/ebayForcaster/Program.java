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

    public static void main(String[] args) {

        /**
         * We will set this manually to true
         * when we want to update teh data
         */
        boolean setupFlag = false;
        if(setupFlag){
            updateAllProducts();
        }

        setDataToWekaById("168508202");

        //get the data about the product the user want
        if (args.length != 1)
            return;

        Weka weka = new Weka();

        //get the Weka report
        String toCLient = weka.queryByID(args[0]);




    }


    /**
     * gets data from DB and pushes it to weka
     * TODO: fix weka part
     * @param id
     */
    private static void setDataToWekaById(String id){

        try {
            DBConnect db = new DBConnect();
            Instances data = db.getWekaInstance(Integer.parseInt(id), true, true, true, true, true);
            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            System.out.println("Before");
            saver.setFile(new File(id + ".arff"));
            saver.writeBatch();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * run over all products and update DB and WEKA
     */
    private static void updateAllProducts() {
        String[] productsId = {"168508202", "175256176", "167317351", "102587397"};

        for (int i = 0; i < productsId.length; i++) {
            updateDataOnDBForItem(productsId[i]);
            setDataToWekaById(productsId[i]);
        }
    }

    /**
     * gets an eBay item ID, fetches from API and saves to DB
     */
    private static void updateDataOnDBForItem(String id) {

        DBConnect db = new DBConnect();
        WebDataGrabber wg = new WebDataGrabber();
        try {

            String str = wg.getURL("http://svcs.ebay.com/services/search/FindingService/v1?OPERATION-NAME=findCompletedItems&SERVICE-VERSION=1.7.0&SECURITY-APPNAME=QualityH-65b4-4a00-905f-ead3711cbeae&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&keywords=Garmin+nuvi+1300+Automotive+GPS+Receiver&itemFilter(0).name=SoldItemsOnly&itemFilter(0).value=true&outputSelector(0)=SellerInfo&sortOrder=EndTimeSoonest&paginationInput.entriesPerPage=500");
            JsonItemParser jp = new JsonItemParser(str);


            ArrayList<EbayItem> items = jp.getItems();
            db.getData();
            //System.out.println(items);
            db.insertEbayItems(items);
        } catch (HttpException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ParseException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }
}