package Dal;

import java.text.NumberFormat;
import java.util.Locale;
import Model.Categories;
import Model.Earphone;
import Model.Products;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

/**
 *
 * @author DucPhaoLo
 */
public class ProductDAO extends ConnectMySQL {

    public ArrayList<Earphone> getEarphoneListByCategoryIDAndNameAndSort(String categoryID, String Name, String sortOrder) {
        ArrayList<Earphone> data = new ArrayList<>();
        try {
            String sqlSelectString = "";
            if (categoryID == null || categoryID.isEmpty()) {
                if (sortOrder.equals("rate")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where p.name like '%" + Name + "%' \n"
                            + "group by productid order by rate desc";
                } else if (sortOrder.equals("ascendingSalePrice")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where p.name like '%" + Name + "%'\n"
                            + "group by productid order by SalePrice asc";
                } else if (sortOrder.equals("descendingSalePrice")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where p.name like '%" + Name + "%'\n"
                            + "group by productid order by SalePrice desc";
                }
            } else {
                if (sortOrder.equals("rate")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where product_categoryID=? and p.name like '%" + Name + "%'\n"
                            + "group by productid order by rate desc ";
                } else if (sortOrder.equals("ascendingSalePrice")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where product_categoryID=? and p.name like '%" + Name + "%'\n"
                            + "group by productid order by SalePrice asc ";
                } else if (sortOrder.equals("descendingSalePrice")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where product_categoryID=? and p.name like '%" + Name + "%'\n"
                            + "group by productid order by SalePrice desc ";
                }
            }
//            DecimalFormat decimalFormat = new DecimalFormat("#");
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
//            String formattedNumber = decimalFormat.format(number);
            pstm = connection.prepareStatement(sqlSelectString);
            if (categoryID != null && !categoryID.isEmpty()) {
                pstm.setInt(1, Integer.parseInt(categoryID));
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ProductID = String.valueOf(rs.getString(1));
                String name = String.valueOf(rs.getString(3));
                data.add(new Earphone(ProductID, name));
            }
        } catch (Exception e) {
            System.out.println("getEarphoneListByCategoryIDAndNameAndSort: " + e);
        }
        return data;
    }

    public ArrayList<Products> getProductListByCategoryIDAndNameAndSort(String categoryID, String Name, String sortOrder) {
        ArrayList<Products> data = new ArrayList<>();
        try {
            String sqlSelectString = "";
            if (categoryID == null || categoryID.isEmpty()) {
                if (sortOrder.equals("rate")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where p.name like '%" + Name + "%' \n"
                            + "group by productid order by rate desc";
                } else if (sortOrder.equals("ascendingSalePrice")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where p.name like '%" + Name + "%'\n"
                            + "group by productid order by SalePrice asc";
                } else if (sortOrder.equals("descendingSalePrice")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where p.name like '%" + Name + "%'\n"
                            + "group by productid order by SalePrice desc";
                }
            } else {
                if (sortOrder.equals("rate")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where product_categoryID=? and p.name like '%" + Name + "%'\n"
                            + "group by productid order by rate desc ";
                } else if (sortOrder.equals("ascendingSalePrice")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where product_categoryID=? and p.name like '%" + Name + "%'\n"
                            + "group by productid order by SalePrice asc ";
                } else if (sortOrder.equals("descendingSalePrice")) {
                    sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where product_categoryID=? and p.name like '%" + Name + "%'\n"
                            + "group by productid order by SalePrice desc ";
                }
            }
//            DecimalFormat decimalFormat = new DecimalFormat("#");
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
//            String formattedNumber = decimalFormat.format(number);
            pstm = connection.prepareStatement(sqlSelectString);
            if (categoryID != null && !categoryID.isEmpty()) {
                pstm.setInt(1, Integer.parseInt(categoryID));
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ProductID = String.valueOf(rs.getInt(1));
                String product_categoryID = String.valueOf(rs.getInt(2));
                String name = String.valueOf(rs.getString(3));
                String desciption = String.valueOf(rs.getString(4));
                String picture = String.valueOf(rs.getString(5));
                String price = String.valueOf(decimalFormat.format(rs.getFloat(6)));
                String quantity = String.valueOf(rs.getInt(7));
                String status = String.valueOf(rs.getInt(8));
                String sale = String.valueOf(decimalFormat.format(rs.getFloat(9)));
                String rateStar = String.valueOf(new DecimalFormat("#.0").format(rs.getFloat(10)));
                if (rs.getFloat(10) - (int) rs.getFloat(10) == 0) {
                    rateStar = String.valueOf(new DecimalFormat("#").format(rs.getFloat(10)));
                }
                String salePrice = String.valueOf(decimalFormat.format(rs.getDouble(11)));
                salePrice = salePrice.replaceAll(",", ".");
                String picture2 = String.valueOf(rs.getString(12));
                String picture3 = String.valueOf(rs.getString(13));
                data.add(new Products(ProductID, product_categoryID, name, desciption, picture, price, quantity, status, sale, rateStar, salePrice, picture2, picture3));
            }
        } catch (Exception e) {
            System.out.println("getProductListByCategoryIDAndNameAndSort: " + e);
        }
        return data;
    }

