package Model;

/**
 *
 * @author DucPhaoLo
 */
public class Categories {

    private String categoryID, name, status;

    public Categories() {
    }

    public Categories(String categoryID, String name, String status) {
        this.categoryID = categoryID;
        this.name = name;
        this.status = status;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
