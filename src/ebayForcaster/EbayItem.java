package ebayForcaster;

import java.util.Date;

/**
 *
 *
 */
public class EbayItem {
    
    private String ebayItemID;
    private String name;
    private String catID;
    private String productID;
    private int zipcode;
    private String country;
    private int feedbackCount;
    double  feedbackPercentPositive;
    private String feedbackRatingStar;
    private boolean topRatedSeller;
    private double shippingPrice;
    private String shippingType;
    private boolean expediatedShipping;
    private boolean oneDayShippingAvailable;
    private int handlingTime;
    private double price;
    private int bids;
    private boolean bestOffer;
    private boolean buyItNow;
    private Date endTime;
    private String listingType;
    private boolean returnsAccepted;
    private int conditionID;
    private boolean topRatedListing;



    public EbayItem(){
        super();
    }

    public double getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public EbayItem(String ebayItemID, String name, String catID, String productID,
			int zipcode, String country, int feedbackCount,
			double feedbackPercentPositive, String feedbackRatingStar,
			boolean topRatedSeller, String shippingType, double shippingPrice,
			boolean expediatedShipping, boolean oneDayShippingAvailable,
			int handlingTime, double price, int bids, boolean bestOffer,
			boolean buyItNow, Date endTime, String listingType,
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
		this.shippingType = shippingType;
		this.expediatedShipping = expediatedShipping;
		this.oneDayShippingAvailable = oneDayShippingAvailable;
		this.handlingTime = handlingTime;
		this.price = price;
		this.bids = bids;
		this.bestOffer = bestOffer;
		this.buyItNow = buyItNow;
		this.endTime = endTime;
		this.listingType = listingType;
		this.returnsAccepted = returnsAccepted;
		this.conditionID = conditionID;
		this.topRatedListing = topRatedListing;
	}



	public String getEbayItemID() {
		return ebayItemID;
	}





	public void setEbayItemID(String ebayItemID) {
		this.ebayItemID = ebayItemID;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getCatID() {
		return catID;
	}





	public void setCatID(String catID) {
		this.catID = catID;
	}





	public String getProductID() {
		return productID;
	}





	public void setProductID(String productID) {
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





	public double getFeedbackPercentPositive() {
		return feedbackPercentPositive;
	}





	public void setFeedbackPercentPositive(double feedbackPercentPositive) {
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





	public double getPrice() {
		return price;
	}





	public void setPrice(double price) {
		this.price = price;
	}





	public int getBids() {
		return bids;
	}





	public void setBids(int bids) {
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

	@Override
	public String toString() {
		return "\n\nEbayItem [ebayItemID=" + ebayItemID + ", name=" + name
				+ ", catID=" + catID + ", productID=" + productID
				+ ", zipcode=" + zipcode + ", country=" + country
				+ ", feedbackCount=" + feedbackCount
				+ ", feedbackPercentPositive=" + feedbackPercentPositive
				+ ", feedbackRatingStar=" + feedbackRatingStar
				+ ", topRatedSeller=" + topRatedSeller + ", shippingPrice="
				+ shippingPrice + ", shippingType=" + shippingType
				+ ", expediatedShipping=" + expediatedShipping
				+ ", oneDayShippingAvailable=" + oneDayShippingAvailable
				+ ", handlingTime=" + handlingTime + ", price=" + price
				+ ", bids=" + bids + ", bestOffer=" + bestOffer + ", buyItNow="
				+ buyItNow + ", endTime=" + endTime + ", listingType="
				+ listingType + ", returnsAccepted=" + returnsAccepted
				+ ", conditionID=" + conditionID + ", topRatedListing="
				+ topRatedListing + "]";
	}
	
	
}
