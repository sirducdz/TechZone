package Model;

/**
 *
 * @author DucPhaoLo
 */
public class Cart {

    private String cartID, title, price, quantity, totalcost, productID, userID, status;
    private String picture, productName, product_Quantity;

    public Cart() {
    }

    public Cart(String cartID, String quantity, String userID) {
        this.cartID = cartID;
        this.quantity = quantity;
        this.userID = userID;
    }

    public Cart(String price, String quantity, String productID, String userID, String status) {
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
        this.userID = userID;
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Cart(String cartID, String title, String price, String quantity, String totalcost, String productID, String userID, String status, String productName, String picture, String product_Quantity) {
        this.cartID = cartID;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.totalcost = totalcost;
        this.productID = productID;
        this.userID = userID;
        this.status = status;
        this.productName = productName;
        this.picture = picture;
        this.product_Quantity = product_Quantity;
    }

    public Cart(String cartID, String title, String price, String quantity, String totalcost, String productID, String userID, String status) {
        this.cartID = cartID;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.totalcost = totalcost;
        this.productID = productID;
        this.userID = userID;
        this.status = status;
    }

    public String getProduct_Quantity() {
        return product_Quantity;
    }

    public void setProduct_Quantity(String product_Quantity) {
        this.product_Quantity = product_Quantity;
    }

    public String getCartID() {
        return cartID;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(String totalcost) {
        this.totalcost = totalcost;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
