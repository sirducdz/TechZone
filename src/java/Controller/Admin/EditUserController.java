package Controller.Admin;

import Dal.AccountDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class EditUserController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String userID = request.getParameter("userID");
            HttpSession session = request.getSession();
            if (request.getParameter("Create") != null) {
                userID = request.getParameter("userID");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String phone_number = request.getParameter("phone_number");
                String age = request.getParameter("age");
                String address = request.getParameter("address");
                String user_sexID = request.getParameter("user_sexID");
                String user_roleID = request.getParameter("user_roleID");
                String status = request.getParameter("status");
                User user = new User(userID, username, password, user_roleID, name, age, user_sexID, address, phone_number, status);
                AccountDao accountDao = new AccountDao();
                accountDao.AddUserByAdmin(user);
//                System.out.println(user);
//               response.sendRedirect("ManagerUserController");
                request.getRequestDispatcher("ManagerUserController").forward(request, response);
                return;
            } else if (request.getParameter("Submit") != null) {
                userID = request.getParameter("userID");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String phone_number = request.getParameter("phone_number");
                String age = request.getParameter("age");
                String address = request.getParameter("address");
                String user_sexID = request.getParameter("user_sexID");
                String user_roleID = request.getParameter("user_roleID");
                String status = request.getParameter("status");
                out.print("status: " + status);
                User user = new User(userID, username, password, user_roleID, name, age, user_sexID, address, phone_number, status);
                AccountDao accountDao = new AccountDao();
                accountDao.EditUserByAdmin(user);
                request.setAttribute("user", accountDao.GetUserByUserID(userID));
                request.setAttribute("message", "Lưu thay đổi thành công!");
                // request.getRequestDispatcher("edituser.jsp").forward(request, response);
//                response.sendRedirect("ManagerUserController");
                request.getRequestDispatcher("edituser.jsp").forward(request, response);
                return;
            } else {

                ArrayList<User> data = (ArrayList<User>) session.getAttribute("data");
                User usertemp = null;
                for (User user : data) {
                    if (user.getUserID().equals(userID)) {
                        usertemp = user;
                        break;
                    }
                }
                request.setAttribute("user", usertemp);
//                session.setAttribute("user", usertemp);
//                  request.getRequestDispatcher("edituser.jsp").forward(request, response);
            }
            request.getRequestDispatcher("edituser.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
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
