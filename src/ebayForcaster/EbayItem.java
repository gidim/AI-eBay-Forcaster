import java.util.Date;

/**
 *
 * @author dealfinder
 */
public class EbayItem {
    
    private int ebayItemID;
    private String neweggItemNumber;
    private String name;
    private int catID;
    private int productID;
    private String imageThumbURL;
    private int price;
    private short shipping;
    private boolean buyItNow;
    private boolean bestOffer;
    private short bids;
    private short conditionID;
    private String seller;
    private String listingType;
    private Date startTime;
    private Date endTime;
    private String searchTerm;

    /**
     *
     * @param ebayItemID
     * @param itemNumber
     * @param name
     * @param catID
     * @param productID
     * @param imageThumbURL
     * @param price
     * @param shipping
     * @param buyItNow
     * @param bestOffer
     * @param bids
     * @param conditionID
     * @param seller
     * @param listingType
     * @param startTime
     * @param endTime
     * @param searchTerm
     */
    public EbayItem(int ebayItemID, String itemNumber, String name, int catID,
            int productID, String imageThumbURL, int price, short shipping,
            boolean buyItNow, boolean bestOffer, short bids, short conditionID,
            String seller, String listingType, Date startTime, Date endTime,
            String searchTerm) {
        this.ebayItemID = ebayItemID;
        this.neweggItemNumber = itemNumber;
        this.name = name;
        this.catID = catID;
        this.productID = productID;
        this.imageThumbURL = imageThumbURL;
        this.price = price;
        this.shipping = shipping;
        this.buyItNow = buyItNow;
        this.bestOffer = bestOffer;
        this.bids = bids;
        this.conditionID = conditionID;
        this.seller = seller;
        this.listingType = listingType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.searchTerm = searchTerm;
    }

    /**
     * @return the ebayItemID
     */
    public int getEbayItemID() {
        return ebayItemID;
    }

    /**
     * @param ebayItemID the ebayItemID to set
     */
    public void setEbayItemID(int ebayItemID) {
        this.ebayItemID = ebayItemID;
    }

    /**
     * @return the itemNumber
     */
    public String getNeweggItemNumber() {
        return neweggItemNumber;
    }

    /**
     * @param itemNumber the itemNumber to set
     */
    public void setNeweggItemNumber(String itemNumber) {
        this.neweggItemNumber = itemNumber;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the catID
     */
    public int getCatID() {
        return catID;
    }

    /**
     * @param catID the catID to set
     */
    public void setCatID(int catID) {
        this.catID = catID;
    }

    /**
     * @return the productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * @return the imageThumbURL
     */
    public String getImageThumbURL() {
        return imageThumbURL;
    }

    /**
     * @param imageThumbURL the imageThumbURL to set
     */
    public void setImageThumbURL(String imageThumbURL) {
        this.imageThumbURL = imageThumbURL;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the shipping
     */
    public short getShipping() {
        return shipping;
    }

    /**
     * @param shipping the shipping to set
     */
    public void setShipping(short shipping) {
        this.shipping = shipping;
    }

    /**
     * @return the buyItNow
     */
    public boolean isBuyItNow() {
        return buyItNow;
    }

    /**
     * @param buyItNow the buyItNow to set
     */
    public void setBuyItNow(boolean buyItNow) {
        this.buyItNow = buyItNow;
    }

    /**
     * @return the bestOffer
     */
    public boolean isBestOffer() {
        return bestOffer;
    }

    /**
     * @param bestOffer the bestOffer to set
     */
    public void setBestOffer(boolean bestOffer) {
        this.bestOffer = bestOffer;
    }

    /**
     * @return the bids
     */
    public short getBids() {
        return bids;
    }

    /**
     * @param bids the bids to set
     */
    public void setBids(short bids) {
        this.bids = bids;
    }

    /**
     * @return the conditionID
     */
    public short getConditionID() {
        return conditionID;
    }

    /**
     * @param conditionID the conditionID to set
     */
    public void setConditionID(short conditionID) {
        this.conditionID = conditionID;
    }

    /**
     * @return the seller
     */
    public String getSeller() {
        return seller;
    }

    /**
     * @param seller the seller to set
     */
    public void setSeller(String seller) {
        this.seller = seller;
    }

    /**
     * @return the listingType
     */
    public String getListingType() {
        return listingType;
    }

    /**
     * @param listingType the listingType to set
     */
    public void setListingType(String listingType) {
        this.listingType = listingType;
    }

    /**
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the searchTerm
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * @param searchTerm the searchTerm to set
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    
    public boolean equals(EbayItem item) {
        if(item.ebayItemID == this.ebayItemID){
            return true;
        }
        return false;
    }
}
