
import java.text.DecimalFormat;

/**
 *
 * @author dealfinder
 */
public class EbayUser {

    private String userName;
    private int feedbackCount;
    private short feedbackPercentPositive;
    private String location;
    private String country;
    private int zipcode;
    private boolean topRated;

    public EbayUser(String userName, int feedbackCount, short feedbackPercent,
            String location, String country, int zipcode, boolean topRated) {
        this.userName = userName;
        this.feedbackCount = feedbackCount;
        this.feedbackPercentPositive = feedbackPercent;
        this.location = location;
        this.country = country;
        this.zipcode = zipcode;
        this.topRated = topRated;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the feedbackCount
     */
    public int getFeedbackCount() {
        return feedbackCount;
    }

    /**
     * @param feedbackCount the feedbackCount to set
     */
    public void setFeedbackCount(int feedbackCount) {
        this.feedbackCount = feedbackCount;
    }

    /**
     * @return the feedbackPercentPositive
     */
    public short getFeedbackPercentPositive() {
        return feedbackPercentPositive;
    }

    /**
     * @param feedbackPercentPositive the feedbackPercentPositive to set
     */
    public void setFeedbackPercentPositive(short feedbackPercentPositive) {
        this.feedbackPercentPositive = feedbackPercentPositive;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the zipcode
     */
    public int getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return the topRated
     */
    public boolean isTopRated() {
        return topRated;
    }

    /**
     * @param topRated the topRated to set
     */
    public void setTopRated(boolean topRated) {
        this.topRated = topRated;
    }

    public boolean equals(EbayUser user) {
        if (user.userName.equalsIgnoreCase(this.userName)) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        DecimalFormat percentFormat = new DecimalFormat("%0.0");
        return "User: " + userName +
                "\nFeedback Score: " + percentFormat.format(feedbackPercentPositive / 100.0) +
                "\nFeedback Count: " + feedbackCount +
                "\nLocation: " + location + 
                "\nZip: " + zipcode +
                "\nCountry: " + country +
                "\nTop Rated: " + topRated;
    }
}
