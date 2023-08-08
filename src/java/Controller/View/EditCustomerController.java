package Controller.View;

import Dal.AccountDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
//import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author PC
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class EditCustomerController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (request.getParameter("saveChanges") != null) {
                AccountDao accountDao = new AccountDao();
                String name = request.getParameter("name");
                String phone_number = request.getParameter("phone_number");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                String age = request.getParameter("age");
                String user_sexID =request.getParameter("user_sexID"); 
                boolean checkEmail = accountDao.checkExistAccountByEmailAndUserID(email,user.getUserID());
                if (checkEmail) {
                    request.setAttribute("Message", "Email người dùng đã tồn tại!");
                    request.getRequestDispatcher("userProfile.jsp").forward(request, response);
                    return;
                }
                if (!request.getPart("avatar").getSubmittedFileName().isEmpty()) {
                    String UploadPath = request.getServletContext().getRealPath("view/UserImage");
                    out.print(UploadPath);
                    File file = new File(UploadPath);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    Part photoPart = request.getPart("avatar");
                    String fileName = photoPart.getSubmittedFileName();
                    photoPart.write(UploadPath + "/" + fileName);
                    user.setAvatar(fileName);
                }
                user.setUser_sexID(user_sexID);
                user.setName(name);
                user.setPhone_number(phone_number);
                user.setEmail(email);
                user.setAddress(address);
                user.setAge(age);
                session.setAttribute("user", user);
                
                accountDao.EditUser(user);
                request.getRequestDispatcher("userProfile.jsp").forward(request, response);
            } else if (user != null) {
                request.getRequestDispatcher("userProfile.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
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
