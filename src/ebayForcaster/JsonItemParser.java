package ebayForcaster;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class JsonItemParser {


    private ArrayList <EbayItem> items;



    public JsonItemParser(String str) throws ParseException {

        //get all items
        List<JSONObject> JsonItems = JsonPath.read(str, "findCompletedItemsResponse.[*].searchResult.[*].item.[*]");
        items = new ArrayList<EbayItem>();

        //parse each item from JSON and generate an item object for it
        for(JSONObject jsonItem : JsonItems){

            String itemId = (String)JsonPath.read(jsonItem, "itemId.[0]");
            String name = (String)JsonPath.read(jsonItem, "title.[0]");
            String catID = (String)JsonPath.read(jsonItem, "primaryCategory.[0].categoryId.[0]");

            String prodctId;
            if(jsonItem.toString().contains("productId"))
                 prodctId = JsonPath.read(jsonItem, "productId.[0].__value__");
            else
                continue;

            String zipCode;
            if(jsonItem.toString().contains("postalCode"))
                 zipCode = (String) JsonPath.read(jsonItem, "postalCode.[0]");
            else
                zipCode = "0";


            String country = JsonPath.read(jsonItem, "country.[0]");
            int feedbackCount = Integer.parseInt((String)JsonPath.read(jsonItem, "sellerInfo.[0].feedbackScore.[0]"));
            double feedbackPercentPositive = Double.parseDouble((String)JsonPath.read(jsonItem, "sellerInfo.[0].positiveFeedbackPercent.[0]"));
            String feedbackRatingStarStr = (String)JsonPath.read(jsonItem, "sellerInfo.[0].feedbackRatingStar.[0]");
            boolean topRatedSeller = Boolean.parseBoolean((String)JsonPath.read(jsonItem, "sellerInfo.[0].topRatedSeller.[0]"));
            boolean expediatedShipping = Boolean.parseBoolean((String)JsonPath.read(jsonItem, "shippingInfo.[0].expeditedShipping.[0]"));


            double shippingPrice;
            if(jsonItem.toString().contains("shippingServiceCost"))
                 shippingPrice = Double.parseDouble((String)JsonPath.read(jsonItem, "shippingInfo.[0].shippingServiceCost.[0].__value__"));
            else
                shippingPrice = 0;


            boolean oneDayShippingAvailable = Boolean.parseBoolean((String)JsonPath.read(jsonItem, "shippingInfo.[0].oneDayShippingAvailable.[0]"));
            String shippingType = ((String)JsonPath.read(jsonItem, "shippingInfo.[0].shippingType.[0]"));

            int handlingTime;
            if(jsonItem.toString().contains("handlingTime")) {
                handlingTime = Integer.parseInt((String) JsonPath.read(jsonItem, "shippingInfo.[0].handlingTime.[0]"));
            } else
                handlingTime = 1;

            double price = Double.parseDouble((String) JsonPath.read(jsonItem, "sellingStatus.[0].currentPrice.[0].__value__"));

            int bids;
            if(jsonItem.toString().contains("bidCount"))
                bids = Integer.parseInt((String)JsonPath.read(jsonItem,"sellingStatus.[0].bidCount.[0]"));
            else
                   bids = 0;

            boolean bestOffer = Boolean.parseBoolean((String)JsonPath.read(jsonItem, "listingInfo.[0].bestOfferEnabled.[0]"));
            boolean buyItNow = Boolean.parseBoolean((String)JsonPath.read(jsonItem, "listingInfo.[0].buyItNowAvailable.[0]"));

            //Parse endTime
            String endTimeTemp = ((String)JsonPath.read(jsonItem, "listingInfo.[0].endTime.[0]"));
            endTimeTemp = endTimeTemp.substring(0, endTimeTemp.length() - 5).replaceAll("T", " ");
            Date endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(endTimeTemp);

            String listingType = ((String)JsonPath.read(jsonItem, "listingInfo.[0].listingType.[0]"));

            boolean returnsAccepted = Boolean.parseBoolean((String)JsonPath.read(jsonItem, "returnsAccepted.[0]"));
            int conditionID = Integer.parseInt((String)JsonPath.read(jsonItem,"condition.[0].conditionId.[0]"));
            boolean topRatedListing = Boolean.parseBoolean((String)JsonPath.read(jsonItem, "topRatedListing.[0]"));


            EbayItem item = new EbayItem(itemId,name,catID,prodctId,zipCode,country,feedbackCount,feedbackPercentPositive,feedbackRatingStarStr,topRatedSeller,shippingType,shippingPrice,expediatedShipping,oneDayShippingAvailable,handlingTime,price,bids,bestOffer,buyItNow,endTime,listingType,returnsAccepted,conditionID,topRatedListing);
            items.add(item);

        }


    }

    public ArrayList getItems(){
        return this.items;
    }


}