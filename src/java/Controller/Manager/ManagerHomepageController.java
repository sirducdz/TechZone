package Controller.Manager;

import Dal.ManagerDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ManagerHomepageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ManagerDAO dao = new ManagerDAO();
        req.setAttribute("countP", dao.countProductByProductID());
        req.setAttribute("countO", dao.countOrder());
        req.setAttribute("countPS", dao.countProductStock());
        req.setAttribute("countOC", dao.countOrderCancelled());
        dao.getNewOrder();
        req.setAttribute("listO", dao.getOrder());
        req.getRequestDispatcher("homepage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

}