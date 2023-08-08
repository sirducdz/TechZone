package Model;

/**
 *
 * @author PC
 */
public class Earphone {
    private String ProductID, product_categoryID, name, desciption, picture, price, quantity, status, sale, rate, saleprice, picture2, picture3, earphoneID, type, frequency, sensitive, impedance, meterial, earphone_ProductID, size, battery, connection_distance, wire_length;

    public Earphone() {
    }

    public Earphone(String ProductID, String name) {
        this.ProductID = ProductID;
        this.name = name;
    }

    

    public Earphone(String ProductID, String product_categoryID, String name, String desciption, String picture, String price, String quantity, String status, String sale, String rate, String saleprice, String picture2, String picture3, String earphoneID, String type, String frequency, String sensitive, String impedance, String meterial, String earphone_ProductID, String size, String battery, String connection_distance, String wire_length) {
        this.ProductID = ProductID;
        this.product_categoryID = product_categoryID;
        this.name = name;
        this.desciption = desciption;
        this.picture = picture;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.sale = sale;
        this.rate = rate;
        this.saleprice = saleprice;
        this.picture2 = picture2;
        this.picture3 = picture3;
        this.earphoneID = earphoneID;
        this.type = type;
        this.frequency = frequency;
        this.sensitive = sensitive;
        this.impedance = impedance;
        this.meterial = meterial;
        this.earphone_ProductID = earphone_ProductID;
        this.size = size;
        this.battery = battery;
        this.connection_distance = connection_distance;
        this.wire_length = wire_length;
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

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getSalePrice() {
        return saleprice;
    }

    public void setSalePrice(String saleprice) {
        this.saleprice = saleprice;
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

    public String getEarphoneID() {
        return earphoneID;
    }

    public void setEarphoneID(String earphoneID) {
        this.earphoneID = earphoneID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSensitive() {
        return sensitive;
    }

    public void setSensitive(String sensitive) {
        this.sensitive = sensitive;
    }

    public String getImpedance() {
        return impedance;
    }

    public void setImpedance(String impedance) {
        this.impedance = impedance;
    }

    public String getMeterial() {
        return meterial;
    }

    public void setMeterial(String meterial) {
        this.meterial = meterial;
    }

    public String getEarphone_ProductID() {
        return earphone_ProductID;
    }

    public void setEarphone_ProductID(String earphone_ProductID) {
        this.earphone_ProductID = earphone_ProductID;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getConnection_distance() {
        return connection_distance;
    }

    public void setConnection_distance(String connection_distance) {
        this.connection_distance = connection_distance;
    }

    public String getWire_length() {
        return wire_length;
    }

    public void setWire_length(String wire_length) {
        this.wire_length = wire_length;
    }
    
}
