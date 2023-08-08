package Dal;

import Model.Order;
import Model.Saler;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author trand
 */
public class SalerDAO extends ConnectMySQL {

    private ArrayList<User> user;

    public SalerDAO() {
    }

    public ArrayList<User> getUser() {
        return user;
    }


    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

    public List<User> getAllCustomer() {
        List<User> list = new ArrayList<>();
        String sql = "select * from user u where user_roleID = 3";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13)));
            }
        } catch (SQLException e) {
            System.out.println("Error getAllCustomer");
        }
        return list;
    }

    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList();

        String sql2 = "SELECT o.orderID, sum(coalesce(od.price, 0)) as total\n"
                + "FROM swp.order o join swp.orderdetail od on o.orderID = od.orderdetail_orderID join user  u on u.userID = o.order_userID\n"
                + "where o.orderID = ?\n"
                + "group by o.orderID";

        String sql1 = "select o.orderID, u.name, u.phone_number, u.address, o.date,  o.status  \n"
                + "from swp.order o join swp.orderdetail od on o.orderID = od.orderdetail_orderID \n"
                + "join user  u on u.userID = o.order_userID";

        try {
            pstm = connection.prepareStatement(sql1);
            rs = pstm.executeQuery();
            while (rs.next()) {

                PreparedStatement ps2 = connection.prepareStatement(sql2);
                ps2.setInt(1, Integer.parseInt(rs.getString(1)));
                ResultSet rs2 = ps2.executeQuery();
                String total = 0 + "";
                
                if (rs2.next()) {
                    if (rs2.getString(2) != null) {
                        total = rs2.getString(2);
                    }
                }
                total = String.format("%.0f", Double.parseDouble(total));
                list.add(new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), total, rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException e) {
            System.out.println("Error getAllOrder() ");
        }
        return list;
    }

    public boolean UpdateOrderByID(String status, String orderId) {
        try {
            String sqlSelect = "update swp.order o set o.status=? where orderid=?";
            pstm = connection.prepareCall(sqlSelect);
            pstm.setString(1, status);
            pstm.setInt(2, Integer.parseInt(orderId));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("UpdateOrderByID: " + e);
        }
        return false;
    }
//    public static void main(String[] args) {
//        System.out.println("");
//    }
}
