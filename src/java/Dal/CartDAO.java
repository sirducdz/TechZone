package Dal;

import Model.Cart;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author DucPhaoLo
 */
public class CartDAO extends ConnectMySQL {

    public boolean DeleteCartByID(String cartID) {
        try {
            String sqlSelect = "DELETE FROM `swp`.`cart` WHERE (`cartID` = ?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(cartID));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("DeleteCartByID: " + e);
        }
        return false;
    }

    public boolean CheckProductCartByProductIDandUserID(String productID, String userID) {
        try {
            String sqlSelect = "select cartID,  c.title, c.price, c.quantity, totalcost,\n"
                    + "                     c.productID, c.userID, c.status,picture from cart c ,user u,product p \n"
                    + "                    where c.userID=u.userID and p.productID=c.productID and c.productID=? and c.userID=? ";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(productID));
            pstm.setInt(2, Integer.parseInt(userID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("CheckProductCartByProductIDandUserID: " + e);
        }
        return false;
    }

//    public boolean addDuplicateProduct(String userID,String productID) {
//        try {
//            boolean check dup
//            String sqlSelect = "select cartID,  c.title, price, quantity, totalcost,"
//                    + " productID, c.userID, c.status from cart c ,user u "
//                    + "where c.userID=u.userID and c.userID=? and productID=? ;";
//            pstm = connection.prepareStatement(sqlSelect);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                return true;
//            }
//        } catch (Exception e) {
//            System.out.println("CheckProductCartByProductIDandUserID: " + e);
//        }
//        return false;
//    }
    public int getQuantityExist(String productID, String userID) {
        int quantity = 0;
        try {
            String sqlSelect = "select distinct quantity from cart where productID=? and userID=?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(productID));
            pstm.setInt(2, Integer.parseInt(userID));
            rs = pstm.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getQuantityExist: " + e);
        }
        return quantity;
    }

    public void updateQuantity(String quantity, String cartid, String userid) {
        try {
            String sqlString = "update cart set quantity =? where cartid=? and userid=?";
            pstm = connection.prepareStatement(sqlString);
            pstm.setInt(1, Integer.parseInt(quantity));
            pstm.setInt(2, Integer.parseInt(cartid));
            pstm.setInt(3, Integer.parseInt(userid));
            pstm.execute();
        } catch (Exception e) {
            System.out.println("updateQuantity: " + e);
        }
    }

    public boolean AddOrUpdateCart(Cart cart) {
        try {
            int quantity;
            boolean checkDuplicateProduct = CheckProductCartByProductIDandUserID(cart.getProductID(), cart.getUserID());
            if (checkDuplicateProduct) {
                quantity = getQuantityExist(cart.getProductID(), cart.getUserID());
                cart.setQuantity(String.valueOf(Integer.parseInt(cart.getQuantity()) + quantity));
                updateCart(cart);
                return true;
            }
            String sqlSelect = "INSERT INTO `swp`.`cart` (`price`, `quantity`, `productID`, `userID`, `status`) VALUES (?, ?, ?, ?,?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setFloat(1, Float.parseFloat(cart.getPrice()));
            pstm.setInt(2, Integer.parseInt(cart.getQuantity()));
            pstm.setInt(3, Integer.parseInt(cart.getProductID()));// 
            pstm.setInt(4, Integer.parseInt(cart.getUserID()));
            pstm.setInt(5, Integer.parseInt(cart.getStatus()));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("AddOrUpdateCart: " + e);
        }
        return false;
    }

    public void updateCart(Cart cart) {
        try {
            String sqlString = "update cart set quantity =? where productid=? and userid=?";
            pstm = connection.prepareStatement(sqlString);
            pstm.setInt(1, Integer.parseInt(cart.getQuantity()));
            pstm.setInt(2, Integer.parseInt(cart.getProductID()));
            pstm.setInt(3, Integer.parseInt(cart.getUserID()));
            pstm.execute();
        } catch (Exception e) {
            System.out.println("updateCart: " + e);
        }
    }

    public String getTotalCostbyUserID(String userID) {// should not use this func
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
            String sqlString = "select sum(totalcost) from cart where userid =?\n"
                    + "                       group by userid";
            pstm = connection.prepareStatement(sqlString);
            pstm.setInt(1, Integer.parseInt(userID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                return String.valueOf(decimalFormat.format(rs.getFloat(1)));
            }
        } catch (Exception e) {
            System.out.println("setTotalCostbyUserID: " + e);
        }
        return null;
    }

    public String AmountOfProductTypeByUserID(String userID) {
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
            String sqlString = "select count(productID) from cart where userid =?\n"
                    + "                       group by userid";
            pstm = connection.prepareStatement(sqlString);
            pstm.setInt(1, Integer.parseInt(userID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                return String.valueOf(decimalFormat.format(rs.getInt(1)));
            }
        } catch (Exception e) {
            System.out.println("AmountOfProductTypeByUserID: " + e);
        }
        return null;
    }

    public float getTotalCostbyCartID(String cartID) {// should not use this func
        try {
            String sqlString = "select* from cart where cartid =?";
            pstm = connection.prepareStatement(sqlString);
            pstm.setInt(1, Integer.parseInt(cartID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getFloat(5);
            }
        } catch (Exception e) {
            System.out.println("getTotalCostbyCartID: " + e);
        }
        return 0;
    }

    public Cart getCartbyCartID(String cartID) {// should not use this func
        try {
            String sqlString = "select cartID,  c.title, c.price, c.quantity, totalcost,\n"
                    + "                                c.productID, c.userID, c.status,p.name,picture,p.quantity from cart c ,user u,product p \n"
                    + "                      where c.userID=u.userID and p.productID=c.productID and cartID=?";
            pstm = connection.prepareStatement(sqlString);
            pstm.setInt(1, Integer.parseInt(cartID));
            rs = pstm.executeQuery();
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
            while (rs.next()) {
                String title = String.valueOf(rs.getString(2));
                String price = String.valueOf(decimalFormat.format(rs.getFloat(3))).replaceAll(",", ".");
                String quantity = String.valueOf(rs.getInt(4));
                String totalcost = String.valueOf(decimalFormat.format(rs.getFloat(5))).replaceAll(",", ".");
                String productID = String.valueOf(rs.getInt(6));
                String userID = String.valueOf(rs.getInt(7));
                String status = String.valueOf(rs.getInt(8));
                String productName = String.valueOf(rs.getString(9));
                String picture = rs.getString(10);
                String product_Quantity = String.valueOf(rs.getString(11));
                Cart cart = new Cart(cartID, title, price, quantity, totalcost, productID, userID, status, productName, picture, product_Quantity);
                return cart;
            }
        } catch (Exception e) {
            System.out.println("getCartbyCartID: " + e);
        }
        return null;
    }

    public ArrayList<Cart> GetCartListByUserId(String userId) {
        ArrayList<Cart> data = new ArrayList<>();
        String sqlSelect = "select cartID,  c.title, c.price, c.quantity, totalcost,\n"
                + "                     c.productID, c.userID, c.status,p.name,picture,p.quantity from cart c ,user u,product p \n"
                + "                    where c.userID=u.userID and p.productID=c.productID and c.userID=? ";
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(userId));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String cartID = String.valueOf(rs.getInt(1));
                String title = String.valueOf(rs.getString(2));
                String price = String.valueOf(rs.getFloat(3));
                String quantity = String.valueOf(rs.getInt(4));
                String totalcost = String.valueOf(decimalFormat.format(rs.getFloat(5)));
              
                String productID = String.valueOf(rs.getInt(6));
                String userID = String.valueOf(rs.getInt(7));
                String status = String.valueOf(rs.getInt(8));
                String productName = String.valueOf(rs.getString(9));
                String picture = rs.getString(10);
                String product_Quantity = String.valueOf(rs.getString(11));
                data.add(new Cart(cartID, title, price, quantity, totalcost, productID, userID, status, productName, picture, product_Quantity));
            }
        } catch (Exception e) {
            System.out.println("GetCartListByUserId: " + e);
        }
        return data;
    }

    public static void main(String[] args) {
        CartDAO cartDAO = new CartDAO();
        Cart cart = cartDAO.getCartbyCartID("24");
        System.out.println(cart.getCartID());
        System.out.println(cart.getTitle());
        System.out.println(cart.getPrice());
        System.out.println(cart.getQuantity());
        System.out.println(cart.getTotalcost());
        System.out.println(cart.getProductID());
        System.out.println(cart.getUserID());
        System.out.println(cart.getStatus());
//        ArrayList<Cart> data = cartDAO.GetCartListByUserId("10");
//        Cart cart = new Cart(null, null, "2", "1", null, "1", "10", "1", null, null);
//        cartDAO.updateQuantity("121", "58", "10");
//        System.out.println(cartDAO.getTotalCostbyCartID("24"));
//        System.out.println(cartDAO.AmountOfProductTypeByUserID("10"));
//        Cart cart = new Cart();
//        cart.setUserID("10");
//        cart.setProductID("5");
//        cart.setQuantity("10");
//        System.out.println(cartDAO.AddOrUpdateCart(cart));
//        cartDAO.AddOrUpdateCart(cart);
//        cartDAO.getTotalCostbyUserID("10");
//        System.out.println(cartDAO.getTotalCostbyUserID("10"));

//        cartDAO.AddOrUpdateCart(cart);
//        cartDAO.updateCart(cart);
//        System.out.println(cartDAO.getQuantityExist("1", "10"));
//        System.out.println(data.size());
//        for (Cart cart : data) {
//            System.out.println(cart.getCartID());
//            System.out.println(cart.getPrice());
//            System.out.println(cart.getProductID());
//            System.out.println(cart.getQuantity());
//            System.out.println(cart.getStatus());
//            System.out.println(cart.getTitle());
//            System.out.println(cart.getTotalcost());
//            System.out.println(cart.getUserID());
//            System.out.println(cart.getProductName());
//            System.out.println(cart.getPicture());
//            System.out.println("");
//        }
    }
}
