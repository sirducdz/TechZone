package Impl;

import Dal.AccountDao;
import Model.Cart;
import Model.Order;
import Model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author DucPhaoLo
 */
public class SendMail {

    public void SendMail(String email, String fullName, String userName, String password, String dob, String phone) {
//        String email = "ducnvhe160331@fpt.edu.vn";
//        RequestDispatcher dispatcher = null;
//        int otpvalue = 0;
//        HttpSession mySession = request.getSession();
        String emailContent = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                + "\n"
                + "    <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
                + "            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "                <title>Please activate your account</title>\n"
                + "                </head>\n"
                + "\n"
                + "                <body style=\"font-family: Helvetica, Arial, sans-serif; margin: 0px; padding: 0px; background-color: #ffffff;\">\n"
                + "                    <table role=\"presentation\"\n"
                + "                           style=\"width: 100%; border-collapse: collapse; border: 0px; border-spacing: 0px; font-family: Arial, Helvetica, sans-serif; background-color: rgb(239, 239, 239);\">\n"
                + "                        <tbody>\n"
                + "                            <tr>\n"
                + "                                <td align=\"center\" style=\"padding: 1rem 2rem; vertical-align: top; width: 100%;\">\n"
                + "                                    <table role=\"presentation\" style=\"max-width: 600px; border-collapse: collapse; border: 0px; border-spacing: 0px; text-align: left;\">\n"
                + "                                        <tbody>\n"
                + "                                            <tr>\n"
                + "                                                <td style=\"padding: 40px 0px 0px;\">\n"
                + "                                                    <div style=\"text-align: center;\">\n"
                + "                                                        <div style=\"padding-bottom: 20px;\"><img src=\"https://i.ibb.co/Qbnj4mz/logo.png\" alt=\"Company\" style=\"width: 80px;\"></div>\n"
                + "                                                    </div>\n"
                + "                                                    <div style=\"padding: 20px; background-color: rgb(255, 255, 255);\">\n"
                + "                                                        <div style=\"color: rgb(0, 0, 0); text-align: center;\">\n"
                + "                                                            <h1 style=\"margin: 1rem 0\">Xác nhận email</h1>\n"
                + "                                                            <p style=\"padding-bottom: 16px\">Hi " + fullName + ",<br>\n"
                + "                                                                    Vui lòng click vào nút xác nhận để tiếp tục</p>\n"
                + "                                                            <p style=\"padding-bottom: 16px\"><a href='http://localhost:9999/TechZone/auth/Register?allowRegister=true&fullName=" + fullName + "&userName=" + userName + "&password=" + password + "&email=" + email + "&dob=" + dob + "&phone=" + phone + "' \n"
                + "                                                                                               style=\"padding: 12px 24px; border-radius: 4px; color: #FFF; background: #2B52F5;display: inline-block;margin: 0.5rem 0;text-decoration: none;\">Xác nhận ngay</a></p>          \n"
                + "                                                            <p style=\"padding-bottom: 16px\">Nếu không yêu cầu xác minh địa chỉ này, bạn có thể bỏ qua email này.</p>\n"
                + "                                                        </div>\n"
                + "                                                    </div>                  \n"
                + "                                                </td>\n"
                + "                                            </tr>\n"
                + "                                        </tbody>\n"
                + "                                    </table>\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                        </tbody>\n"
                + "                    </table>\n"
                + "                </body>\n"
                + "                </html>";
        if (email != null || !email.equals("")) {
            // sending otp
//            Random rand = new Random();
//            otpvalue = rand.nextInt(1255650);

            String to = email;// change accordingly
            // Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("ccvnphu0001@gmail.com", "fkxuohzmowelkohj");// Put your email
                    // id and
                    // password here
                }
            });
            // compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email));// change accordingly
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Hello");
//				message.setText("your OTP is: " + otpvalue+"<a href='http://localhost:9999/LoginAndRegisterForm/forgotPasswordX.jsp?name="+email+"'> click me</a>");
//                                message.setText("your OTP is: " + otpvalue);
                message.setContent(emailContent, "text/html;charset=UTF-8");
                // send message
                Transport.send(message);
                System.out.println("Message sent successfully");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
