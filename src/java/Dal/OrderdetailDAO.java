package Dal;

import Model.Orderdetail;
import Model.User;

/**
 *
 * @author PC
 */
public class OrderdetailDAO extends ConnectMySQL {

    public boolean addOrderDetail(Orderdetail orderdetail) {
        try {
            String sqlSelect = "INSERT INTO `swp`.`orderdetail` (`orderdetail_orderID`, `quantity`, `price`, `orderdetail_productID`) VALUES (?, ?, ?, ?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(orderdetail.getOrderdetail_orderID()));
            pstm.setInt(2, Integer.parseInt(orderdetail.getQuantity()));
            pstm.setFloat(3, Float.parseFloat(orderdetail.getPrice()));
            pstm.setInt(4, Integer.parseInt(orderdetail.getOrderdetail_productID()));
            pstm.execute();
        } catch (Exception e) {
            System.out.println("addOrderDetail: " + e);
        }
        return false;
    }
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
        User user = new User();
        user.setUserID("10");
        
        String orderID = orderDAO.getOrderAfterAddByUserID(user.getUserID()).getOrderID();
        System.out.println(orderID);
        OrderdetailDAO orderdetailDAO = new OrderdetailDAO();
        Orderdetail orderdetail = new Orderdetail(orderID, "4", "8670000","2");
        
        orderdetailDAO.addOrderDetail(orderdetail);
    }
}
