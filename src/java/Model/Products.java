package Model;

/**
 *
 * @author DucPhaoLo
 */
public class Products {

    private String ProductID, product_categoryID, name, desciption, picture, price, quantity, status, sale;
    private String rateStar, salePrice, picture2, picture3,date;
    private Categories categories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSale() {
        return sale;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getRateStar() {
        return rateStar;
    }

    public void setRateStar(String rateStar) {
        this.rateStar = rateStar;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public Products() {
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }

    public Products(String ProductID, String product_categoryID, String name, String desciption, String picture, String price, String quantity, String status, String picture2, String picture3, String date) {
        this.ProductID = ProductID;
        this.product_categoryID = product_categoryID;
        this.name = name;
        this.desciption = desciption;
        this.picture = picture;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.picture2 = picture2;
        this.picture3 = picture3;
        this.date = date;
    }

    public Products(String ProductID, String product_categoryID, String name, String desciption, String picture, String price, String quantity, String status, String sale, String rateStar, String salePrice, String picture2, String picture3) {
        this.ProductID = ProductID;
        this.product_categoryID = product_categoryID;
        this.name = name;
        this.desciption = desciption;
        this.picture = picture;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.sale = sale;
        this.rateStar = rateStar;
        this.salePrice = salePrice;
        this.picture2 = picture2;
        this.picture3 = picture3;
    }
    
    public Products(String ProductID, String product_categoryID, String name, String desciption, String picture, String price, String quantity, String status, String sale, String rateStar, String salePrice, String picture2, String picture3, Categories categories) {
        this.ProductID = ProductID;
        this.product_categoryID = product_categoryID;
        this.name = name;
        this.desciption = desciption;
        this.picture = picture;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.sale = sale;
        this.rateStar = rateStar;
        this.salePrice = salePrice;
        this.picture2 = picture2;
        this.picture3 = picture3;
        this.categories = categories;
    }
    
    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProduct_categoryID() {
        return product_categoryID;
    }

    public void setProduct_categoryID(String product_categoryID) {
        this.product_categoryID = product_categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