//            dispatcher = request.getRequestDispatcher("EnterOtp.jsp");
//            request.setAttribute("message", "OTP is sent to your email id");
//            //request.setAttribute("connection", con);
//            mySession.setAttribute("otp", otpvalue);
//            mySession.setAttribute("email", email);
//            dispatcher.forward(request, response);
            //request.setAttribute("status", "success");
        }
    }

    public void SendMailReset(String email) {// forgetPassword
        String emailContent = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                + "\n"
                + "<head>\n"
                + "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "  <title>Reset your password</title>\n"
                + "  <!--[if mso]><style type=\"text/css\">body, table, td, a { font-family: Arial, Helvetica, sans-serif !important; }</style><![endif]-->\n"
                + "</head>\n"
                + "\n"
                + "<body style=\"font-family: Helvetica, Arial, sans-serif; margin: 0px; padding: 0px; background-color: #ffffff;\">\n"
                + "  <table role=\"presentation\"\n"
                + "    style=\"width: 100%; border-collapse: collapse; border: 0px; border-spacing: 0px; font-family: Arial, Helvetica, sans-serif; background-color: rgb(239, 239, 239);\">\n"
                + "    <tbody>\n"
                + "      <tr>\n"
                + "        <td align=\"center\" style=\"padding: 1rem 2rem; vertical-align: top; width: 100%;\">\n"
                + "          <table role=\"presentation\" style=\"max-width: 600px; border-collapse: collapse; border: 0px; border-spacing: 0px; text-align: left;\">\n"
                + "            <tbody>\n"
                + "              <tr>\n"
                + "                <td style=\"padding: 40px 0px 0px;\">\n"
                + "                  <div style=\"text-align: left;\">\n"
                + "                    <div style=\"padding-bottom: 20px;\"><img src=\"https://i.ibb.co/Qbnj4mz/logo.png\" alt=\"Company\" style=\"width: 56px;\"></div>\n"
                + "                  </div>\n"
                + "                  <div style=\"padding: 20px; background-color: rgb(255, 255, 255);\">\n"
                + "                    <div style=\"color: rgb(0, 0, 0); text-align: left;\">\n"
                + "                      <h1 style=\"margin: 1rem 0\">Đăng nhập không thành công</h1>\n"
                + "                      <p style=\"padding-bottom: 16px\">Chúng tôi đã nhận được yêu cầu đặt lại mật khẩu cho tài khoản người dùng này.</p>\n"
                + "                      <p style=\"padding-bottom: 16px\"><a href='http://localhost:9999/TechZone/auth/forgetPassword?email=" + email + "' target=\"_blank\"\n"
                + "                          style=\"padding: 12px 24px; border-radius: 4px; color: #FFF; background: #2B52F5;display: inline-block;margin: 0.5rem 0;text-decoration: none;\">Đặt lại mật khẩu</a></p>\n"
                + "                      <p style=\"padding-bottom: 16px\">Nếu không yêu cầu đặt lại mật khẩu, bạn có thể bỏ qua email này.</p>\n"
                + "                    </div>\n"
                + "                  </div>                \n"
                + "                </td>\n"
                + "              </tr>\n"
                + "            </tbody>\n"
                + "          </table>\n"
                + "        </td>\n"
                + "      </tr>\n"
                + "    </tbody>\n"
                + "  </table>\n"
                + "</body>\n"
                + "\n"
                + "</html>";
        if (email != null || !email.equals("")) {
            // sending otp
//            Random rand = new Random();
//            otpvalue = rand.nextInt(1255650);

            String to = email;// change accordingly
            // Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("ccvnphu0001@gmail.com", "fkxuohzmowelkohj");// Put your email
                    // id and
                    // password here
                }
            });
            // compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email));// change accordingly
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Yêu cầu cấp lại mật khẩu","UTF-8");
//				message.setText("your OTP is: " + otpvalue+"<a href='http://localhost:9999/LoginAndRegisterForm/forgotPasswordX.jsp?name="+email+"'> click me</a>");
//                                message.setText("your OTP is: " + otpvalue);
                message.setContent(emailContent, "text/html;charset=UTF-8");
                // send message
                Transport.send(message);
                System.out.println("Message sent successfully");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }
