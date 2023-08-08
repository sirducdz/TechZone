package Dal;

import Model.DetailOrder;
import Model.Feedback;
import Model.Order;
import Model.Products;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author laptop
 */
public class ManagerDAO extends ConnectMySQL {
    
    private ArrayList<Products> product;
    private ArrayList<Order> order;
    private ArrayList<Feedback> feedback;
    
    public ManagerDAO() {
    }
    
    public ArrayList<Products> getProduct() {
        return product;
    }
    
    public void setProduct(ArrayList<Products> product) {
        this.product = product;
    }
    
    public ArrayList<Order> getOrder() {
        return order;
    }
    
    public void setOrder(ArrayList<Order> order) {
        this.order = order;
    }
    
    public ArrayList<Feedback> getFeedback() {
        return feedback;
    }
    
    public void setFeedback(ArrayList<Feedback> feedback) {
        this.feedback = feedback;
    }
    
    DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    //PRODUCT MANAGER
    public ArrayList<Products> getAllProduct() {
        product = new ArrayList<>();
        String sql = "SELECT * FROM swp.product;";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            decimalFormat.applyPattern("#,###");
            dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            while (rs.next()) {
                String ProductID = String.valueOf(rs.getInt(1));
                String product_categoryID = String.valueOf(rs.getInt(2));
                String name = String.valueOf(rs.getString(3));
                String desciption = String.valueOf(rs.getString(4));
                String picture = String.valueOf(rs.getString(5));
                String picture2 = String.valueOf(rs.getString(6));
                String picture3 = String.valueOf(rs.getString(7));
                String price = String.valueOf(decimalFormat.format((int) rs.getFloat(8)));
                String quantity = String.valueOf(rs.getInt(9));
                String status = String.valueOf(rs.getInt(10));
                String date = String.valueOf(dateFormat.format(rs.getDate(12)));
                product.add(new Products(ProductID, product_categoryID, name, desciption, picture, price, quantity, status, picture2, picture3, date));
            }
            
        } catch (Exception e) {
            System.out.println("getAllProduct: " + e.getMessage());
        }
        return product;
    }
    
    public Products getProductsByID(String id) {
        try {
            String sqlSelect = "Select * from product where ProductID=" + id;
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            decimalFormat.applyPattern("#,###");
            dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            
            while (rs.next()) {
                Products p = new Products();
                p.setProductID(String.valueOf(rs.getInt(1)));
                String categories = String.valueOf(rs.getInt(2));
                p.setProduct_categoryID(categories);
                
                p.setName(String.valueOf(rs.getString(3)));
                p.setDesciption(String.valueOf(rs.getString(4)));
                p.setPicture(rs.getString(5));
                p.setPicture2(rs.getString(6));
                p.setPicture3(rs.getString(7));
                p.setPrice(String.valueOf(decimalFormat.format((int) rs.getFloat(8))));
                p.setQuantity(String.valueOf(rs.getInt(9)));
                p.setStatus(String.valueOf(rs.getInt(10)));
                p.setDate(String.valueOf(dateFormat.format(rs.getDate(12))));
                p.setCategories(new CategoriesDAO().getCategoryById(categories));
                return p;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public void addNewProduct(Products p) {
        try {
            String sql = "INSERT INTO swp.`product` "
                    + "(product_categoryID, name, desciption, picture, picture2, picture3, price, quantity, status,date) "
                    + "VALUES\n"
                    + " (?, ?, ?, ?, ?, \n"
                    + "?, ?, ?, ?, ?);";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(p.getProduct_categoryID()));
            pstm.setString(2, p.getName());
            pstm.setString(3, p.getDesciption());
            pstm.setString(4, p.getPicture());
            pstm.setString(5, p.getPicture2());
            pstm.setString(6, p.getPicture3());
            pstm.setFloat(7, Float.parseFloat(p.getPrice().replace(",", "")));
            pstm.setInt(8, Integer.parseInt(p.getQuantity()));
            pstm.setBoolean(9, p.getStatus().equals("1"));
            Date date = Date.valueOf(p.getDate());
            pstm.setDate(10, date);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("addNewProduct: " + e.getMessage());
        }
    }
    
    public void updateProduct(Products p) {
        try {
            String sql = "UPDATE product\n"
                    + "SET product_categoryID=?,name=?,desciption=?,picture=?,picture2=?,picture3=?,price=?,quantity=?,status=?,date=?\n"
                    + "WHERE productID=?;";
            System.out.println("p.getProduct_categoryID()" + p.getProduct_categoryID());
            System.out.println("p.getName()" + p.getName());
            System.out.println("p.getDesciption()" + p.getProduct_categoryID());
            System.out.println("p.getPicture()" + p.getPicture());
            System.out.println("p.getPicture2()" + p.getPicture2());
            System.out.println("p.getPicture3()" + p.getPicture3());
            System.out.println("p.getPrice()" + p.getPrice());
            System.out.println("p.getQuantity()" + p.getQuantity());
            System.out.println("p.getStatus()" + p.getStatus());
            System.out.println("p.getDate()" + p.getDate());
            System.out.println("p.getProductID()" + p.getProductID());
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(p.getProduct_categoryID()));
            pstm.setString(2, p.getName());
            pstm.setString(3, p.getDesciption());
            pstm.setString(4, p.getPicture());
            pstm.setString(5, p.getPicture2());
            pstm.setString(6, p.getPicture3());
            pstm.setFloat(7, Float.parseFloat(p.getPrice().replace(",", "")));
            pstm.setInt(8, Integer.parseInt(p.getQuantity()));
//            pstm.setBoolean(9, p.getStatus().equals("1"));
            pstm.setInt(9, Integer.parseInt(p.getStatus()));
            pstm.setDate(10, Date.valueOf(p.getDate()));
            pstm.setString(11, p.getProductID());
            
            pstm.execute();
        } catch (Exception ex) {
            System.out.println("updateProduct: " + ex);
        }
    }

    //ORDER MANAGER
    public ArrayList<Order> getListOrder() {
        order = new ArrayList<>();
        String sql = "SELECT o.*, u.name, SUM(od.price) \n"
                + "FROM swp.order o, swp.user u, swp.orderdetail od \n"
                + "WHERE u.userID=o.order_userID AND od.orderdetail_orderID = o.orderID \n"
                + "GROUP BY o.orderID \n"
                + "ORDER BY o.orderID desc;";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String orderID = String.valueOf(rs.getInt(1));
                String order_userID = String.valueOf(rs.getInt(2));
                String sale = String.valueOf(rs.getInt(3));
                String note = String.valueOf(rs.getString(4));
                String date = String.valueOf((rs.getTimestamp(5)));
                String status = rs.getString(6);
                String name_user = rs.getString(7);
                String price_order = String.valueOf(decimalFormat.format((int) rs.getFloat(8)));
                order.add(new Order(orderID, order_userID, sale, note, date, status, name_user, price_order));
            }
            
        } catch (Exception e) {
            System.out.println("getListOrder: " + e.getMessage());
        }
        return order;
    }
    
    public Order getOrderByID(String id) {
        try {
            String sqlSelect = "SELECT * FROM swp.order where orderID=" + id;
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String orderID = String.valueOf(rs.getInt(1));
                String order_userID = String.valueOf(rs.getInt(2));
                String sale = String.valueOf(rs.getInt(3));
                String note = String.valueOf(rs.getString(4));
                String date = String.valueOf(dateFormat.format(rs.getTimestamp(5)));
                String status = rs.getString(6);
                String name_user = rs.getString(7);
                String price_order = String.valueOf(rs.getInt(8));
                return (new Order(orderID, order_userID, sale, note, date, status, name_user, price_order));
            }
        } catch (Exception e) {
            System.out.println("getOrderByID: " + e.getMessage());
        }
        
        return null;
    }

    //ORDER DETAIL
    public ArrayList<DetailOrder> getAllDetailOrderByOrderID(String id) {
        ArrayList<DetailOrder> data = new ArrayList<>();
        try {
            String sqlSelect = "SELECT  u.name, u.phone_number, u.address, od.orderdetail_orderID,\n"
                    + "od.orderdetail_productID, od.orderdetailID, od.price, od.quantity, p.name, p.price, o.date\n"
                    + "FROM swp.user u, swp.orderdetail od, swp.product p ,swp.order o \n"
                    + "WHERE u.userID = o.order_userID and od.orderdetail_orderID = o.orderID \n"
                    + "and p.ProductID = od.orderdetail_productID  and orderid =" + id;
            decimalFormat.applyPattern("#,###");
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String name_user = rs.getString(1);
                String phone_number = rs.getString(2);
                String address = rs.getString(3);
                String orderdeatil_orderID = String.valueOf(rs.getInt(4));
                String orderdetail_productID = String.valueOf(rs.getInt(5));
                String orderdetailID = String.valueOf(rs.getInt(6));
                String price = String.valueOf(decimalFormat.format((int) (rs.getFloat(7))));
                System.out.println("price: " + price);
                String quantity = String.valueOf(rs.getInt(8));
                String name_product = rs.getString(9);
                String price_product = String.valueOf(decimalFormat.format((int) rs.getFloat(10)));
                String date = String.valueOf(dateFormat.format(rs.getTimestamp(11)));
                data.add(new DetailOrder(name_user, phone_number, address, orderdetailID, orderdeatil_orderID,
                        quantity, price, orderdetail_productID, name_product, price_product, date));
            }
        } catch (Exception e) {
            System.out.println("getAllOrderDetailByOrderID: " + e.getMessage());
        }
        return data;
    }
    
    public int sumPrice(int orderID) {
        String sql = "SELECT sum(price-price*coalesce(salecodeRate,0)/100) \n"
                + "FROM swp.salecode sc right outer join swp.order o on sc.salecodeID=o.order_salecodeID , swp.orderdetail od\n"
                + "where  od.orderdetail_orderID=o.orderID and o.orderID=?;";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, orderID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    //FEEDBACK
    public ArrayList<Feedback> getFeedbackList() {
        feedback = new ArrayList<>();
        try {
            String sqlSelectString = "select FeedbackID,f.FeedbackID_ProductID, feedbackID_userID, information,\n"
                    + "f.status, f.date, u.name,od.orderdetailID, p.name\n"
                    + "from feedback f,user u  ,orderdetail od  ,swp.order o, swp.product p \n"
                    + "where f.feedbackID_userID=u.userID  and u.userID=o.order_userID and p.ProductID = f.FeedbackID_ProductID\n"
                    + "and o.orderID=od.orderdetail_orderID and f.orderdetailID=od.orderdetailID;";
            pstm = connection.prepareStatement(sqlSelectString);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String FeedbackID = String.valueOf(rs.getInt(1));
                String FeedbackID_ProductID = String.valueOf(rs.getInt(2));
                String feedbackID_userID = String.valueOf(rs.getInt(3));
                String information = String.valueOf(rs.getString(4));
                String status = String.valueOf(rs.getString(5));
                String date = String.valueOf(dateFormat.format(rs.getTimestamp(6)));
                String username = String.valueOf(rs.getString(7));
                String orderdetailID = String.valueOf(rs.getInt(8));
                String productName = String.valueOf(rs.getString(9));
                feedback.add(new Feedback(FeedbackID, FeedbackID_ProductID, feedbackID_userID, information,
                        status, date, username, orderdetailID, productName));
            }
        } catch (Exception e) {
            System.out.println("getFeedbackList: " + e);
        }
        return feedback;
    }
    
    public void deleteFeedback(Timestamp date) {
        String sql = "DELETE FROM swp.feedback WHERE date=?;";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setTimestamp(1, (date));
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("deleteFB: " + e);
        }
    }

    //HOMEPAGE
    public int countProductByProductID() {
        int count = 0;
        try {
            String sqlSelectString = "SELECT count(ProductID) FROM swp.product;";
            pstm = connection.prepareStatement(sqlSelectString);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("countProductByProductID: " + e);
        }
        return count;
    }
    
    public int countOrder() {
        int count = 0;
        try {
            String sqlSelectString = "SELECT count(OrderID) FROM swp.order;";
            pstm = connection.prepareStatement(sqlSelectString);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("countOrder: " + e);
        }
        return count;
    }
    
    public int countProductStock() {
        int count = 0;
        try {
            String sqlSelectString = "select count(ProductID) from swp.product where quantity<5;";
            pstm = connection.prepareStatement(sqlSelectString);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("countProductStock: " + e);
        }
        return count;
    }
    
    public int countOrderCancelled() {
        int count = 0;
        String sqlSelect = "SELECT COUNT(*) FROM swp.order\n"
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
    
    public ArrayList<Order> getNewOrder() {
        order = new ArrayList<>();
        String sql = "select o.*,u.name,od.price from swp.order o, swp.orderdetail od, swp.user u\n"
                + "where od.orderdetail_orderID=o.orderID and u.userID=o.order_userID ORDER BY date DESC LIMIT 5;";
        decimalFormat.applyPattern("#,###");
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String orderID = String.valueOf(rs.getInt(1));
                String order_userID = String.valueOf(rs.getInt(2));
                String sale = String.valueOf(rs.getInt(3));
                String note = String.valueOf(rs.getString(4));
                String date = String.valueOf(dateFormat.format(rs.getTimestamp(5)));
                String status = rs.getString(6);
                String name_user = rs.getString(7);
                String price_order = String.valueOf(decimalFormat.format((int) rs.getFloat(8)));
                order.add(new Order(orderID, order_userID, order_userID, note, date, status, name_user, price_order));
            }
            
        } catch (Exception e) {
            System.out.println("getListOrder: " + e.getMessage());
        }
        return order;
    }
    
    public static void main(String[] args) {
        ManagerDAO dao = new ManagerDAO();
//        dao.deleteFeedback("2023-06-30 13:42:51");
        
    }
}
