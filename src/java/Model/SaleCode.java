package Model;

/**
 *
 * @author PC
 */
public class SaleCode {
    private String salecodeID, code, amount, expiration_date,salecodeRate;

    public SaleCode() {
    }

    public SaleCode(String salecodeID, String code, String amount, String expiration_date) {
        this.salecodeID = salecodeID;
        this.code = code;
        this.amount = amount;
        this.expiration_date = expiration_date;
    }

    public SaleCode(String salecodeID, String code, String amount, String expiration_date, String salecodeRate) {
        this.salecodeID = salecodeID;
        this.code = code;
        this.amount = amount;
        this.expiration_date = expiration_date;
        this.salecodeRate = salecodeRate;
    }

    public String getSalecodeID() {
        return salecodeID;
    }

    public void setSalecodeID(String salecodeID) {
        this.salecodeID = salecodeID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }
    
}