//String email, 

    public void SendMailCheckOut(Order order, HttpServletRequest request, HttpServletResponse response) {//
        AccountDao accountDao = new AccountDao();
        HttpSession session1 = request.getSession();
//        System.out.println("discountPrice " + session1.getAttribute("discountPrice"));
//        System.out.println("totalPriceAfter " + session1.getAttribute("totalPriceAfter"));
//        System.out.println("totalPrice " + session1.getAttribute("totalPrice"));
        User user = accountDao.GetUserByID(order.getOrder_userID());
        ArrayList<Cart> cartData = (ArrayList<Cart>) session1.getAttribute("cartData");
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
        decimalFormat.applyPattern("#,###");
        String totalPriceAfter = null;
        if (session1.getAttribute("totalPriceAfter") != null) {
            totalPriceAfter = decimalFormat.format((float) session1.getAttribute("totalPriceAfter")).replace(",", ".");
        } else {
            totalPriceAfter = decimalFormat.format((float) session1.getAttribute("totalPrice")).replace(",", ".");
        }
        String totalPriceBefore = decimalFormat.format((float) session1.getAttribute("totalPrice")).replace(",", ".");
        String discountPrice = null;
        if (session1.getAttribute("discountPrice") != null) {
            discountPrice = decimalFormat.format((float) session1.getAttribute("discountPrice")).replace(",", ".");
        }

//        String inputSalecode = (String) session1.getAttribute("inputSalecode");
//        System.out.println("cartdate.size = " + cartData.size());
//        System.out.println("totalPriceAfter " + totalPriceAfter);
//        System.out.println("totalPriceBefore " + totalPriceBefore);
//        System.out.println("inputSalecode " + inputSalecode);
//        System.out.println("discountPrice " + discountPrice);
        String emailContent = "<!DOCTYPE html>\n"
                + "<link href=\"//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n"
                + "<script src=\"//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js\"></script>\n"
                + "<script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\n"
                + "<!------ Include the above in your HEAD tag ---------->\n"
                + "\n"
                + "<div class=\"container\">\n"
                + "    <div class=\"row\">\n"
                + "        <div class=\"col-xs-12\">\n"
                + "            <div class=\"invoice-title\">\n"
                + "                <h2>Hóa Đơn</h2><h3 class=\"pull-right\">Mã Đơn Hàng: </h3>\n"
                + "            </div>\n"
                + "            <hr>\n"
                + "            <div class=\"row\">\n"
                + "                <div class=\"col-xs-6\">\n"
                + "                    <address>\n"
                + "                        <strong>Tên Khách Hàng</strong><br>\n"
                + "                        " + user.getName() + "<br>\nĐịa chỉ khách hàng: "
                + "                       " + user.getAddress() + "<br>\n"
                + "                    </address>\n"
                + "                </div>\n"
                + "                <div class=\"col-xs-6 text-right\">\n"
                + "                    <address>\n"
                + "                        <strong>Người Nhận</strong><br>\n"
                + "                        " + user.getName() + "<br>\nĐịa chỉ nhận hàng: "
                + "                        " + user.getAddress() + "<br>\n"
                + "                    </address>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "            <div class=\"row\">\n"
                + "                <div class=\"col-xs-6\">\n"
                + "                    <address>\n"
                + "                        <strong>Phương thức thanh toán</strong><br>\n"
                + "                        Thanh Toán Khi Nhận Hàng<br>Email liên hệ: \n"
                + "                        " + user.getEmail() + "\n"
                + "                    </address>\n"
                + "                </div>\n"
                + "                <div class=\"col-xs-6 text-right\">\n"
                + "                    <address>\n"
                + "                        <strong>Ngày Đặt Hàng</strong><br>\n"
                + "                        " + order.getDate() + "<br><br>\n"
                + "                    </address>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "\n"
                + "    <div class=\"row\">\n"
                + "        <div class=\"col-md-12\">\n"
                + "            <div class=\"panel panel-default\">\n"
                + "                <div class=\"panel-heading\">\n"
                + "                    <h3 class=\"panel-title\"><strong>Thống kê đơn hàng</strong></h3>\n"
                + "                </div>\n"
                + "                <div class=\"panel-body\">\n"
                + "                    <div class=\"table-responsive\">\n"
                + "                        <table class=\"table table-condensed\">\n"
                + "                            <thead>\n"
                + "                                <tr>\n"
                + "                                    <td><strong>Tên Sản Phẩm</strong></td>\n"
                + "                                    <td class=\"text-center\"><strong>Giá</strong></td>\n"
                + "                                    <td class=\"text-center\"><strong>Số Lượng</strong></td>\n"
                + "                                    <td class=\"text-right\"><strong>Giá Tiền</strong></td>\n"
                + "                                </tr>\n"
                + "                            </thead>\n"
                + "                            <tbody>\n";
        for (Cart cart : cartData) {
            emailContent += "<tr>\n"
                    + "                                    <td>" + cart.getProductName() + "</td>\n"
                    + "                                    <td class=\"text-center\">" + cart.getPrice() + "</td>\n"
                    + "                                    <td class=\"text-center\">" + cart.getQuantity() + "</td>\n"
                    + "                                    <td class=\"text-right\">" + cart.getTotalcost() + "</td>\n"
                    + "                                </tr>";
        }
        emailContent += "<tr>\n"
                + "                                    <td class=\"thick-line\"></td>\n"
                + "                                    <td class=\"thick-line\"></td>\n"
                + "                                    <td class=\"thick-line text-center\"><strong>Thành Tiền</strong></td>\n"
                + "                                    <td class=\"thick-line text-right\">" + totalPriceBefore + "</td>\n"
                + "                                </tr>\n";
        if (!totalPriceAfter.equals(totalPriceBefore)) {
            emailContent += "                                <tr>\n"
                    + "                                    <td class=\"no-line\"></td>\n"
                    + "                                    <td class=\"no-line\"></td>\n"
                    + "                                    <td class=\"no-line text-center\"><strong>Giảm giá</strong></td>\n"
                    + "                                    <td class=\"no-line text-right\">" + discountPrice + "</td>\n"
                    + "                                </tr>\n";

        }
        emailContent += "<tr>\n"
                + "                                    <td class=\"no-line\"></td>\n"
                + "                                    <td class=\"no-line\"></td>\n"
                + "                                    <td class=\"no-line text-center\"><strong>Tổng</strong></td>\n"
                + "                                    <td class=\"no-line text-right\">" + totalPriceAfter + "</td>\n"
                + "                                </tr>\n"
                + "                            </tbody>\n"
                + "                        </table>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</div>";
        String email = user.getEmail();
        if (email != null || !email.equals("")) {
            // sending otp
//            Random rand = new Random();
//            otpvalue = rand.nextInt(1255650);

            String to = email;// change accordingly
            // Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("ccvnphu0001@gmail.com", "fkxuohzmowelkohj");// Put your email
                    // id and
                    // password here
                }
            });
            // compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email));// change accordingly
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Chi Tiết Hóa Đơn Thanh Toán","UTF-8");
//				message.setText("your OTP is: " + otpvalue+"<a href='http://localhost:9999/LoginAndRegisterForm/forgotPasswordX.jsp?name="+email+"'> click me</a>");
//                                message.setText("your OTP is: " + otpvalue);
                message.setContent(emailContent, "text/html;charset=UTF-8");
                // send message
                Transport.send(message);
                System.out.println("Message sent successfully");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        SendMail sendMail = new SendMail();
//        sendMail.SendMailCheckOut("ducnvhe160331@fpt.edu.vn", sendMail.checkoutContent);
    }
}