    public ArrayList<Products> BestSellerProducts() {
        ArrayList<Products> data = new ArrayList<>();

        CategoriesDAO categoriesDAO = new CategoriesDAO();
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
        decimalFormat.applyPattern("#,###");
        ArrayList<Categories> categoryIdList = categoriesDAO.GetCategoriesList();
        try {
            for (Categories c : categoryIdList) {
                ArrayList<String> productidList = new ArrayList<>();
                // find most rate productId
                String sqlSelect = "select p.productid,coalesce(sum(product_rate)/count(product_rate),0) 'rate'  \n"
                        + "from swp.orderdetail od right outer join swp.product p\n"
                        + "on p.ProductID=od.orderdetail_productID where product_categoryID=?\n"
                        + "group by p.productid\n"
                        + "order by rate desc\n"
                        + "limit 2; ";
                pstm = connection.prepareStatement(sqlSelect);
                pstm.setInt(1, Integer.parseInt(c.getCategoryID()));
                rs = pstm.executeQuery();
                while (rs.next()) {
                    String orderdetail_productid = String.valueOf(rs.getInt(1));
                    productidList.add(orderdetail_productid);
                }
                // maxrate productdetail
                int count = 0;
                while (count < productidList.size()) {
                    String sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                            + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                            + "from swp.orderdetail od right outer join swp.product p\n"
                            + "on p.ProductID=od.orderdetail_productID where p.ProductID=? -- where product_categoryID='1'\n"
                            + "group by productid ";
                    pstm = connection.prepareStatement(sqlSelectString);
                    pstm.setInt(1, Integer.parseInt(productidList.get(count)));
                    rs = pstm.executeQuery();
                    while (rs.next()) {
                        String ProductID = String.valueOf(rs.getInt(1));
                        String product_categoryID = String.valueOf(rs.getInt(2));
                        String name = String.valueOf(rs.getString(3));
                        String desciption = String.valueOf(rs.getString(4));
                        String picture = String.valueOf(rs.getString(5));
                        String price = String.valueOf(decimalFormat.format(rs.getFloat(6)));
                        String quantity = String.valueOf(rs.getInt(7));
                        String status = String.valueOf(rs.getInt(8));
                        String sale = String.valueOf(decimalFormat.format(rs.getFloat(9)));
                        String rateStar = String.valueOf(new DecimalFormat("#.0").format(rs.getFloat(10)));
                        if (rs.getFloat(10) - (int) rs.getFloat(10) == 0) {
                            rateStar = String.valueOf(new DecimalFormat("#").format(rs.getFloat(10)));
                        }
                        String salePrice = String.valueOf(decimalFormat.format(rs.getDouble(11)));
                        salePrice = salePrice.replaceAll(",", ".");
                        String picture2 = String.valueOf(rs.getString(12));
                        String picture3 = String.valueOf(rs.getString(13));
                        data.add(new Products(ProductID, product_categoryID, name, desciption, picture, price, quantity, status, sale, rateStar, salePrice, picture2, picture3));
                    }
                    ++count;
                }
            }
        } catch (Exception e) {
            System.out.println("BestSellerProductsByCategoryID: " + e);
        }
        return data;
    }

