
import java.util.Date;

/**
 *
 * @author dealfinder
 */
public class EbayItemWithUser extends EbayItem {

    private EbayUser user;
    
    public EbayItemWithUser(int ebayItemID, String itemNumber, String name,
            int catID, int productID, String imageThumbURL, int price,
            short shipping, boolean buyItNow, boolean bestOffer, short bids,
            short conditionID, String seller, String listingType, Date startTime,
            Date endTime, String searchTerm, String userName, int feedbackCount, 
            short feedbackPercentPositive, String location, String country, int zipcode, 
            boolean topRated) {
        
        super(ebayItemID, itemNumber, name, catID, productID, imageThumbURL,
                price, shipping, buyItNow, bestOffer, bids, conditionID, seller,
                listingType, startTime, endTime, searchTerm);
        
        user = new EbayUser(userName, feedbackCount, feedbackPercentPositive,
                location, country, zipcode, topRated);
    }
    
    public EbayItemWithUser(int ebayItemID, String name,
            int catID, int productID, String imageThumbURL, int price,
            short shipping, boolean buyItNow, boolean bestOffer, short bids,
            short conditionID, String seller, String listingType, Date startTime,
            Date endTime, String searchTerm, String userName, int feedbackCount, 
            short feedbackPercentPositive, String location, String country, int zipcode, 
            boolean topRated) {
        
        super(ebayItemID, "-1", name, catID, productID, imageThumbURL,
                price, shipping, buyItNow, bestOffer, bids, conditionID, seller,
                listingType, startTime, endTime, searchTerm);
        
        user = new EbayUser(userName, feedbackCount, feedbackPercentPositive,
                location, country, zipcode, topRated);
    }
    
    public EbayItemWithUser(int ebayItemID, String itemNumber, String name,
            int catID, int productID, String imageThumbURL, int price,
            short shipping, boolean buyItNow, boolean bestOffer, short bids,
            short conditionID, String seller, String listingType, Date startTime,
            Date endTime, String searchTerm, EbayUser ebayUser) {
        
        super(ebayItemID, itemNumber, name, catID, productID, imageThumbURL,
                price, shipping, buyItNow, bestOffer, bids, conditionID, seller,
                listingType, startTime, endTime, searchTerm);
        
        user = new EbayUser(ebayUser.getUserName(), ebayUser.getFeedbackCount(),
                ebayUser.getFeedbackPercentPositive(), ebayUser.getLocation(),
                ebayUser.getCountry(), ebayUser.getZipcode(), ebayUser.isTopRated());
    }

    /**
     * @return the user
     */
    public EbayUser getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(EbayUser user) {
        this.user = user;
    }
    
        /**
     * @return the userName
     */
    public String getUserName() {
        return user.getUserName();
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.user.setUserName(userName);
    }

    /**
     * @return the feedbackCount
     */
    public int getFeedbackCount() {
        return user.getFeedbackCount();
    }

    /**
     * @param feedbackCount the feedbackCount to set
     */
    public void setFeedbackCount(int feedbackCount) {
        this.user.setFeedbackCount(feedbackCount);
    }

    /**
     * @return the feedbackPercentPositive
     */
    public short getFeedbackPercentPositive() {
        return user.getFeedbackPercentPositive();
    }

    /**
     * @param feedbackPercentPositive the feedbackPercentPositive to set
     */
    public void setFeedbackPercentPositive(short feedbackPercentPositive) {
        this.setFeedbackPercentPositive(feedbackPercentPositive);
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return user.getLocation();
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.user.setLocation(location);
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return user.getCountry();
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.user.setCountry(country);
    }

    /**
     * @return the zipcode
     */
    public int getZipcode() {
        return user.getZipcode();
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(int zipcode) {
        this.user.setZipcode(zipcode);
    }

    /**
     * @return the topRated
     */
    public boolean isTopRated() {
        return user.isTopRated();
    }

    /**
     * @param topRated the topRated to set
     */
    public void setTopRated(boolean topRated) {
        this.user.setTopRated(topRated);
    }
    
    
    
}
