package Dal;

import Model.Order;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author PC
 */
public class OrderDAO extends ConnectMySQL {

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

    public ArrayList<Order> GetOrderListByUserID(String userID, String Status) {
        ArrayList<Order> data = new ArrayList<>();
        try {
            String sqlSelect;
            if (Status.equals("All")) {
                Status = "";
            }
            sqlSelect = "SELECT p.name,p.picture, u.address, o.date,o.status, od.price-od.price*coalesce(salecodeRate/100,0), od.quantity, o.orderid,p.ProductID \n"
                    + "FROM swp.user u, swp.orderdetail od, swp.product p ,swp.order o left outer join swp.salecode sc on o.order_salecodeID=sc.salecodeID\n"
                    + "WHERE u.userID = o.order_userID and od.orderdetail_orderID = o.orderID \n"
                    + "and p.ProductID = od.orderdetail_productID  and userID =? and o.status like '%" + Status + "%' order by date desc;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(userID));
//            pstm.setString(2, Status);
            rs = pstm.executeQuery();
            while (rs.next()) {

                String productName = rs.getString(1);
                String picture = rs.getString(2);
                String address = rs.getString(3);
                String date = String.valueOf(rs.getTimestamp(4)).substring(0, 10);
                SimpleDateFormat sfDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                date = new SimpleDateFormat("dd-MM-yyyy").format(sfDateFormat.parse(date));
                String status = rs.getString(5);
                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                decimalFormat.applyPattern("#,###");
                String salePrice = String.valueOf(decimalFormat.format(rs.getDouble(6)).replace(",", "."));
                String quantity = String.valueOf(rs.getInt(7));
                String orderID = rs.getString(8);
                String productID = String.valueOf(rs.getInt(9));
                data.add(new Order(orderID, date, status, address, picture, salePrice, quantity, productName, productID, 0));
            }
            return data;
        } catch (Exception e) {
            System.out.println("GetOrderListByUserID: " + e);
        }
        return null;
    }

    public boolean addOrder(Order order) {
        try {
            String sqlSelect;
            if (order.getOrder_salecodeID() != null) {
                sqlSelect = "INSERT INTO `swp`.`order` (`order_userID`, `order_salecodeID`, `date`, `status`)\n"
                        + " VALUES (?, ?, ?, ?);";
                pstm = connection.prepareStatement(sqlSelect);
                pstm.setInt(1, Integer.parseInt(order.getOrder_userID()));
                pstm.setInt(2, Integer.parseInt(order.getOrder_salecodeID()));
                pstm.setTimestamp(3, Timestamp.valueOf(order.getDate()));
                pstm.setString(4, order.getStatus());
                pstm.execute();
            } else {
                sqlSelect = "INSERT INTO `swp`.`order` (`order_userID`,`date`, `status`)\n"
                        + " VALUES (?, ?, ?);";
                pstm = connection.prepareStatement(sqlSelect);
                pstm.setInt(1, Integer.parseInt(order.getOrder_userID()));
                pstm.setTimestamp(2, Timestamp.valueOf(order.getDate()));
                pstm.setString(3, order.getStatus());
                pstm.execute();
            }
            return true;
        } catch (Exception e) {
            System.out.println("addOrder: " + e);
        }
        return false;
    }

    public Order getOrderAfterAddByUserID(String userID) {
        try {
            String sqlSelect = " SELECT * FROM swp.order where order_userID=? \n"
                    + " order by date desc\n"
                    + " limit 1;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(userID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String orderID = String.valueOf(rs.getInt(1));
                String order_userID = String.valueOf(rs.getInt(2));
                String order_salecodeID = String.valueOf(rs.getInt(3));
                String note = String.valueOf(rs.getString(4));
                String date = String.valueOf(rs.getTimestamp(5));
                String status = String.valueOf(rs.getString(6));
                return new Order(orderID, order_userID, order_salecodeID, note, date, status);
            }
        } catch (Exception e) {
            System.out.println("getOrderAfterAdd: " + e);
        }
        return null;
    }

    public Order getOrderInTracking(String orderID, String orderdetail_productID) {
        try {
            String sqlSelect = "select o.orderID, o.order_userID, o.order_salecodeID, o.note, o.date, o.status, u.address,u.phone_number,od.orderdetail_productID\n"
                    + "     from `order` o, user u,orderdetail od \n"
                    + "     where o.order_userID = u.userID and od.orderdetail_orderID=o.orderID and o.orderID =? and od.orderdetail_productID=?";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(orderID));
            pstm.setInt(2, Integer.parseInt(orderdetail_productID));
            rs = pstm.executeQuery();
            while (rs.next()) {
//                String orderID = String.valueOf(rs.getInt(1));
                String order_userID = String.valueOf(rs.getInt(2));
                String order_salecodeID = String.valueOf(rs.getInt(3));
                String note = String.valueOf(rs.getString(4));
                String date = String.valueOf(rs.getTimestamp(5));
                String status = String.valueOf(rs.getString(6));
                String address = String.valueOf(rs.getString(7));
                String phone_number = String.valueOf(rs.getString(8));
                return new Order(orderID, order_userID, order_salecodeID, note, date, status, address, phone_number, orderdetail_productID);
            }
        } catch (Exception e) {
            System.out.println("getOrderInTracking: " + e);
        }
        return null;
    }

    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> data = new ArrayList<>();
        String sqlSelect = "SELECT * FROM swp.order";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrderID(String.valueOf(rs.getInt(1)));
                o.setOrder_userID(String.valueOf(rs.getInt(4)));
                o.setNote(rs.getString(5));
                data.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    public int CountOrder() {
        int count = 0;
        String sqlSelect = "SELECT COUNT(*) as 'count' FROM swp.order";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public int CountOrderCancelled() {
        int count = 0;
        String sqlSelect = "SELECT COUNT(*) as 'count' FROM swp.order\n"
                + "where status = 'Cancelled'";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
//        Timestamp datetime = new Timestamp(System.currentTimeMillis());
//        Order order = new Order("10", "2", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datetime), "Pending");
//        orderDAO.addOrder(order);
//        order = orderDAO.getOrderAfterAddByUserID("10");
//        System.out.println(order.getOrderID());
//        System.out.println(orderDAO.getOrderInTracking("77", "2").getAddress());
//        System.out.println(orderDAO.GetOrderListByUserID("6", "Completed").size());
//        System.out.println(orderDAO.GetOrderListByUserID("6","Completed").get(0).getOrderID());
//        System.out.println(orderDAO.GetOrderListByUserID("6","Completed").get(1).getOrderID());
//        System.out.println(orderDAO.GetOrderListByUserID("6","Completed").get(2).getOrderID());
        orderDAO.UpdateOrderByID("Shipping", "3");
    }
}