    public ArrayList<Products> getProductListByType(String type) {
        ArrayList<Products> data = new ArrayList<>();
        try {
            String sqlSelectString;
            if (type.equals("HighPrice")) {
                sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                        + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                        + "from swp.earphone e, swp.orderdetail od right outer join swp.product p \n"
                        + "on p.ProductID=od.orderdetail_productID  where e.earphone_ProductID=p.ProductID and COALESCE(p.price-p.price*p.sale/100,p.price) >'1000000'\n"
                        + "group by productid ,e.type\n"
                        + "order by rate desc;";
            } else {
                sqlSelectString = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                        + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                        + "from swp.earphone e, swp.orderdetail od right outer join swp.product p \n"
                        + "on p.ProductID=od.orderdetail_productID  where e.earphone_ProductID=p.ProductID and e.type=?\n"
                        + "group by productid ,e.type\n"
                        + "order by rate desc;";
            }
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
            pstm = connection.prepareStatement(sqlSelectString);
            if (!type.equals("HighPrice")) {
                pstm.setString(1, type);
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ProductID = String.valueOf(rs.getInt(1));
                String product_categoryID = String.valueOf(rs.getInt(2));
                String name = String.valueOf(rs.getString(3));
                String desciption = String.valueOf(rs.getString(4));
                String picture = String.valueOf(rs.getString(5));
                String price = String.valueOf(decimalFormat.format(rs.getFloat(6)));
                String quantity = String.valueOf(rs.getInt(7));
                String status = String.valueOf(rs.getInt(8));
                String sale = String.valueOf(decimalFormat.format(rs.getFloat(9)));
                String rateStar = String.valueOf(new DecimalFormat("#.0").format(rs.getFloat(10)));
                if (rs.getFloat(10) - (int) rs.getFloat(10) == 0) {
                    rateStar = String.valueOf(new DecimalFormat("#").format(rs.getFloat(10)));
                }
                String salePrice = String.valueOf(decimalFormat.format(rs.getDouble(11)));
                salePrice = salePrice.replaceAll(",", ".");
                String picture2 = String.valueOf(rs.getString(12));
                String picture3 = String.valueOf(rs.getString(13));
                data.add(new Products(ProductID, product_categoryID, name, desciption, picture, price, quantity, status, sale, rateStar, salePrice, picture2, picture3));
            }
        } catch (Exception e) {
            System.out.println("getProductListByType: " + e);
        }
        return data;
    }

