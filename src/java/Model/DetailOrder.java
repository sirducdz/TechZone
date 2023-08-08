package Model;

/**
 *
 * @author laptop
 */
public class DetailOrder {

    private String name_user, phone_number, address, orderdetailID, orderdeatil_orderID,
            quantity, price, orderdetail_produstID, name_product;
    private String price_product, date;

    public DetailOrder() {
    }

    public DetailOrder(String name_user, String phone_number, String address, String orderdetailID, String orderdeatil_orderID, String quantity, String price, String orderdetail_produstID, String name_product, String price_product, String date) {
        this.name_user = name_user;
        this.phone_number = phone_number;
        this.address = address;
        this.orderdetailID = orderdetailID;
        this.orderdeatil_orderID = orderdeatil_orderID;
        this.quantity = quantity;
        this.price = price;
        this.orderdetail_produstID = orderdetail_produstID;
        this.name_product = name_product;
        this.price_product = price_product;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice_product() {
        return price_product;
    }

    public void setPrice_product(String price_product) {
        this.price_product = price_product;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderdetailID() {
        return orderdetailID;
    }

    public void setOrderdetailID(String orderdetailID) {
        this.orderdetailID = orderdetailID;
    }

    public String getOrderdeatil_orderID() {
        return orderdeatil_orderID;
    }

    public void setOrderdeatil_orderID(String orderdeatil_orderID) {
        this.orderdeatil_orderID = orderdeatil_orderID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderdetail_produstID() {
        return orderdetail_produstID;
    }

    public void setOrderdetail_produstID(String orderdetail_produstID) {
        this.orderdetail_produstID = orderdetail_produstID;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    @Override
    public String toString() {
        return "DetailOrder{" + "name_user=" + name_user + ", phone_number=" + phone_number + ", address=" + address + ", orderdetailID=" + orderdetailID + ", orderdeatil_orderID=" + orderdeatil_orderID + ", quantity=" + quantity + ", price=" + price + ", orderdetail_produstID=" + orderdetail_produstID + ", name_product=" + name_product + ", price_product=" + price_product + '}';
    }
}
