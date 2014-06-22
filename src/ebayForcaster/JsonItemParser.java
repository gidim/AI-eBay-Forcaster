import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dealfinder
 */
public class JsonItemParser {

    private JsonParser parser;

    public JsonItemParser() {
        parser = new JsonParser();
    }

    public ArrayList<EbayItem> parseEbayItems(String jsonInputString) {

        return null;
    }

    private EbayUser parseEbayUser(String jsonItemString) {

        int ebayItemID;
        String neweggItemNumber;
        String name;
        int catID;
        int productID;
        String imageThumbURL;
        int price;
        short shipping;
        boolean buyItNow;
        boolean bestOffer;
        short bids;
        short conditionID;
        String seller;
        String listingType;
        Date startTime;
        Date endTime;
        String searchTerm;

        JsonObject rootObj = parser.parse(jsonItemString).getAsJsonObject();

    //Get Ebay Item ID
        return null;
    }

}