    public Products getProductByID(String productID) {
        try {
            String sqlSelect = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                    + "COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                    + "from swp.orderdetail od right outer join swp.product p\n"
                    + "on p.ProductID=od.orderdetail_productID where p.ProductID=? \n"
                    + "group by productid ";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(productID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ProductID = String.valueOf(rs.getInt(1));
                String product_categoryID = String.valueOf(rs.getInt(2));
                String name = String.valueOf(rs.getString(3));
                String desciption = String.valueOf(rs.getString(4));
                String picture = String.valueOf(rs.getString(5));
                String price = String.valueOf((rs.getFloat(6)));
                String quantity = String.valueOf(rs.getInt(7));
                String status = String.valueOf(rs.getInt(8));
                String sale = String.valueOf((rs.getFloat(9)));
                String rateStar = String.valueOf(new DecimalFormat("#.0").format(rs.getFloat(10)));
                if (rs.getFloat(10) - (int) rs.getFloat(10) == 0) {
                    rateStar = String.valueOf(new DecimalFormat("#").format(rs.getFloat(10)));
                }
                String salePrice = String.valueOf((rs.getDouble(11)));
                salePrice = salePrice.replaceAll(",", ".");
                String picture2 = String.valueOf(rs.getString(12));
                String picture3 = String.valueOf(rs.getString(13));
                Products p = new Products(ProductID, product_categoryID, name, desciption, picture, price, quantity, status, sale, rateStar, salePrice, picture2, picture3);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getProductByID: " + e);
        }
        return null;
    }

    public Earphone getProductByIDComPare(String productID) {
        try {
            String sqlSelect = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                    + "                    COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3,\n"
                    + "                    earphoneID, e.type, frequency, e.sensitive, impedance, meterial, earphone_ProductID, size, battery, connection_distance, wire_length\n"
                    + "                    from swp.orderdetail od right outer join swp.product p left outer join swp.earphone e on p.ProductID = e.earphone_ProductID\n"
                    + "                    on p.ProductID=od.orderdetail_productID where p.ProductID=?\n"
                    + "                    group by productid,earphoneID";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(productID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String ProductID = String.valueOf(rs.getInt(1));
                String product_categoryID = String.valueOf(rs.getInt(2));
                String name = String.valueOf(rs.getString(3));
                String desciption = String.valueOf(rs.getString(4));
                String picture = String.valueOf(rs.getString(5));
                String price = String.valueOf((rs.getFloat(6)));
                String quantity = String.valueOf(rs.getInt(7));
                String status = String.valueOf(rs.getInt(8));
                String sale = String.valueOf((rs.getFloat(9)));
                String rateStar = String.valueOf(new DecimalFormat("#.0").format(rs.getFloat(10)));
                if (rs.getFloat(10) - (int) rs.getFloat(10) == 0) {
                    rateStar = String.valueOf(new DecimalFormat("#").format(rs.getFloat(10)));
                }
                String salePrice = String.valueOf((rs.getDouble(11)));
                salePrice = salePrice.replaceAll(",", ".");
                String picture2 = String.valueOf(rs.getString(12));
                String picture3 = String.valueOf(rs.getString(13));
                String earphoneID = String.valueOf(rs.getInt(14));
                String type = rs.getString(15);
                String frequency = String.valueOf(rs.getFloat(16));
                String sensitive = String.valueOf(rs.getFloat(17));
                String impedance = String.valueOf(rs.getFloat(18));
                String meterial = String.valueOf(rs.getString(19));
                String earphone_ProductID = String.valueOf(rs.getInt(20));
                String size = String.valueOf(rs.getString(21));
                String battery = String.valueOf(rs.getString(22));
                String connection_distance = String.valueOf(rs.getString(23));
                String wire_length = String.valueOf(rs.getString(24));
                Earphone e = new Earphone(ProductID, product_categoryID, name, desciption, picture, price, quantity, status, sale, rateStar, salePrice, picture2, picture3, earphoneID, type, frequency, sensitive, impedance, meterial, earphone_ProductID, size, battery, connection_distance, wire_length);
                return e;
            }
        } catch (Exception e) {
            System.out.println("getProductByIDComPare: " + e);
        }
        return null;
    }

    public boolean decreaseProductAmount(String productID, String quantity) {
        try {
            Products p = getProductByID(productID);
            String sqlSelect = "update product set quantity =?  where productid =?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(p.getQuantity()) - Integer.parseInt(quantity));
            pstm.setInt(2, Integer.parseInt(productID));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("decreaseProductAmount: " + e);
        }
        return false;
    }

    public List<Products> searchProducts(String sort) {

        List<Products> data = new ArrayList<>();
        try {
            String sqlSelect = "Select * from product ";
            if ("1".equals(sort)) {
                sqlSelect += "order by date asc";
            } else if ("2".equals(sort)) {
                sqlSelect += "order by date desc";
            }
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
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
                p.setPrice(String.valueOf(rs.getFloat(8)));
                p.setQuantity(String.valueOf(rs.getInt(9)));
                p.setStatus(String.valueOf(rs.getInt(10)));
                p.setDate(String.valueOf(rs.getDate(12)));
                p.setCategories(new CategoriesDAO().getCategoryById(categories));
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    public Products getProductsByID(String id) {

        try {
            String sqlSelect = "Select * from product where ProductID=" + id;
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Products p = new Products();
                p.setProductID(String.valueOf(rs.getInt(1)));
                String categories = String.valueOf(rs.getInt(2));
                p.setProduct_categoryID(categories);

                p.setName(String.valueOf(rs.getString(3)));
                p.setDesciption(String.valueOf(rs.getString(4)));
                p.setPicture(rs.getString(5));
                p.setPicture2(rs.getString(6));
                p.setPicture3(rs.getString(7));
                p.setPrice(String.valueOf(rs.getFloat(8)));
                p.setQuantity(String.valueOf(rs.getInt(9)));
                p.setStatus(String.valueOf(rs.getInt(10)));
                p.setDate(String.valueOf(rs.getDate(12)));
                p.setCategories(new CategoriesDAO().getCategoryById(categories));
                return p;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public Earphone getEarphoneByProductID(String id) {

        try {
            String sqlSelect = "Select * from earphone where earphone_ProductID=" + id;
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Earphone e = new Earphone();
                e.setType(String.valueOf(rs.getString(2)));
                e.setFrequency(String.valueOf(rs.getFloat(3)));
                e.setSensitive(String.valueOf(rs.getFloat(4)));
                e.setImpedance(String.valueOf(rs.getFloat(5)));
                e.setMeterial(String.valueOf(rs.getString(6)));
                e.setSize(String.valueOf(rs.getString(8)));
                e.setBattery(String.valueOf(rs.getString(9)));
                e.setConnection_distance(String.valueOf(rs.getString(10)));
                e.setWire_length(String.valueOf(rs.getString(11)));

                return e;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public void updateProduct(Products p) {
        try {
//            String sql = "UPDATE product\n"
//                    + "SET product_categoryID=?,name=?,desciption=?,picture=?,picture2=?,picture3=?,price=?,quantity=?,status=?\n"
//                    + "WHERE productID=?;";
            String sql = "UPDATE product\n"
                    + "SET product_categoryID=?,name=?,desciption=?,picture=?,picture2=?,picture3=?,price=?,quantity=?,status=?,date=?\n"
                    + "WHERE productID=?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(p.getProduct_categoryID()));
//            stm.setInt(1, Integer.parseInt("1"));
            stm.setString(2, p.getName());
            stm.setString(3, p.getDesciption());
            stm.setString(4, p.getPicture());
            stm.setString(5, p.getPicture2());
            stm.setString(6, p.getPicture3());
            stm.setFloat(7, Float.parseFloat(p.getPrice()));
            stm.setInt(8, Integer.parseInt(p.getQuantity()));
            stm.setBoolean(9, p.getStatus().equals("1"));
            stm.setDate(10, Date.valueOf(p.getDate()));
            stm.setString(11, p.getProductID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEarphone(Earphone e) {
        try {
//            
            String sql = "UPDATE swp.earphone SET `type`=?,frequency=?,"
                    + "`sensitive`=?,impedance=?,meterial=?,size=?,battery=?,"
                    + "connection_distance=?,wire_length=? "
                    + "where earphone_ProductID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, Integer.parseInt(p.getProduct_categoryID()));
            stm.setString(1, e.getType());
            stm.setFloat(2, Float.parseFloat(e.getFrequency()));
            stm.setFloat(3, Float.parseFloat(e.getSensitive()));
            stm.setFloat(4, Float.parseFloat(e.getImpedance()));
            stm.setString(5, e.getMeterial());
            stm.setString(6, e.getSize());
            stm.setString(7, e.getBattery());
            stm.setString(8, e.getConnection_distance());
            stm.setString(9, e.getWire_length());
            stm.setString(10, e.getEarphone_ProductID());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewProduct(Products p) {
        try {
            String sql = "INSERT INTO swp.`product` "
                    + "(product_categoryID, name, desciption, picture, picture2, picture3, price, quantity, status,date) "
                    + "VALUES\n"
                    + " (?, ?, ?, ?, ?, \n"
                    + "?, ?, ?, ?, ?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(p.getProduct_categoryID()));
            stm.setString(2, p.getName());
            stm.setString(3, p.getDesciption());
            stm.setString(4, p.getPicture());
            stm.setString(5, p.getPicture2());
            stm.setString(6, p.getPicture3());
            stm.setFloat(7, Float.parseFloat(p.getPrice()));
            stm.setInt(8, Integer.parseInt(p.getQuantity()));
            stm.setBoolean(9, p.getStatus().equals("1"));
            Date date = Date.valueOf(p.getDate());
            stm.setDate(10, date);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addNewEarphone(Earphone e) {
        try {
            String sql = "INSERT INTO swp.`earphone` "
                    + "(`type`,frequency,`sensitive`,impedance,meterial,size,battery,connection_distance,wire_length, earphone_ProductID) "
                    + "VALUES\n"
                    + " (?, ?, ?, ?, ?, \n"
                    + "?, ?, ?, ?, ?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, e.getType());
            stm.setFloat(2, Float.parseFloat(e.getFrequency()));
            stm.setFloat(3, Float.parseFloat(e.getSensitive()));
            stm.setFloat(4, Float.parseFloat(e.getImpedance()));
            stm.setString(5, e.getMeterial());
            stm.setString(6, e.getSize());
            stm.setString(7, e.getBattery());
            stm.setString(8, e.getConnection_distance());
            stm.setString(9, e.getWire_length());
            stm.setString(10, e.getEarphone_ProductID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getLastId() {
        try {
            String sql = "SELECT * FROM swp.product ORDER BY ProductID DESC LIMIT 1";
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {

                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public int CountProduct() {
        int count = 0;
        String sqlSelect = "SELECT COUNT(*) as 'count' FROM product";
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

    public int CountProductOut() {
        int count = 0;
        String sqlSelect = "SELECT COUNT(*) as 'count' FROM product\n"
                + "where quantity = 0;";
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

    public int totalIncome() {
        int total = 0;
        String sqlSelect = "SELECT SUM(od.quantity*p.price) as 'total' FROM \n"
                + "swp.orderdetail od\n"
                + "join product p \n"
                + "on od.orderdetail_productID = p.ProductID \n"
                + "join `order` o on od.orderdetail_orderID= o.orderID \n"
                + "where o.status='Completed'";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return total;
    }

    public ArrayList<Products> limitProducts() {
        ArrayList<Products> data = new ArrayList<>();
        try {
            String sqlSelect = "Select * from product\n"
                    + "where quantity = 0";
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
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
                p.setPrice(String.valueOf(rs.getFloat(8)));
                p.setQuantity(String.valueOf(rs.getInt(9)));
                p.setStatus(String.valueOf(rs.getInt(10)));
                p.setCategories(new CategoriesDAO().getCategoryById(categories));
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    public int totalIncomeByMonth(int month) {
        int total = 0;
        String sqlSelect = "SELECT SUM(od.quantity*p.price) as 'total' FROM \n"
                + "swp.orderdetail od\n"
                + "join product p \n"
                + "on od.orderdetail_productID = p.ProductID \n"
                + "join `order` o on od.orderdetail_orderID= o.orderID \n"
                + "where Month(o.date) = ? and o.status='Completed'";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, month);
            rs = pstm.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return total;
    }

    public int countMouseByMonth(int month) {
        int total = 0;
        String sqlSelect = "SELECT SUM(od.quantity) AS total \n"
                + "FROM orderdetail od \n"
                + "JOIN product p ON od.orderdetail_productID = p.ProductID\n"
                + "JOIN `order` o ON od.orderdetail_orderID = o.orderID\n"
                + "WHERE MONTH(o.date) = ? \n"
                + "AND p.product_categoryID = 3 AND o.status='Completed'";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, month);
            rs = pstm.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return total;
    }
    
    public int countKeyBoardByMonth(int month) {
        int total = 0;
        String sqlSelect = "SELECT SUM(od.quantity) AS total \n"
                + "FROM orderdetail od \n"
                + "JOIN product p ON od.orderdetail_productID = p.ProductID\n"
                + "JOIN `order` o ON od.orderdetail_orderID = o.orderID\n"
                + "WHERE MONTH(o.date) = ? \n"
                + "AND p.product_categoryID = 2 AND o.status='Completed'";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, month);
            rs = pstm.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return total;
    }
    
    public int countEarPhoneByMonth(int month) {
        int total = 0;
        String sqlSelect = "SELECT SUM(od.quantity) AS total \n"
                + "FROM orderdetail od \n"
                + "JOIN product p ON od.orderdetail_productID = p.ProductID\n"
                + "JOIN `order` o ON od.orderdetail_orderID = o.orderID\n"
                + "WHERE MONTH(o.date) = ? \n"
                + "AND p.product_categoryID = 1 AND o.status='Completed'";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, month);
            rs = pstm.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return total;
    }

    public String getCategoryIDByProductID(String productID) {
        try {
            String sqlSelect = "select product_categoryID from product where productid=?";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(productID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                return String.valueOf(rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println("getCategoryIDByProductID: " + e);
        }
        return null;
    }

    public ArrayList<Products> GetProductListByCategoryID(String CategoryID) {
        ArrayList<Products> data = new ArrayList<>();
        try {
            String sqlSelect;
            if (CategoryID == null || CategoryID.isEmpty()) {
                sqlSelect = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                        + "                        COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                        + "                       from swp.earphone e, swp.orderdetail od right outer join swp.product p \n"
                        + "                        on p.ProductID=od.orderdetail_productID \n"
                        + "                       group by productid \n"
                        + "                       order by rate desc;";
            } else {
                sqlSelect = "select p.ProductID, p.product_categoryID, p.name, p.desciption, p.picture, p.price, p.quantity, p.status,coalesce( p.sale,0) 'sale',\n"
                        + "                        COALESCE(sum(product_rate)/count(product_rate) ,0) 'rate',COALESCE(p.price-p.price*p.sale/100,p.price) 'saleprice',picture2,picture3\n"
                        + "                       from swp.earphone e, swp.orderdetail od right outer join swp.product p \n"
                        + "                        on p.ProductID=od.orderdetail_productID  where product_categoryID=? \n"
                        + "                       group by productid \n"
                        + "                       order by rate desc;";
            }
            pstm = connection.prepareStatement(sqlSelect);
            if (CategoryID != null && !CategoryID.isEmpty()) {
                pstm.setInt(1, Integer.parseInt(CategoryID));
            }
            rs = pstm.executeQuery();
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
            while (rs.next()) {
                String ProductID = String.valueOf(rs.getInt(1));
                String product_categoryID = String.valueOf(rs.getInt(2));
                String name = String.valueOf(rs.getString(3));
                String desciption = String.valueOf(rs.getString(4));
                String picture = String.valueOf(rs.getString(5));
                String price = String.valueOf(decimalFormat.format(rs.getFloat(6)));
                String quantity = String.valueOf(rs.getInt(7));
                String status = String.valueOf(rs.getInt(8));
                String sale = String.valueOf(decimalFormat.format(rs.getFloat(9)));
                String rateStar = String.valueOf(new DecimalFormat("#.0").format(rs.getFloat(10)));
                if (rs.getFloat(10) - (int) rs.getFloat(10) == 0) {
                    rateStar = String.valueOf(new DecimalFormat("#").format(rs.getFloat(10)));
                }
                String salePrice = String.valueOf(decimalFormat.format(rs.getDouble(11)));
                salePrice = salePrice.replaceAll(",", ".");
                String picture2 = String.valueOf(rs.getString(12));
                String picture3 = String.valueOf(rs.getString(13));
                data.add(new Products(ProductID, product_categoryID, name, desciption, picture, price, quantity, status, sale, rateStar, salePrice, picture2, picture3));
            }
            return data;
        } catch (Exception e) {
            System.out.println("GetProductListByCategoryID: " + e);
        }
        return null;
    }

    public int RandDomNumber(int Length) {
        Random rd = new Random();
        return rd.nextInt(Length);
    }

    public ArrayList<Products> GetRandomProduct(ArrayList<Products> dataArrayList, int MaxSize) {
        ArrayList<Products> data = new ArrayList<>();
        try {
            int count = 0;
            int randomNum;
            while (count < MaxSize) {
                randomNum = RandDomNumber(dataArrayList.size());
                if (!data.contains(dataArrayList.get(randomNum))) {
                    count++;
                    data.add(dataArrayList.get(randomNum));
                }
            }
            return data;
        } catch (Exception e) {
            System.out.println("GetRandomProduct: " + e);
        }
        return null;
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        List<Products> data = productDAO.searchProducts("2");
        for (Products products : data) {
            System.out.println(products.getProductID());
        }

//        System.out.println(productDAO.GetProductListByCategoryID("1").size());
//        int months = Calendar.getInstance().get(Calendar.MONTH);
//        ArrayList list = productDAO.BestSellerProducts();
//        System.out.println(list);
//        System.out.println(productDAO.decreaseProductAmount("1", "5"));
//        Products p = productDAO.getProductByID("1");
//        System.out.println("productid: " + p.getProductID() + " ");
//        System.out.println("categoriID: " + p.getProduct_categoryID() + " ");
//        System.out.println("Name: " + p.getName() + " ");
//        System.out.println("Description: " + p.getDesciption() + " ");
//        System.out.println("picture: " + p.getPicture() + " ");
//        System.out.println("picture2: " + p.getPicture2() + " ");
//        System.out.println("picture3: " + p.getPicture3() + " ");
//        System.out.println("price: " + p.getPrice() + " ");
//        System.out.println("quantity: " + p.getQuantity() + " ");
//        System.out.println("status: " + p.getStatus() + " ");
//        System.out.println("sale: " + p.getSale() + " ");
//        System.out.println("rateStar: " + p.getRateStar() + " ");
//        System.out.println("saleprice: " + p.getSalePrice() + " ");
//        System.out.println("");
//        System.out.println(productDAO.getProductListByType("HighPrice").size());
//        System.out.println("getProductAmount: " + productDAO.getProductAmount("2"));
        // Định dạng số với dấu chấm
//        int size = productDAO.getProductListByCategoryIDAndNameAndSort("1","a","ascendingSalePrice").size();
//        size = productDAO.BestSellerProducts().size();
//        size=productDAO.getProductListByCategoryIDAndSort("1", "rate").size();
//        System.out.println(size);
//        System.out.println(formattedNumber);
//        for (Products p : productDAO.getProductListByCategoryIDAndNameAndSort("1", "Corsair HS70", "rate")) {
//            System.out.println("productid: " + p.getProductID() + " ");
//            System.out.println("categoriID: " + p.getProduct_categoryID() + " ");
//            System.out.println("Name: " + p.getName() + " ");
//            System.out.println("Description: " + p.getDesciption() + " ");
//            System.out.println("picture: " + p.getPicture() + " ");
//            System.out.println("picture2: " + p.getPicture2() + " ");
//            System.out.println("picture3: " + p.getPicture3() + " ");
//            System.out.println("price: " + p.getPrice() + " ");
//            System.out.println("quantity: " + p.getQuantity() + " ");
//            System.out.println("status: " + p.getStatus() + " ");
//            System.out.println("sale: " + p.getSale() + " ");
//            System.out.println("rateStar: " + p.getRateStar() + " ");
//            System.out.println("saleprice: " + p.getSalePrice() + " ");
//            System.out.println("");
//        }
//        for (Products p : productDAO.BestSellerProducts()) {
//            if (p.getProductID().equals("1")) {
//
//                System.out.print("productid: " + p.getProductID() + " ");
//                System.out.print("productName: " + p.getName() + " ");
////            System.out.print("price: " + p.getPrice() + " ");
//                System.out.println("picture: " + p.getPicture());
//            }
////            System.out.print("sale: " + p.getSale() + " ");
////            System.out.print("rateStar: " + p.getRateStar() + " ");
////            System.out.print("saleprice: " + p.getSalePrice() + " ");
//            System.out.println("");
//        }
//        String linkImage1 = productDAO.imageLink();
//        System.out.println(linkImage1);
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
//        decimalFormat.applyPattern("#,###");
//        double x = 123.1;
//        double y = 2.3;
//        String s = decimalFormat.format(x + y);
//        System.out.println("s: " + s);
//        double x = 3.44;
//        System.out.println(new DecimalFormat("#.0").format(x));
//        for (Products p : productDAO.getProductListByType("wired")) {
//            System.out.println("productid: " + p.getProductID() + " ");
//            System.out.println("categoriID: " + p.getProduct_categoryID() + " ");
//            System.out.println("Name: " + p.getName() + " ");
//            System.out.println("Description: " + p.getDesciption() + " ");
//            System.out.println("picture: " + p.getPicture() + " ");
//            System.out.println("picture2: " + p.getPicture2() + " ");
//            System.out.println("picture3: " + p.getPicture3() + " ");
//            System.out.println("price: " + p.getPrice() + " ");
//            System.out.println("quantity: " + p.getQuantity() + " ");
//            System.out.println("status: " + p.getStatus() + " ");
//            System.out.println("sale: " + p.getSale() + " ");
//            System.out.println("rateStar: " + p.getRateStar() + " ");
//            System.out.println("saleprice: " + p.getSalePrice() + " ");
//            System.out.println("");
//        }
    }

}
