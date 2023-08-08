package Model;

/**
 *
 * @author PC
 */
public class Feedback {

    private String FeedbackID, FeedbackID_ProductID, feedbackID_userID, information, status, date, username, product_rate, orderdetailID;
    private String productName;

    public String getOrderdetailID() {
        return orderdetailID;
    }

    public void setOrderdetailID(String orderdetailID) {
        this.orderdetailID = orderdetailID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Feedback(String FeedbackID, String FeedbackID_ProductID, String feedbackID_userID, String information, String status, String date, String username, String orderdetailID, String productName) {
        this.FeedbackID = FeedbackID;
        this.FeedbackID_ProductID = FeedbackID_ProductID;
        this.feedbackID_userID = feedbackID_userID;
        this.information = information;
        this.status = status;
        this.date = date;
        this.username = username;
        this.orderdetailID = orderdetailID;
        this.productName = productName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Feedback(String FeedbackID_ProductID, String feedbackID_userID, String information, String product_rate, String orderdetailID) {
        this.FeedbackID_ProductID = FeedbackID_ProductID;
        this.feedbackID_userID = feedbackID_userID;
        this.information = information;
        this.product_rate = product_rate;
        this.orderdetailID = orderdetailID;
    }

    public Feedback(String FeedbackID, String FeedbackID_ProductID, String feedbackID_userID, String information, String status, String date, String username, String product_rate) {
        this.FeedbackID = FeedbackID;
        this.FeedbackID_ProductID = FeedbackID_ProductID;
        this.feedbackID_userID = feedbackID_userID;
        this.information = information;
        this.status = status;
        this.date = date;
        this.username = username;
        this.product_rate = product_rate;
    }

    public Feedback(String FeedbackID, String FeedbackID_ProductID, String feedbackID_userID, String information, String status, String date, String username) {
        this.FeedbackID = FeedbackID;
        this.FeedbackID_ProductID = FeedbackID_ProductID;
        this.feedbackID_userID = feedbackID_userID;
        this.information = information;
        this.status = status;
        this.date = date;
        this.username = username;
    }

    public String getProduct_rate() {
        return product_rate;
    }

    public void setProduct_rate(String product_rate) {
        this.product_rate = product_rate;
    }

    public Feedback() {
    }

    public String getFeedbackID() {
        return FeedbackID;
    }

    public void setFeedbackID(String FeedbackID) {
        this.FeedbackID = FeedbackID;
    }

    public String getFeedbackID_ProductID() {
        return FeedbackID_ProductID;
    }

    public void setFeedbackID_ProductID(String FeedbackID_ProductID) {
        this.FeedbackID_ProductID = FeedbackID_ProductID;
    }

    public String getFeedbackID_userID() {
        return feedbackID_userID;
    }

    public void setFeedbackID_userID(String feedbackID_userID) {
        this.feedbackID_userID = feedbackID_userID;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Feedback{" + "FeedbackID=" + FeedbackID + ", FeedbackID_ProductID=" + FeedbackID_ProductID + ", feedbackID_userID=" + feedbackID_userID + ", information=" + information + ", status=" + status + ", date=" + date + ", username=" + username + ", product_rate=" + product_rate + ", orderdetailID=" + orderdetailID + '}';
    }

}
