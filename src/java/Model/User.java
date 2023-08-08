package Model;

/**
 *
 * @author DucPhaoLo
 */
public class User {
    // nhap vao userName,password,name(fullname),age(dob),phone_Number,email
    // them address
    private String userID, username, password, user_roleID, name, age, user_sexID,
            address, phone_number, avatar, register_code, email, status="1";

    public User(String userID, String name, String address, String phone_number, String email) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String userID, String username, String password, String user_roleID, String name, String age, String user_sexID, String address, String phone_number, String status) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.user_roleID = user_roleID;
        this.name = name;
        this.age = age;
        this.user_sexID = user_sexID;
        this.address = address;
        this.phone_number = phone_number;
        this.status = status;
    }
    
    public User(String userID, String username, String password, String user_roleID, String name, String age, String user_sexID, String address, String phone_number, String avatar, String register_code, String email, String status) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.user_roleID = user_roleID;
        this.name = name;
        this.age = age;
        this.user_sexID = user_sexID;
        this.address = address;
        this.phone_number = phone_number;
        this.avatar = avatar;
        this.register_code = register_code;
        this.email = email;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_roleID() {
        return user_roleID;
    }

    public void setUser_roleID(String user_roleID) {
        this.user_roleID = user_roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUser_sexID() {
        return user_sexID;
    }

    public void setUser_sexID(String user_sexID) {
        this.user_sexID = user_sexID;
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

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRegister_code() {
        return register_code;
    }

    public void setRegister_code(String register_code) {
        this.register_code = register_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", password=" + password + ", user_roleID=" + user_roleID + ", name=" + name + ", age=" + age + ", user_sexID=" + user_sexID + ", address=" + address + ", phone_number=" + phone_number + ", avatar=" + avatar + ", register_code=" + register_code + ", email=" + email + ", status=" + status + '}';
    }
}
