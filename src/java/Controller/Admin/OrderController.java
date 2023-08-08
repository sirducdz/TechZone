package Controller.Admin;

import Dal.ManagerDAO;
import Dal.OrderDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        ManagerDAO dao = new ManagerDAO();
        dao.getListOrder();
        req.setAttribute("listO", dao.getOrder());
        req.getRequestDispatcher("ordermanager.jsp").forward(req, resp);
    } 

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        String newStatus = req.getParameter("newStatus");

        OrderDAO odao = new OrderDAO();

        odao.UpdateOrderByID(newStatus, orderId);
        ManagerDAO dao = new ManagerDAO();
        dao.getListOrder();
        req.setAttribute("listO", dao.getOrder());
        req.getRequestDispatcher("ordermanager.jsp").forward(req, resp);
    }

}
