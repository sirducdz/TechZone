package Dal;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DucPhaoLo
 */
public class AccountDao extends ConnectMySQL {

    public boolean checkExistEmail(String email) {
        try {
            String sqlSelect = "SELECT * FROM swp.user where email=?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkExistEmail: " + e);
        }
        return false;
    }

    public boolean checkExistAccount(String userName) {
        try {
            String sqlSelect = "SELECT * FROM swp.user where username=?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, userName);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkExistAccount: " + e);
        }
        return false;
    }

    public boolean checkExistAccountByEmail(String email) {
        try {
            String sqlSelect = "SELECT * FROM swp.user where email=?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkExistAccountByEmail: " + e);
        }
        return false;
    }

    public boolean checkExistAccountByEmailAndUserID(String email, String userID) {
        try {
            String sqlSelect = "SELECT * FROM swp.user where email=? and userid != ?;";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, email);
            pstm.setInt(2, Integer.parseInt(userID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkExistAccountByEmail: " + e);
        }
        return false;
    }

    public boolean AddUser(User user) {
        try {
            String sqlSelect = "insert into swp.user( username, password, user_roleID, name, age, user_sexID, address, phone_number, avatar, register_code, email, status) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            user.setUserID(String.valueOf(GetUserIndex()));
            pstm = connection.prepareStatement(sqlSelect);
//            pstm.setInt(1, Integer.parseInt(user.getUserID()));
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setInt(3, Integer.parseInt(user.getUser_roleID()));
            pstm.setString(4, user.getName());
            pstm.setInt(5, Integer.parseInt(user.getAge()));// fix in model
            pstm.setInt(6, Integer.parseInt(user.getUser_sexID()));
            pstm.setString(7, user.getAddress());
            pstm.setString(8, user.getPhone_number());
            pstm.setString(9, user.getAvatar());
            pstm.setString(10, user.getRegister_code());
            pstm.setString(11, user.getEmail());
            pstm.setInt(12, Integer.parseInt(user.getStatus()));
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("AddUser: " + e);
        }
        return false;
    }

    public User GetUserByEmail(String email) {
        String sqlSelect = "select* from swp.user where email= ?";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userID = String.valueOf(rs.getInt(1));
                String username = String.valueOf(rs.getString(2));
                String password = String.valueOf(rs.getString(3));
                String user_roleID = String.valueOf(rs.getInt(4));
                String name = String.valueOf(rs.getString(5));
                String age = String.valueOf(rs.getInt(6));
                String user_sexID = String.valueOf(rs.getInt(7));
                String address = String.valueOf(rs.getString(8));
                String phone_number = String.valueOf(rs.getString(9));
                String avatar = String.valueOf(rs.getString(10));
                String register_code = String.valueOf(rs.getString(11));
                String status = String.valueOf(rs.getInt(13));
                User user = new User(userID, username, password, user_roleID, name, age, user_sexID, address, phone_number, avatar, register_code, email, status);
                return user;
            }
        } catch (Exception e) {
            System.out.println("GetUserByEmail: " + e);
        }
        return null;
    }

    public User GetUserByUserID(String Userid) {
        String sqlSelect = "select* from swp.user where userid= ?";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(Userid));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userID = String.valueOf(rs.getInt(1));
                String username = String.valueOf(rs.getString(2));
                String password = String.valueOf(rs.getString(3));
                String user_roleID = String.valueOf(rs.getInt(4));
                String name = String.valueOf(rs.getString(5));
                String age = String.valueOf(rs.getInt(6));
                String user_sexID = String.valueOf(rs.getInt(7));
                String address = String.valueOf(rs.getString(8));
                String phone_number = String.valueOf(rs.getString(9));
                String avatar = String.valueOf(rs.getString(10));
                String register_code = String.valueOf(rs.getString(11));
                String email = String.valueOf(rs.getString(12));
                String status = String.valueOf(rs.getInt(13));
                User user = new User(userID, username, password, user_roleID, name, age, user_sexID, address, phone_number, avatar, register_code, email, status);
                return user;
            }
        } catch (Exception e) {
            System.out.println("GetUserByEmail: " + e);
        }
        return null;
    }

    public User GetUserByID(String userID) {
        String sqlSelect = "select* from swp.user where userID= ?";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(userID));
            rs = pstm.executeQuery();
            while (rs.next()) {
//                String userID = String.valueOf(rs.getInt(1));
                String username = String.valueOf(rs.getString(2));
                String password = String.valueOf(rs.getString(3));
                String user_roleID = String.valueOf(rs.getInt(4));
                String name = String.valueOf(rs.getString(5));
                String age = String.valueOf(rs.getInt(6));
                String user_sexID = String.valueOf(rs.getInt(7));
                String address = String.valueOf(rs.getString(8));
                String phone_number = String.valueOf(rs.getString(9));
                String avatar = String.valueOf(rs.getString(10));
                String register_code = String.valueOf(rs.getString(11));
                String email = rs.getString(12);
                String status = String.valueOf(rs.getInt(13));
                User user = new User(userID, username, password, user_roleID, name, age, user_sexID, address, phone_number, avatar, register_code, email, status);
                return user;
            }
        } catch (Exception e) {
            System.out.println("GetUserByID: " + e);
        }
        return null;
    }

    public boolean resetPassword(String email, String newPassword) {
        try {
            String sqlSelect = "UPDATE `swp`.`user` SET `password` = ? WHERE (`email` = ?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, newPassword);
            pstm.setString(2, email);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("resetPassword: " + e);
        }
        return false;
    }

    public boolean ChangePassword(String userName, String newPassword) {
        try {
            String sqlSelect = "UPDATE `swp`.`user` SET `password` = ? WHERE (`userName` = ?);";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, newPassword);
            pstm.setString(2, userName);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ChangePassword: " + e);
        }
        return false;
    }

    public boolean checkLogin(User user) {
        try {
            String sqlString = "SELECT * FROM swp.user where username=? and password=?";
            pstm = connection.prepareStatement(sqlString);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkLogin: " + e);
        }
        return false;
    }

    public boolean EditUser(User user) {
        try {
            String sqlSelect;
            if (user.getAvatar() == null) {
                sqlSelect = "update swp.user set name=?,age=?,user_sexID=?,address=?,phone_number=?,email=?"
                        + " where userid=?";
            } else {
                sqlSelect = "update swp.user set name=?,age=?,user_sexID=?,address=?,phone_number=?,email=?,avatar=?"
                        + " where userid=?";
            }
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, user.getName());
            pstm.setInt(2, Integer.parseInt(user.getAge()));
            pstm.setInt(3, Integer.parseInt(user.getUser_sexID()));
            pstm.setString(4, user.getAddress());
            pstm.setString(5, user.getPhone_number());
            pstm.setString(6, user.getEmail());
            if (user.getAvatar() == null) {
                pstm.setInt(7, Integer.parseInt(user.getUserID()));
            } else {
                pstm.setString(7, user.getAvatar());
                pstm.setInt(8, Integer.parseInt(user.getUserID()));
            }
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("EditUser: " + e);
        }
        return false;
    }

    public boolean EditUserByAdmin(User user) {
        try {
            System.out.println("user.status: " + user.getStatus());
            String sqlSelect;
            sqlSelect = "update user set username=?,password=?,user_roleID=?,name=?,age=?,user_sexID=?,address=?,phone_number=?,email=?, status=b'" + user.getStatus() + "' \n"
                    + "where user.userID=?";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setInt(3, Integer.parseInt(user.getUser_roleID()));
            pstm.setString(4, user.getName());
            pstm.setInt(5, Integer.parseInt(user.getAge()));

            pstm.setInt(6, Integer.parseInt(user.getUser_sexID()));
            pstm.setString(7, user.getAddress());
            pstm.setString(8, user.getPhone_number());
            pstm.setString(9, user.getEmail());
            pstm.setInt(10, Integer.parseInt(user.getUserID()));
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("EditUserByAdmin: " + e);
        }
        return false;
    }

    public boolean AddUserByAdmin(User user) {
        try {
            System.out.println("user.status: " + user.getStatus());
            String sqlSelect;
            sqlSelect = "insert into user(`username`, `password`, `user_roleID`,`name`, `age`, `user_sexID`,`address`, `phone_number`, `status`)\n"
                    + "values(?,?,?,?,?,?,?,?,b'"+user.getStatus()+"');";
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setInt(3, Integer.parseInt(user.getUser_roleID()));
            pstm.setString(4, user.getName());
            pstm.setInt(5, Integer.parseInt(user.getAge()));

            pstm.setInt(6, Integer.parseInt(user.getUser_sexID()));
            pstm.setString(7, user.getAddress());
            pstm.setString(8, user.getPhone_number());
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("AddUserByAdmin: " + e);
        }
        return false;
    }

    public ArrayList<User> GetUserList() {
        ArrayList<User> data = new ArrayList<>();
        String sqlSelect = "select* from swp.user";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userID = String.valueOf(rs.getInt(1));
                String username = String.valueOf(rs.getString(2));
                String password = String.valueOf(rs.getString(3));
                String user_roleID = String.valueOf(rs.getInt(4));
                String name = String.valueOf(rs.getString(5));
                String age = String.valueOf(rs.getInt(6));
                String user_sexID = String.valueOf(rs.getInt(7));
                String address = String.valueOf(rs.getString(8));
                String phone_number = String.valueOf(rs.getString(9));
                String avatar = String.valueOf(rs.getString(10));
                String register_code = String.valueOf(rs.getString(11));
                String email = rs.getString(12);
                String status = String.valueOf(rs.getInt(13));
                User user = new User(userID, username, password, user_roleID, name, age, user_sexID, address, phone_number, avatar, register_code, email, status);
                data.add(user);
            }
            return data;
        } catch (Exception e) {
            System.out.println("GetUserByEmail: " + e);
        }
        return null;
    }

    public static void main(String[] args) {
        AccountDao dao = new AccountDao();
        User u = new User("39", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
        dao.EditUserByAdmin(u);
//        User u = new User("12", "12", "1", "12", "12", "12", "12", "39");
//        dao.EditUser(u);
//        System.out.println(dao.GetUserList().size());
//        User u = dao.GetUserByID("10");
//        System.out.println(u.getEmail());
//        User u=dao.getUserByUserName("sirducdz");
//        System.out.println(u.getEmail());
//        System.out.println(dao.checkExistAccount("admin1"));
//        User u =dao.GetUserByEmail("ducnvhe160331@fpt.edu.vn");
//        System.out.println(u.getName());
//          User u = new User();
//          u.setUsername("sirducdz2");
//          u.setPassword("Sirducdzzzz2@");
//          System.out.println("dao.checkLogin(u)"+dao.checkLogin(u));
    }

    public User getUserByUserName(String userName) {
        String sqlSelect = "select* from swp.user where username= ?";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            pstm.setString(1, userName);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String userID = String.valueOf(rs.getInt(1));
                String username = String.valueOf(rs.getString(2));
                String password = String.valueOf(rs.getString(3));
                String user_roleID = String.valueOf(rs.getInt(4));
                String name = String.valueOf(rs.getString(5));
                String age = String.valueOf(rs.getInt(6));
                String user_sexID = String.valueOf(rs.getInt(7));
                String address = String.valueOf(rs.getString(8));
                String phone_number = String.valueOf(rs.getString(9));
                String avatar = String.valueOf(rs.getString(10));
                String register_code = String.valueOf(rs.getString(11));
                String email = String.valueOf(rs.getString(12));
                String status = String.valueOf(rs.getInt(13));
                User user = new User(userID, username, password, user_roleID, name, age, user_sexID, address, phone_number, avatar, register_code, email, status);
                return user;
            }
        } catch (Exception e) {
            System.out.println("getUserByUserName: " + e);
        }
        return null;
    }

    public int AccountBanned() {
        int count = 0;
        String sqlSelect = "SELECT COUNT(*) as 'count' FROM swp.user\n"
                + "where status = 0";
        try {
            pstm = connection.prepareStatement(sqlSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }
}
