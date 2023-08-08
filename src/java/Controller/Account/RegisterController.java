package Controller.Account;

import Impl.LoginAndRegisterValidation;
import Dal.AccountDao;
import Impl.SendMail;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DucPhaoLo
 */
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            AccountDao accountDao = new AccountDao();
            String fullName = request.getParameter("fullName");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String rePassword = request.getParameter("rePassword");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String phone = request.getParameter("phone");
            String allowRegister = request.getParameter("allowRegister");
            String agree_term = request.getParameter("agree_term");
            LoginAndRegisterValidation validate = new LoginAndRegisterValidation();
            String msg1 = null, msg2 = null, msg3 = null, msg4 = null, msg5 = null, msg6 = null, msg7 = null, msg8 = null, registerMessage = null;
            if (!validate.FullNameValidate(fullName)) {
                msg1 = "Your name is not valid!";
            }
            if (!validate.UserNameValidate(userName)) {
                msg2 = "Chỉ cho phép các ký tự chữ cái (a-z, A-Z), chữ số (0-9), dấu gạch dưới (_) và dấu gạch ngang (-), và yêu cầu tên đăng nhập có độ dài từ 8 đến 16 ký tự";
            }

            if (accountDao.checkExistAccount(userName)) {
                msg2 = "Tên người dùng đã tồn tại";
            }
            if (!validate.PassWordValidate(password)) {
                msg3 = "Yêu cầu mật khẩu phải có ít nhất 8 ký tự và phải chứa ít nhất một chữ cái viết thường, một chữ cái viết hoa, một chữ số và một ký tự đặc biệt trong tập hợp [@#$%^&+=]. Ngoài ra, mật khẩu không được chứa khoảng trắng (dấu cách).";
            }
            if (!validate.CheckEqualRepasswordValidate(password.trim(), rePassword.trim())) {
                msg4 = "Nhập Lại Mật Khẩu Không Trùng Với Mật Khẩu Đã Tạo";
            }
            if (!validate.EmailValidate(email) || accountDao.checkExistEmail(email)) {
                msg5 = "Email Không Hợp Lệ";
                if (accountDao.checkExistEmail(email)) {
                    msg5 = "Email đăng kí đã tồn tại";
                }
            }
            try {
                if (!validate.DOBValidate(dob)) {
                    msg6 = "Bạn cần 12 tuổi hoặc hơn để đăng kí";
                }
            } catch (ParseException ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                msg6 = "Yêu Cầu Nhập Ngày Sinh";
            }
            if (!validate.PhoneNumberValidate(phone)) {
                if (phone.equals("")) {
                    msg7 = "Bạn chưa nhập số điện thoại đăng kí";
                } else {
                    msg7 = "Số điện thoại đăng kí không hợp lệ";
                }
            }
            if (agree_term == null) {
                msg8 = "Bạn Cần Đồng Ý Với Điều Khoản Để Tiến Hành Đăng Kí";
            }
            if (msg1 == null && msg2 == null && msg3 == null && msg4 == null && msg5 == null && msg6 == null && msg7 == null && msg8 == null) {
                registerMessage = "A verification link has been sent to your email account";
                SendMail sendMail = new SendMail();
                sendMail.SendMail(email, fullName, userName, password, dob, phone);
            }
            request.setAttribute("fullName", fullName);
            request.setAttribute("userName", userName);
            request.setAttribute("password", password);
            request.setAttribute("rePassword", rePassword);
            request.setAttribute("email", email);
            request.setAttribute("dob", dob);
            request.setAttribute("phone", phone);
            request.setAttribute("agree_term", agree_term);
            request.setAttribute("msg1", msg1);
            request.setAttribute("msg2", msg2);
            request.setAttribute("msg3", msg3);
            request.setAttribute("msg4", msg4);
            request.setAttribute("msg5", msg5);
            request.setAttribute("msg6", msg6);
            request.setAttribute("msg7", msg7);
            request.setAttribute("msg8", msg8);
            request.setAttribute("registerMessage", registerMessage);
            request.getRequestDispatcher("/auth/register.jsp").forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            AccountDao accountDao = new AccountDao();
            String allowRegister = request.getParameter("allowRegister");
            String fullName = request.getParameter("fullName");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String rePassword = request.getParameter("rePassword");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            String phone = request.getParameter("phone");
            if (allowRegister != null) {
                try {
                    LoginAndRegisterValidation loginAndRegisterValidation = new LoginAndRegisterValidation();
//                    String userID = String.valueOf((accountDao.GetUserIndex() + 1));
                    boolean checkAdd = accountDao.AddUser(new User(null, userName, password, "3", fullName, String.valueOf(loginAndRegisterValidation.GetAge(dob)), "1", null, phone, null, null, email, "1"));
                } catch (Exception e) {
                    System.out.println("RegisterController: " + e);
                }
                request.setAttribute("allowRegister", allowRegister);
                request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
