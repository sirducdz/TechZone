package Model;

/**
 *
 * @author PC
 */
public class Order {

    private String orderID, order_userID, order_salecodeID, note, date, status;
    private String address, phone_number, orderdetail_productID;
    private String name_user, price_order, picture, salePrice, quantity, productName;

    public Order(String orderID, String date, String status, String address, String picture, String salePrice, String quantity, String productName, String orderdetail_productID, int temp) {
        this.orderID = orderID;
        this.date = date;
        this.status = status;
        this.address = address;
        this.picture = picture;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.productName = productName;
        this.orderdetail_productID = orderdetail_productID;
    }

    public Order() {
    }

    public Order(String orderID, String order_userID, String order_salecodeID, String note, String date, String status) {
        this.orderID = orderID;
        this.order_userID = order_userID;
        this.order_salecodeID = order_salecodeID;
        this.note = note;
        this.date = date;
        this.status = status;
    }

    public Order(String order_userID, String order_salecodeID, String date, String status) {
        this.order_userID = order_userID;
        this.order_salecodeID = order_salecodeID;
        this.date = date;
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getOrderdetail_productID() {
        return orderdetail_productID;
    }

    public void setOrderdetail_productID(String orderdetail_productID) {
        this.orderdetail_productID = orderdetail_productID;
    }

    public Order(String orderID, String order_userID, String order_salecodeID, String note, String date, String status, String address, String phone_number, String orderdetail_productID) {
        this.orderID = orderID;
        this.order_userID = order_userID;
        this.order_salecodeID = order_salecodeID;
        this.note = note;
        this.date = date;
        this.status = status;
        this.address = address;
        this.phone_number = phone_number;
        this.orderdetail_productID = orderdetail_productID;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrder_userID() {
        return order_userID;
    }

    public void setOrder_userID(String order_userID) {
        this.order_userID = order_userID;
    }

    public String getOrder_salecodeID() {
        return order_salecodeID;
    }

    public void setOrder_salecodeID(String order_salecodeID) {
        this.order_salecodeID = order_salecodeID;
    }

    public String getNote() {
        return note;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order(String orderID, String order_userID, String order_salecodeID, String note, String date, String status, String name_user, String price_order) {
        this.orderID = orderID;
        this.order_userID = order_userID;
        this.order_salecodeID = order_salecodeID;
        this.note = note;
        this.date = date;
        this.status = status;
        this.name_user = name_user;
        this.price_order = price_order;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getPrice_order() {
        return price_order;
    }

    public void setPrice_order(String price_order) {
        this.price_order = price_order;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Order(String orderID, String cName, String phone, String address, String price, String date, String status) {
        this.orderID = orderID;
        this.name_user = cName;
        this.phone_number = phone;
        this.address = address;
        this.price_order = price;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", date=" + date + ", status=" + status + ", address=" + address + ", phone_number=" + phone_number + ", name_user=" + name_user + ", price_order=" + price_order + '}';
    }

}
