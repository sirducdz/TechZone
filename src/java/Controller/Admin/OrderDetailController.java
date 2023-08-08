package Controller.Admin;

import Dal.ManagerDAO;
import Model.DetailOrder;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class OrderDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ManagerDAO dao = new ManagerDAO();
        String id = req.getParameter("id");
        dao.getListOrder();
        req.setAttribute("od", dao.getAllDetailOrderByOrderID(id));
        float total = 0;
        for (DetailOrder orderDetail : dao.getAllDetailOrderByOrderID(id)) {
            total += (Float.parseFloat(orderDetail.getQuantity()) * Float.parseFloat(orderDetail.getPrice_product().replace(",", "")));
        }
        double tax = total * 0.1;
        double grandTotal = total + tax;
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
        decimalFormat.applyPattern("#,###");
        req.setAttribute("grandTotalSale", decimalFormat.format(dao.sumPrice(Integer.parseInt(id))));
        req.setAttribute("total", decimalFormat.format(total));
        req.setAttribute("tax", decimalFormat.format(tax));
        req.setAttribute("grandTotal", decimalFormat.format(grandTotal));
        req.getRequestDispatcher("orderdetail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

}
