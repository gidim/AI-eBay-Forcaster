package ebayForcaster;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class JsonItemParser {

    private JsonParser parser;
    private List <EbayItem> items;


    public JsonItemParser(String str) {


        List<JSONObject> JsonItems = JsonPath.read(str, "findCompletedItemsResponse.[*].searchResult.[*].item.[*]");


        for(JSONObject jsonItem : JsonItems){
            boolean bestOffer = Boolean.parseBoolean((String)JsonPath.read(jsonItem, "listingInfo.[0].bestOfferEnabled.[0]"));
            String itemId = (String)JsonPath.read(jsonItem, "itemId.[0]");
            String name = (String)JsonPath.read(jsonItem, "title.[0]");
            String catID = (String)JsonPath.read(jsonItem, "primaryCategory.[0].categoryId.[0]");

            EbayItem item = new EbayItem();

            //items.add("hasd").


        }


    }




}