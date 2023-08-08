package Dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ConnectMySQL {

//    private static String DB_URL = "jdbc:mysql://projectswpgroup2server.mysql.database.azure.com:3306/swp";
//    private static String USER_NAME = "adminproject";
//    private static String PASSWORD = "Sirducdz7a@";
    PreparedStatement pstm;// thuc thi sql
    ResultSet rs;// luu tru va xu li du lieu
    private static String DB_URL = "jdbc:mysql://localhost:3306/swp";
    private static String USER_NAME = "root";
    private static String PASSWORD = "quocdangqd";

//    private static String DB_URL = "jdbc:mysql://dbtechzone.cvvwwrw5xmcg.us-east-1.rds.amazonaws.com/swp";
//    private static String USER_NAME = "admin";
//    private static String PASSWORD = "12345678";
    protected Connection connection = null;
    public ConnectMySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connect Successfully!");
        } catch (Exception ex) {
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ConnectMySQL obj = new ConnectMySQL();
    }
    
}
