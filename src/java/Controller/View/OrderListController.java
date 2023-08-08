package Controller.View;

import Dal.OrderDAO;
import Model.Order;
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
public class OrderListController extends HttpServlet {

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
            HttpSession session = request.getSession();
            if (session.getAttribute("user") != null) {
                OrderDAO orderDAO = new OrderDAO();
                if (request.getParameter("submit") != null) {
                    orderDAO.UpdateOrderByID("Cancelled", request.getParameter("orderID"));
                } else if (request.getParameter("ConfirmGetOrder") != null) {
                    orderDAO.UpdateOrderByID("Completed", request.getParameter("orderID"));
                }
                String status = request.getParameter("status");
                User user = (User) session.getAttribute("user");
                if (status == null) {
                    status = "All";
                    ArrayList<Order> AllOrder = orderDAO.GetOrderListByUserID(user.getUserID(), status);// **
                    session.setAttribute("AllOrder", AllOrder);
                }
                request.setAttribute("status", status);
                ArrayList<Order> orderList = orderDAO.GetOrderListByUserID(user.getUserID(), status);// **
                session.setAttribute("data", orderList);
                ArrayList<Order> orderListCanceled = orderDAO.GetOrderListByUserID(user.getUserID(), "Cancelled");// **
                session.setAttribute("orderListCanceledAmount", orderListCanceled.size());
                ArrayList<Order> orderListCompleted = orderDAO.GetOrderListByUserID(user.getUserID(), "Completed");// **
                session.setAttribute("orderListCompletedAmount", orderListCompleted.size());
                ArrayList<Order> orderListShipping = orderDAO.GetOrderListByUserID(user.getUserID(), "Shipping");// **
                session.setAttribute("orderListShippingAmount", orderListShipping.size());
                ArrayList<Order> orderListPending = orderDAO.GetOrderListByUserID(user.getUserID(), "Pending");// **
                session.setAttribute("orderListPendingAmount", orderListPending.size());
                request.getRequestDispatcher("orderList.jsp").forward(request, response);
//                
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
