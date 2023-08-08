package Controller.Saler;

import Dal.OrderDAO;
import Dal.SalerDAO;
import Model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author HAI DANG
 */
public class SalerOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SalerDAO dao = new SalerDAO();
        List<Order> list = dao.getAllOrder();
        request.setAttribute("listO", list);
        request.getRequestDispatcher("../saler/ordersaler.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        String Status = request.getParameter("Status");

        OrderDAO odao = new OrderDAO();

        odao.UpdateOrderByID(Status, orderId);
        SalerDAO dao = new SalerDAO();
        dao.getAllOrder();
        request.setAttribute("listO", dao.getAllOrder());
        request.getRequestDispatcher("ordersaler.jsp").forward(request, response);
    }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
