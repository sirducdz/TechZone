package Controller.Account;

import Dal.AccountDao;
import Impl.LoginAndRegisterValidation;
import Model.User;
import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
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
public class ChangePasswordController extends HttpServlet {

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
            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("user");
            if (u != null) {
                if (request.getParameter("tab") != null) {
                    request.getRequestDispatcher("changepassword.jsp").forward(request, response);
                } else if (request.getParameter("submit") != null) {
//                
                    String currentPassword = request.getParameter("currentPassword");
                    String password = request.getParameter("password");
                    String rePassword = request.getParameter("rePassword");
                    String changepasswordSuccess;
                    LoginAndRegisterValidation validate = new LoginAndRegisterValidation();
                    String msg1 = null, msg2 = null, msg3 = null;
                    if (!u.getPassword().equals(currentPassword)) {
                        msg1 = "Mật khẩu hiện tại không đúng";
                    } else {
                        if (!validate.PassWordValidate(password)) {
                            msg2 = "Yêu cầu mật khẩu phải có ít nhất 8 ký tự và phải chứa ít nhất một chữ cái viết thường, một chữ cái viết hoa, một chữ số và một ký tự đặc biệt trong tập hợp [@#$%^&+=]. Ngoài ra, mật khẩu không được chứa khoảng trắng (dấu cách).";
                        }
                        if (!validate.CheckEqualRepasswordValidate(password.trim(), rePassword.trim())) {
                            msg3 = "Nhập Lại Mật Khẩu Không Trùng Với Mật Khẩu Đã Tạo";
                        }
                    }
                    if (msg1 == null && msg2 == null && msg3 == null) {
                        AccountDao accountDao = new AccountDao();
                        accountDao.ChangePassword(u.getUsername(), password);
                        request.setAttribute("changepasswordSuccess","true"); 
                        request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
                        return;
                    }
                    request.setAttribute("msg1", msg1);
                    request.setAttribute("msg2", msg2);
                    request.setAttribute("msg3", msg3);
                    request.getRequestDispatcher("/auth/changepassword.jsp").forward(request, response);
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
