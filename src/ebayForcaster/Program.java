package ebayForcaster;

import org.apache.http.HttpException;

import weka.classifiers.functions.SMOreg;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import weka.classifiers.functions.LinearRegression;

public class Program {

    static String[] productsId = {"168508202", "175256176", "167317351", "102587397", "175299667"};


    public static Object[] main(String[] args) {


        /*
         * This is the final object returned when the program is run.
         * [0] - double - mean price
         * [1] - String Array - Tested Attribute Names
         * [2] - double Array - Coefficents for the above attributes
         * [3] - double Array - SVM Weights for the above attributes
         */
        ArrayList<Object> output = new ArrayList<Object>();


        //get the data about the product the user want
        /*if (args.length != 1) {
            System.out.println("No ProductID Selected. Updating All Data.");
            updateAllProducts();
            System.exit(0);
        }

        //selected project id
        String productID = args[0];
        */

        //THIS IS DEBUG CODE, DELETE AND UNCOMMENT ABOVE TO RUN!
        String productID = "167317351";

        //Check user input to make sure we have a model for it
        ArrayList<String> productIDs = new ArrayList<String>(Arrays.asList(productsId));
        if (!productIDs.contains(productID)){
            System.out.println("Item Not Found In Database: " + productID);
            System.out.println("Exiting.");
            System.exit(1);
        }

        //Selected Attributes for Analysis (columns that are pulled from the DB).
        //This can be modeled for each product using string builder and a switch statement (if elses)
        ArrayList<String> selectedAttributes = new ArrayList();

        //Add attributes used in every regression
        selectedAttributes.add("feedbackScore");
        selectedAttributes.add("positiveFeedbackPercent");
        selectedAttributes.add("topRatedSeller");
        selectedAttributes.add("expeditedShipping");
        selectedAttributes.add("oneDayShippingAvailable");
        selectedAttributes.add("bestOfferEnabled");
        selectedAttributes.add("buyItNowAvailable");

        //add item/model specific attributes
        //and yes I know this is terrible coding but I forgot 1.6 doesnt have string switch and its easier to read
        switch (Integer.parseInt(productID)) {
            case 168508202: ;
                //Attributes specific for this item...
                selectedAttributes.add("topRatedListing");
                break;
            case 175256176: ;
                //Attributes specific for this item...
                break;
            case 167317351: ;
                selectedAttributes.add("returnsAccepted");
                selectedAttributes.add("topRatedListing");
                break;
            case 102587397: ;
                break;
            case 175299667: ;
                break;
            default: break;
        }

        //Current Price must be the last attribute
        selectedAttributes.add("convertedCurrentPrice");

        //Covert arraylist to string array (completely inefficent but whatever)
        String[] selAttr = Arrays.copyOf(selectedAttributes.toArray(), selectedAttributes.size(), String[].class);

        //Pull data for item from database given the selected set of attributes
        Instances data = getWekaDataById(productID, selAttr);

        //get the mean price of the product
        output.add(0, calculateMeanPrice(data));

        //provide the attributes used
        output.add(1, selAttr);

        //Run Linear Regression
        //Remember that the last item is the intercept
        double[] coeffs = executeLinearRegression(data);

        //add LR coefficents to output array
        output.add(2, coeffs);

        //add SVM weights to output array
        output.add(3, executeSVM(data));

        return output.toArray();
    }


    /*
     * Calculate mean sale price for item
     */
    private static double calculateMeanPrice(Instances data) {
        return data.meanOrMode(data.numAttributes() - 1);
    }

