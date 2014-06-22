package ebayForcaster;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dealfinder
 */
public class DBConnect {

    String DRIVER = "com.mysql.jdbc.Driver";
    String LOCATION = "http://107.170.18.96/";
    String DATABASE = "Item";
    String USER = "ebay";
    String PASSWORD = "ebay3344";

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {
            try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				con = DriverManager.getConnection("jdbc:mysql://" + LOCATION + "/"
				        + DATABASE, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				st = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

    public void insertEbayItems(ArrayList<EbayItem> itemList) throws SQLException {

        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        for(EbayItem item : itemList){

        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO ebay_item_list (itemId, title,"
                + "categoryId, productId, postalCode, country, feedbackScore"
                + "positiveFeedbackPercent, feedbackRatingStar, topRatedSeller"
                + "shippingServiceCost, shippingType, expediatedShipping"
                + "oneDayShippingAvailable, handlingTime, convertedCurrentPrice,"
                + "bidCount, bestOfferEnabled, buyItNowAvailable, endTime,"
                + "listingType, returnsAccepted, conditionId, topRatedListing) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY "
                + "ebay_item_id = ebay_item_id;";

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, item.getEbayItemID());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setInt(3, item.getCatID());
            preparedStatement.setInt(4, item.getProductID());
            preparedStatement.setInt(5, item.getZipcode());
            preparedStatement.setString(6, item.getCountry());
            preparedStatement.setInt(7, item.getFeedbackCount());
            preparedStatement.setInt(8, item.getFeedbackPercentPositive());
            preparedStatement.setString(9, item.getFeedbackRatingStar());
            preparedStatement.setBoolean(10, item.isTopRatedSeller());
            preparedStatement.setInt(11, item.getShipping());
            preparedStatement.setString(12, item.getShippingType());
            preparedStatement.setBoolean(13, item.isExpediatedShipping());
            preparedStatement.setBoolean(14, item.isOneDayShippingAvailable());
            preparedStatement.setInt(15, item.getHandlingTime());
            preparedStatement.setInt(16, item.getPrice());
            preparedStatement.setInt(17, item.getBids());
            preparedStatement.setBoolean(18, item.isBestOffer());
            preparedStatement.setBoolean(19, item.isBuyItNow());
            preparedStatement.setString(20, sdf.format(item.getEndTime()));
            preparedStatement.setString(21, item.getListingType());
            preparedStatement.setBoolean(22, item.isReturnsAccepted());
            preparedStatement.setInt(23, item.getConditionID());
            preparedStatement.setBoolean(24, item.isTopRatedListing());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        }
    }


    @Override
    protected void finalize() throws Throwable {
        try {
            st.close();        // close open statement
            con.close();        // close open connection
        } finally {
            super.finalize();
        }
    }

}
