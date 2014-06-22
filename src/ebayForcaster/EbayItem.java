package ebayForcaster;

import java.util.Date;

/**
 *
 *
 */
public class EbayItem {
    
    private String ebayItemID;
    private String name;
    private int catID;
    private int productID;
    private int zipcode;
    private String country;
    private int feedbackCount;
    private int feedbackPercentPositive;
    private String feedbackRatingStar;
    private boolean topRatedSeller;
    private int shipping;
    private String shippingType;
    private boolean expediatedShipping;
    private boolean oneDayShippingAvailable;
    private int handlingTime;
    private int price;
    private int bids;
    private boolean bestOffer;
    private boolean buyItNow;
    private Date startTime;
    private Date endTime;
    private String listingType;
    private boolean returnsAccepted;
    private int conditionID;
    private boolean topRatedListing;

    
    

    /*
    public EbayItem(int ebayItemID, String name, int catID, int productID,
			int zipcode, String country, int feedbackCount,
			short feedbackPercentPositive, String feedbackRatingStar,
			boolean topRatedSeller, short shipping, String shippingType,
			boolean expediatedShipping, boolean oneDayShippingAvailable,
			int handlingTime, int price, short bids, boolean bestOffer,
			boolean buyItNow, Date startTime, Date endTime, String listingType,
			boolean returnsAccepted, int conditionID, boolean topRatedListing) {
		super();
		this.ebayItemID = ebayItemID;
		this.name = name;
		this.catID = catID;
		this.productID = productID;
		this.zipcode = zipcode;
		this.country = country;
		this.feedbackCount = feedbackCount;
		this.feedbackPercentPositive = feedbackPercentPositive;
		this.feedbackRatingStar = feedbackRatingStar;
		this.topRatedSeller = topRatedSeller;
		this.shipping = shipping;
		this.shippingType = shippingType;
		this.expediatedShipping = expediatedShipping;
		this.oneDayShippingAvailable = oneDayShippingAvailable;
		this.handlingTime = handlingTime;
		this.price = price;
		this.bids = bids;
		this.bestOffer = bestOffer;
		this.buyItNow = buyItNow;
		this.startTime = startTime;
		this.endTime = endTime;
		this.listingType = listingType;
		this.returnsAccepted = returnsAccepted;
		this.conditionID = conditionID;
		this.topRatedListing = topRatedListing;
	}

*/



	public int getEbayItemID() {
		return ebayItemID;
	}





	public void setEbayItemID(int ebayItemID) {
		this.ebayItemID = ebayItemID;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public int getCatID() {
		return catID;
	}





	public void setCatID(int catID) {
		this.catID = catID;
	}





	public int getProductID() {
		return productID;
	}





	public void setProductID(int productID) {
		this.productID = productID;
	}





	public int getZipcode() {
		return zipcode;
	}





	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}





	public String getCountry() {
		return country;
	}





	public void setCountry(String country) {
		this.country = country;
	}





	public int getFeedbackCount() {
		return feedbackCount;
	}





	public void setFeedbackCount(int feedbackCount) {
		this.feedbackCount = feedbackCount;
	}





	public int getFeedbackPercentPositive() {
		return feedbackPercentPositive;
	}





	public void setFeedbackPercentPositive(short feedbackPercentPositive) {
		this.feedbackPercentPositive = feedbackPercentPositive;
	}





	public String getFeedbackRatingStar() {
		return feedbackRatingStar;
	}





	public void setFeedbackRatingStar(String feedbackRatingStar) {
		this.feedbackRatingStar = feedbackRatingStar;
	}





	public boolean isTopRatedSeller() {
		return topRatedSeller;
	}





	public void setTopRatedSeller(boolean topRatedSeller) {
		this.topRatedSeller = topRatedSeller;
	}





	public int getShipping() {
		return shipping;
	}





	public void setShipping(int shipping) {
		this.shipping = shipping;
	}





	public String getShippingType() {
		return shippingType;
	}





	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}





	public boolean isExpediatedShipping() {
		return expediatedShipping;
	}





	public void setExpediatedShipping(boolean expediatedShipping) {
		this.expediatedShipping = expediatedShipping;
	}





	public boolean isOneDayShippingAvailable() {
		return oneDayShippingAvailable;
	}





	public void setOneDayShippingAvailable(boolean oneDayShippingAvailable) {
		this.oneDayShippingAvailable = oneDayShippingAvailable;
	}





	public int getHandlingTime() {
		return handlingTime;
	}





	public void setHandlingTime(int handlingTime) {
		this.handlingTime = handlingTime;
	}





	public int getPrice() {
		return price;
	}





	public void setPrice(int price) {
		this.price = price;
	}





	public int getBids() {
		return bids;
	}





	public void setBids(short bids) {
		this.bids = bids;
	}





	public boolean isBestOffer() {
		return bestOffer;
	}





	public void setBestOffer(boolean bestOffer) {
		this.bestOffer = bestOffer;
	}





	public boolean isBuyItNow() {
		return buyItNow;
	}





	public void setBuyItNow(boolean buyItNow) {
		this.buyItNow = buyItNow;
	}





	public Date getStartTime() {
		return startTime;
	}





	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}





	public Date getEndTime() {
		return endTime;
	}





	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}





	public String getListingType() {
		return listingType;
	}





	public void setListingType(String listingType) {
		this.listingType = listingType;
	}





	public boolean isReturnsAccepted() {
		return returnsAccepted;
	}





	public void setReturnsAccepted(boolean returnsAccepted) {
		this.returnsAccepted = returnsAccepted;
	}





	public int getConditionID() {
		return conditionID;
	}





	public void setConditionID(int conditionID) {
		this.conditionID = conditionID;
	}





	public boolean isTopRatedListing() {
		return topRatedListing;
	}





	public void setTopRatedListing(boolean topRatedListing) {
		this.topRatedListing = topRatedListing;
	}





	public boolean equals(EbayItem item) {
        if(item.ebayItemID == this.ebayItemID){
            return true;
        }
        return false;
    }
}
