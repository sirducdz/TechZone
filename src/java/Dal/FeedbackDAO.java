package Dal;

import Model.Feedback;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class FeedbackDAO extends ConnectMySQL {

    public ArrayList<Feedback> getFeedbackListByProductId(String productID, String limit, String offset) {
        ArrayList<Feedback> data = new ArrayList<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String sqlSelect = " select FeedbackID,f.FeedbackID_ProductID, feedbackID_userID, information,\n"
                    + " f.status, f.date, name, od.product_rate,od.orderdetailID, od.quantity,od.orderdetail_orderID,od.orderdetail_productID,od.orderdetailID\n"
                    + " from feedback f,user u  ,orderdetail od  ,swp.order o\n"
                    + " where f.feedbackID_userID=u.userID  and u.userID=o.order_userID\n"
                    + " and o.orderID=od.orderdetail_orderID and f.orderdetailID=od.orderdetailID and od.orderdetail_productID=? order by f.date desc\n"
                    + "limit " + limit + " offset " + offset + "";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(productID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String FeedbackID = String.valueOf(rs.getInt(1));
                String FeedbackID_ProductID = String.valueOf(rs.getInt(2));
                String feedbackID_userID = String.valueOf(rs.getInt(3));
                String information = String.valueOf(rs.getString(4));
                String status = String.valueOf(rs.getInt(5));
                String date = null;
                if (rs.getTimestamp(6) != null) {
                    date = String.valueOf(dateFormat.format(rs.getTimestamp(6)));
                }
                String username = rs.getString(7);
                String product_rate = String.valueOf(new DecimalFormat("#.0").format(rs.getFloat(8)));
                if (rs.getFloat(8) - (int) rs.getFloat(8) == 0) {
                    product_rate = String.valueOf(new DecimalFormat("#").format(rs.getFloat(8)));
                }
                Feedback f = new Feedback(FeedbackID, FeedbackID_ProductID, feedbackID_userID, information, status, date, username, product_rate);
                data.add(f);
            }
        } catch (Exception e) {
            System.out.println("getFeedbackListByProductId: " + e);
        }
        return data;
    }

    public boolean checkBuyProductByUserID(String userID,String productid) {
        try {
//            String sqlSelect = "select* from swp.order o, orderdetail od,product p \n"
//                    + "where o.orderID=od.orderdetail_orderID  and od.orderdetail_productID=p.ProductID \n"
//                    + "and o.order_userID=?";
            String sqlSelect = "select* from swp.order o, orderdetail od,product p \n"
                    + "where o.orderID=od.orderdetail_orderID  and od.orderdetail_productID=p.ProductID \n"
                    + "and o.order_userID=? and ProductID=?";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(userID));
            pstm.setInt(2, Integer.parseInt(productid));
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkBuyProductByUserID: " + e);
        }
        return false;
    }
//     -- lấy orderdetailID mới nhất của người dùng về một product cụ thể 

    public String getLatestOrderdetailIDByProductIDAndUserId(String ProductID, String userID) {
        try {
            String sqlSelect = " select *  from orderdetail od,swp.order o\n"
                    + " where od.orderdetail_orderID = o.orderID and od.orderdetail_productID=? and o.order_userID=?\n"
                    + " order by o.date desc limit 1;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(ProductID));
            pstm.setInt(2, Integer.parseInt(userID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                return String.valueOf(rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println("getLatestOrderdetailID: " + e);
        }
        return null;
    }

    public void voteStar(String productRate, String orderDetailID) {
        try {
            String sqlSelect = "UPDATE `swp`.`orderdetail` SET `product_rate` = ? WHERE (`orderdetailID` = ?);";
        } catch (Exception e) {
            System.out.println("voteStar: " + e);
        }
    }

    public boolean addFeedback(Feedback feedback) {
        try {
            Timestamp datetime = new Timestamp(System.currentTimeMillis());
            String sqlSelect = "UPDATE `swp`.`orderdetail` SET `product_rate` = ? WHERE (`orderdetailID` = ?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setFloat(1, Float.parseFloat(feedback.getProduct_rate()));
            pstm.setInt(2, Integer.parseInt(feedback.getOrderdetailID()));
            pstm.execute();
            sqlSelect = "INSERT INTO `swp`.`feedback` (`FeedbackID_ProductID`, `feedbackID_userID`, `information`, `status`, `date`,`orderdetailID`) \n"
                    + "VALUES (?, ?, ?, '1',?,?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(feedback.getFeedbackID_ProductID()));
            pstm.setInt(2, Integer.parseInt(feedback.getFeedbackID_userID()));
            pstm.setString(3, feedback.getInformation());
            pstm.setTimestamp(4, datetime);
            pstm.setInt(5, Integer.parseInt(feedback.getOrderdetailID()));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addFeedback: " + e);
        }
        return false;
    }

    public static void main(String[] args) {
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        System.out.println("checkBuyProductByUserID: " + feedbackDAO.checkBuyProductByUserID("10",null));
//        System.out.println("getLatestOrderdetailIDByProductIDAndUserId: " + feedbackDAO.getLatestOrderdetailIDByProductIDAndUserId("1", "7"));
//        if (feedbackDAO.checkBuyProductByUserID("7")) {
//            String orderdetailID = feedbackDAO.getLatestOrderdetailIDByProductIDAndUserId("1", "7");
//            Feedback f = new Feedback();
//            f.setFeedbackID_ProductID("1");
//            f.setProduct_rate("5");
//            f.setOrderdetailID(orderdetailID);
//            f.setFeedbackID_userID("7");
//            f.setInformation("Con Lon Con1");
//            feedbackDAO.addFeedback(f);
//        }
//        for (Feedback feedback : feedbackDAO.getFeedbackLi    stByProductId("1")) {
//            System.out.println("FeedbackID: " + feedback.getFeedbackID());
//            System.out.println("FeedbackID_ProductID: " + feedback.getFeedbackID_ProductID());
//            System.out.println("feedbackID_userID: " + feedback.getFeedbackID_userID());
//            System.out.println("Infomation: " + feedback.getInformation());
//            System.out.println("status: " + feedback.getStatus());
//            System.out.println("date: " + feedback.getDate());
//            System.out.println("username: " + feedback.getUsername());
//            System.out.println("product_rate: " + feedback.getProduct_rate());
//            System.out.println("");
//        }
    }
}
