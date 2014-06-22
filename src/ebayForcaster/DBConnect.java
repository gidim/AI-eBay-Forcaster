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
            con = DriverManager.getConnection("jdbc:mysql://" + LOCATION + "/"
                    + DATABASE, USER, PASSWORD);
            st = con.createStatement();

        } catch (ClassNotFoundException | SQLException ex) {
            ErrorHandler.handleError(ex, null);
        }
    }

    public void insertItems(ArrayList<Item> items) throws SQLException {
        for (Item i : items) {
            insertItem(i);
        }
    }

    public void insertItem(Item item) throws SQLException {

        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO item_list (item_number, name, manufacturer, "
                + "model, subcat_id, subcategory, timestamp, price, shipping, "
                + "review_count, review_score) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?) "
                + "ON DUPLICATE KEY "
                + "UPDATE item_number = VALUES(item_number), "
                + "name = VALUES(name), manufacturer = VALUES(manufacturer), "
                + "model = VALUES(model), subcat_id = VALUES(subcat_id), "
                + "subcategory = VALUES(subcategory), "
                + "timestamp = VALUES(timestamp), price = VALUES(price), "
                + "shipping = VALUES(shipping), review_count = VALUES(review_count), "
                + "review_score = VALUES(review_score);";

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, item.getItemNumber());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setString(3, item.getManufacturer());
            preparedStatement.setString(4, item.getModel());
            preparedStatement.setInt(5, item.getSubcatID());
            preparedStatement.setString(6, item.getSubcategory());
            preparedStatement.setTimestamp(7, getCurrentTimeStamp());
            preparedStatement.setInt(8, item.getPrice());
            preparedStatement.setInt(9, item.getShipping());
            preparedStatement.setInt(10, item.getReviewCount());
            preparedStatement.setShort(11, item.getReviewScore());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            ErrorHandler.handleError(e, "Item Number: " + item.getItemNumber());

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void insertEbayItem(EbayItem item) throws SQLException {

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
            ErrorHandler.handleError(e, "Ebay Item ID: " + item.getEbayItemID());

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void insertOBItem(OBItemStatus item) throws SQLException {

        PreparedStatement preparedStatement = null;

        boolean inStock = item.isInStock();
        String query;

        if (inStock) {
            query = "INSERT INTO ob_item_stats (item_number, ob_price, "
                    + "ob_shipping, last_updated, instock, last_instock) VALUES(?, "
                    + "?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY "
                    + "UPDATE item_number = VALUES(item_number), "
                    + "ob_price = VALUES(ob_price), ob_shipping = VALUES(ob_shipping), "
                    + "last_updated = VALUES(last_updated), instock = VALUES(instock),"
                    + "last_instock = VALUES(last_instock);";

        } else {
            query = "INSERT INTO ob_item_stats (item_number, ob_price, "
                    + "ob_shipping, last_updated, instock) VALUES(?, "
                    + "?, ?, ?, ?) "
                    + "ON DUPLICATE KEY "
                    + "UPDATE item_number = VALUES(item_number), "
                    + "ob_price = VALUES(ob_price), ob_shipping = VALUES(ob_shipping), "
                    + "last_updated = VALUES(last_updated), instock = VALUES(instock);";
        }
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, item.getItemNumber());
            preparedStatement.setInt(2, item.getPrice());
            preparedStatement.setInt(3, item.getShipping());
            preparedStatement.setTimestamp(4, getCurrentTimeStamp());
            preparedStatement.setBoolean(5, inStock);
            if (inStock) {
                preparedStatement.setTimestamp(6, getCurrentTimeStamp());
            }

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            ErrorHandler.handleError(e, "Item Number: " + item.getItemNumber());

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    public void insertSubcategory(int id, String[] cats) throws SQLException {

        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO newegg_categories (id, store, category, subcategory) "
                + "VALUES(?, ?, ?, ?) "
                + "ON DUPLICATE KEY "
                + "UPDATE id = VALUES(id), store = VALUES(store), "
                + "category = VALUES(category), subcategory = VALUES(subcategory);";

        try {
            preparedStatement = con.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, cats[0]);
            preparedStatement.setString(3, cats[1]);
            preparedStatement.setString(4, cats[2]);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            ErrorHandler.handleError(e, null);

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void insertEbayCategory(int catID, String catName) throws SQLException {

        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO ebay_categories (cat_id, cat_name) "
                + "VALUES(?, ?) "
                + "ON DUPLICATE KEY "
                + "UPDATE cat_id = VALUES(cat_id), cat_name = VALUES(cat_name);";

        try {
            preparedStatement = con.prepareStatement(query);

            preparedStatement.setInt(1, catID);
            preparedStatement.setString(2, catName);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            ErrorHandler.handleError(e, null);

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void insertEbayUser(EbayUser user) throws SQLException {

        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO ebay_user (user_name, feedback_count, "
                + "feedback_positive_percent, location, country, zip, top_rated) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY "
                + "UPDATE "
                + "feedback_count = VALUES(feedback_count), "
                + "feedback_positive_percent = VALUES(feedback_positive_percent),"
                + "location = VALUES(location),"
                + "country = VALUES(country),"
                + "zip = VALUES(zip),"
                + "top_rated = VALUES(top_rated);";

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setInt(2, user.getFeedbackCount());
            preparedStatement.setShort(3, user.getFeedbackPercentPositive());
            preparedStatement.setString(4, user.getLocation());
            preparedStatement.setString(5, user.getCountry());
            preparedStatement.setInt(6, user.getZipcode());
            preparedStatement.setBoolean(7, user.isTopRated());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            ErrorHandler.handleError(e, "Ebay User: " + user.getUserName());

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

    public ArrayList<String> getSubCatItems(int subcatID) throws SQLException {
        ArrayList<String> itemNumbers = new ArrayList<>();

        String query = "SELECT item_number FROM item_list WHERE subcat_id = '"
                + subcatID + "'";
        rs = st.executeQuery(query);

        while (rs.next()) {
            itemNumbers.add(rs.getString("item_number"));
        }

        return itemNumbers;
    }

    public ArrayList<Subcategory> getAllSubCats() throws SQLException {
        ArrayList<Subcategory> subCats = new ArrayList<>();

        String query = "SELECT id, store, category, subcategory FROM newegg_categories";
        rs = st.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id");
            String store = rs.getString("store");
            String category = rs.getString("category");
            String subcategory = rs.getString("subcategory");
            Subcategory temp = new Subcategory(id, store, category, subcategory);
            subCats.add(temp);
        }

        return subCats;
    }

    public String getSubCatName(int subcatID) throws SQLException {

        String query = "SELECT subcategory FROM newegg_categories WHERE id = '"
                + subcatID + "'";
        rs = st.executeQuery(query);

        if (rs.next()) {
            return rs.getString("subcategory");
        }
        return "";
    }

    public ArrayList<Item> getLimitedItemsBySubCat(int subCatID) throws SQLException {
        ArrayList<Item> items = new ArrayList<>();

        String query = "SELECT item_number, name, manufacturer, subcategory, price "
                + "FROM item_list "
                + "WHERE subcat_id = " + subCatID;
        rs = st.executeQuery(query);

        while (rs.next()) {
            String itemNum = rs.getString("item_number");
            String name = rs.getString("name");
            String manufacturer = rs.getString("manufacturer");
            String category = rs.getString("subcategory");
            int price = rs.getInt("price");
            Item temp = new Item(itemNum, name, manufacturer, category, price);
            items.add(temp);
        }

        return items;
    }

    public ArrayList<Item> getLimitedItemsBySearchString(String str) throws SQLException {
        ArrayList<Item> items = new ArrayList<>();

        String query = "SELECT item_number, name, manufacturer, subcategory, price "
                + "FROM item_list "
                + "WHERE item_number LIKE '%" + str + "%' "
                + "OR name LIKE '%" + str + "%' "
                + "OR manufacturer LIKE '%" + str + "%' "
                + "OR subcategory LIKE '%" + str + "%'";
        rs = st.executeQuery(query);

        while (rs.next()) {
            String itemNum = rs.getString("item_number");
            String name = rs.getString("name");
            String manufacturer = rs.getString("manufacturer");
            String category = rs.getString("subcategory");
            int price = rs.getInt("price");
            Item temp = new Item(itemNum, name, manufacturer, category, price);
            items.add(temp);
        }

        return items;
    }

    public ArrayList<Item> getLimitedItemsByItemNumber(String str) throws SQLException {
        ArrayList<Item> items = new ArrayList<>();

        String query = "SELECT item_number, name, manufacturer, subcategory, price "
                + "FROM item_list "
                + "WHERE item_number LIKE '" + str + "%'";
        rs = st.executeQuery(query);

        while (rs.next()) {
            String itemNum = rs.getString("item_number");
            String name = rs.getString("name");
            String manufacturer = rs.getString("manufacturer");
            String category = rs.getString("subcategory");
            int price = rs.getInt("price");
            Item temp = new Item(itemNum, name, manufacturer, category, price);
            items.add(temp);
        }

        return items;
    }

    public void getData() {
        try {

            String query = "SELECT * FROM people";
            rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("Name");
                String age = rs.getString("Age");
                System.out.println("Name: " + name + " Age: " + age);
            }

        } catch (SQLException ex) {
            ErrorHandler.handleError(ex, null);
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
