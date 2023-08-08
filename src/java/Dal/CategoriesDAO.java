package Dal;

import Model.Categories;
import java.util.ArrayList;

/**
 *
 * @author DucPhaoLo
 */
public class CategoriesDAO extends ConnectMySQL {

    public ArrayList<Categories> GetCategoriesList() {
        ArrayList<Categories> data = new ArrayList<>();
        try {
            String sqlSelectString = "SELECT * FROM swp.category;";
            pstm = connection.prepareStatement(sqlSelectString);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String categoryID = String.valueOf(rs.getInt(1));
                String name = String.valueOf(rs.getString(2));
                String status = String.valueOf(rs.getInt(3));
                data.add(new Categories(categoryID, name, status));
            }
        } catch (Exception e) {
            System.out.println("GetCategoriesesList: " + e);
        }
        return data;
    }
    
     public Categories getCategoryById(String ID) {
        try {
            String sqlSelectString = "select * from category where categoryID=?";
            pstm = connection.prepareStatement(sqlSelectString);
            pstm.setInt(1, Integer.parseInt(ID));
            rs = pstm.executeQuery();
            if(rs.next()){
             String categoryID = String.valueOf(rs.getInt(1));
                String name = String.valueOf(rs.getString(2));
                String status = String.valueOf(rs.getInt(3));
                Categories data = new Categories(categoryID,name,status);
                return data;
            }
        } catch (Exception e) {
            System.out.println("GetCategoriesesList: " + e);
        }
        return null;
    }
     
     
    public static void main(String[] args) {
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        System.out.println(categoriesDAO.getCategoryById("2").getName());
    }
}
