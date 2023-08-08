package Controller.Account;

import Dal.AccountDao;
import Impl.LoginAndRegisterValidation;
import Impl.SendMail;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author DucPhaoLo
 */
public class ForgetPasswordController extends HttpServlet {

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
            if (request.getParameter("confirm") != null) {
                String email = request.getParameter("email");
                SendMail sendMail = new SendMail();
                sendMail.SendMailReset(email);
                String message = "A verification link has been sent to your email account";
                request.setAttribute("email", email);
                request.setAttribute("message", message);
                request.getRequestDispatcher("forgetpassword.jsp").forward(request, response);
            } else if (request.getParameter("email") != null)// g?i mail
            {
                String email = request.getParameter("email");
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
//                accountDao.resetPassword(email, newPassword)
            } else if (request.getParameter("resetPassword") != null)// g?i mail
            {
                String password = request.getParameter("password");
                String repassword = request.getParameter("repassword");
                String message1 = null, message2 = null;
                LoginAndRegisterValidation validate = new LoginAndRegisterValidation();
                if (!validate.PassWordValidate(password) || !validate.CheckEqualRepasswordValidate(password.trim(), repassword)) {
                    if (!validate.PassWordValidate(password)) {
                        message1 = "Yêu cầu mật khẩu phải có ít nhất 8 ký tự và phải chứa ít nhất một chữ cái viết thường, một chữ cái viết hoa, một chữ số và một ký tự đặc biệt trong tập hợp [@#$%^&+=]. Ngoài ra, mật khẩu không được chứa khoảng trắng (dấu cách).";
                    }
                    if (!validate.CheckEqualRepasswordValidate(password.trim(), repassword)) {
                        message2 = "Nhập Lại Mật Khẩu Không Trùng Với Mật Khẩu Đã Tạo";
                    }
                    request.setAttribute("message1", message1);
                    request.setAttribute("message2", message2);
                    request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
                } else if (message1 == null && message2 == null) {// if else 
                    HttpSession session = request.getSession();
                    String email = (String) session.getAttribute("email");
                    accountDao.resetPassword(email, request.getParameter("password"));
                    request.setAttribute("allowResetPassword", "true");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
