package Impl;

/**
 *
 * @author DucPhaoLo
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class LoginAndRegisterValidation {

    public LoginAndRegisterValidation() {
    }

    public boolean UserNameValidate(String userName) {

        final String USERNAME_PATTERN = "^[a-zA-Z0-9_-]{8,16}$";
        return userName.matches(USERNAME_PATTERN);
    }

    public boolean PassWordValidate(String password) {
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(PASSWORD_PATTERN);
    }

    public boolean CheckEqualRepasswordValidate(String password, String repassword) {
        return password.equals(repassword);
    }

    public boolean FullNameValidate(String FullName) {

        final String FullName_PATTERN = "^[a-zA-Z\\s]+$";
        return FullName.matches(FullName_PATTERN);
    }

    public boolean PhoneNumberValidate(String PhoneNumber) {

        final String PhoneNumber_PATTERN = "^\\d{10}$";
        return PhoneNumber.matches(PhoneNumber_PATTERN);
    }

    public boolean EmailValidate(String Email) {

        final String Email_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Email.matches(Email_PATTERN);
    }

    public boolean DOBValidate(String DOB) throws ParseException {
        int year, month, day;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sf.parse(DOB);
        year = date.getYear() + 1900;
        month = date.getMonth() + 1;
        day = date.getDate();
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        // Kiểm tra xem người dùng có đủ 12 tuổi hay không
        if (age >= 12) {
            return true;
        } else {
            return false;
        }
    }

    public int GetAge(String DOB) throws ParseException {
        int year, month, day;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sf.parse(DOB);
        year = date.getYear() + 1900;
        month = date.getMonth() + 1;
        day = date.getDate();
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        // Kiểm tra xem người dùng có đủ 12 tuổi hay không
        return age;
    }

}
