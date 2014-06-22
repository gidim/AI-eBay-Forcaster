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
    String LOCATION = "localhost";
    String DATABASE = "";
    String USER = "root";
    String PASSWORD = "";

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

    public void insertEbayItems(String jsonString) throws SQLException {

        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO ebay_item_list (ebay_item_id, newegg_item_number,"
                + "name, cat_id, product_id, thumb_image_url, price, shipping,"
                + "but_it_now, best_offer, bids, condition_id, seller, listing_type,"
                + "start_time, end_time, search_term) VALUES(?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY "
                + "ebay_item_id = ebay_item_id;";

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, item.getEbayItemID());
            preparedStatement.setString(2, item.getNeweggItemNumber());
            preparedStatement.setString(3, item.getName());
            preparedStatement.setInt(4, item.getCatID());
            preparedStatement.setInt(5, item.getProductID());
            preparedStatement.setString(6, item.getImageThumbURL());
            preparedStatement.setInt(7, item.getPrice());
            preparedStatement.setInt(8, item.getShipping());
            preparedStatement.setBoolean(9, item.isBuyItNow());
            preparedStatement.setBoolean(10, item.isBestOffer());
            preparedStatement.setShort(11, item.getBids());
            preparedStatement.setShort(12, item.getConditionID());
            preparedStatement.setString(13, item.getSeller());
            preparedStatement.setString(14, item.getListingType());
            preparedStatement.setString(15, sdf.format(item.getStartTime()));
            preparedStatement.setString(16, sdf.format(item.getEndTime()));
            preparedStatement.setString(17, item.getSearchTerm());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }


    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

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