    /*
     * Run Weka Linear Regression on the given instances
     * Return Coefficents
     */
    private static double[] executeLinearRegression(Instances data){
        data.setClassIndex(data.numAttributes() - 1);
        LinearRegression model = new LinearRegression();

        try {
            model.buildClassifier(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(model.toString());
        return model.coefficients();
    }

    /*
     * Run Weka SVM Regression on the given instances
     * Return Weights
     */
    private static double[] executeSVM(Instances data) {

        data.setClassIndex(data.numAttributes() - 1);
        SMOreg svm = new SMOreg();
        try {
            svm.buildClassifier(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(svm.toString());

        return parseSVMResult(svm.toString());
    }

    /*
     * Weka SVM is mainly used for clasification of future instances so we need
     * to print the classifier and parse the results to get the weights without
     * making a prediction.  This does exactly that.
     */
    private static double[] parseSVMResult(String resultString) {
        ArrayList<Double> weightList = new ArrayList<Double>();
        String lines[] = resultString.split("\\r?\\n");
        for(String line : lines) {
            if(line.contains("-") || line.contains("+")){
                if(line.contains("*")) {
                    line = line.substring(0, line.indexOf("*"));
                }
                line = line.replaceAll("\\s+","");
                weightList.add(Double.parseDouble(line));
            }
        }

        //lots more shitty list conversion code below!
        double[] svmCoeffs = new double[weightList.size()];
        Iterator<Double> iterator = weightList.iterator();
        int i = 0;
        while(iterator.hasNext())
        {
            svmCoeffs[i] = iterator.next().doubleValue();
            i++;
        }
        return svmCoeffs;
    }


    /**
     * gets data from DB and pushes it to weka
     * TODO: fix weka part
     * @param id
     */
    private static void setDataToWekaById(String id){

        String[] attributes = {"itemId", "title",
                "categoryId", "productId", "postalCode", "country", "feedbackScore",
                "positiveFeedbackPercent", "feedbackRatingStar", "topRatedSeller",
                "shippingServiceCost", "shippingType", "expeditedShipping",
                "oneDayShippingAvailable", "handlingTime",
                "bidCount", "bestOfferEnabled", "buyItNowAvailable", "DATE_FORMAT(endTime, '%Y-%m-%d') AS endTime",
                "listingType", "returnsAccepted", "conditionId", "topRatedListing", "convertedCurrentPrice"};

        try {
            DBConnect db = new DBConnect();
            Instances data = db.getWekaInstance(Integer.parseInt(id), attributes);
            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File(id + ".arff"));
            saver.writeBatch();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * Creates a weka instances object using the selected productID and set of attributes for that ID
     */
    private static Instances getWekaDataById(String id, String[] attributes){

            DBConnect db = new DBConnect();
            Instances data = null;
        try {
            data = db.getWekaInstance(Integer.parseInt(id), attributes);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return data;

    }

    /**
     * run over all products and update DB and WEKA
     */
    private static void updateAllProducts() {


        for (int i = 0; i < productsId.length; i++) {
            System.out.println("Processing: " + productsId[i]);
            for (int j = 1; j < 15; j++){
                int itemsProcessed = updateDataOnDBForItem(productsId[i], j);
                if (itemsProcessed < 100) {
                    break;
                }
            }
            setDataToWekaById(productsId[i]);
        }
    }

    /**
     * gets an eBay item ID, fetches from API and saves to DB
     */
    private static int updateDataOnDBForItem(String id, int pageNum) {

        int itemCount = 0;

        DBConnect db = new DBConnect();
        WebDataGrabber wg = new WebDataGrabber();
        try {

            String str = wg.getURL("http://svcs.ebay.com/services/search/FindingService" +
                    "/v1?OPERATION-NAME=findCompletedItems&SERVICE-VERSION=1.7.0&SECURITY-" +
                    "APPNAME=QualityH-65b4-4a00-905f-ead3711cbeae&RESPONSE-DATA-FORMAT=JSON&REST" +
                    "-PAYLOAD&keywords=&productId.@type=ReferenceID&productId="+id+"&itemFilter(0).name=SoldItemsOnly" +
                    "&itemFilter(0).value=true&itemFilter(1).name=Condition&itemFilter(1).value=1000" +
                    "&outputSelector(0)=SellerInfo&sortOrder=EndTimeSoonest&paginationInput.entriesPerPage=100" +
                    "&paginationInput.pageNumber=" + pageNum);
            JsonItemParser jp = new JsonItemParser(str);

            ArrayList<EbayItem> items = jp.getItems();
            db.getData();
            db.insertEbayItems(items);
            itemCount += items.size();

        } catch (HttpException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ParseException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return itemCount;
    }
}