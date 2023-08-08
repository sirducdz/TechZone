package Controller.View;

import Dal.ProductDAO;
import Model.Earphone;
import Model.Products;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author PC
 */
public class CompareProductController extends HttpServlet {

    private String categoryID = "1";
    private String sortOrder = "rate";

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
            ProductDAO pdao = new ProductDAO();
            HttpSession session = request.getSession();
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
            decimalFormat.applyPattern("#,###");
            if (request.getParameter("input1") != null) {
                Earphone earphone1 = pdao.getProductByIDComPare(request.getParameter("input1"));
                earphone1.setSalePrice(decimalFormat.format(Float.parseFloat(earphone1.getSalePrice())).replace(",", "."));
                session.setAttribute("product1", earphone1);
            } else if (request.getParameter("input2") != null) {
                Earphone earphone2 = pdao.getProductByIDComPare(request.getParameter("input2"));
                earphone2.setSalePrice(decimalFormat.format(Float.parseFloat(earphone2.getSalePrice())).replace(",", "."));
                session.setAttribute("product2", earphone2);
            } else if (request.getParameter("productNameInput") != null) {
                ArrayList<Earphone> EarphoneList = pdao.getEarphoneListByCategoryIDAndNameAndSort(categoryID, request.getParameter("productNameInput"), sortOrder);
                if (request.getParameter("inputType").equals("input1")) {
                    for (Earphone earphone : EarphoneList) {
                        out.print("<a href=\"CompareProductController?input1=" + earphone.getProductID() + "\" style=\"text-decoration: none\"><li style=\"font-size: 20px\">" + earphone.getName() + "</li></a><br>");
                    }
                } else {
                    for (Earphone earphone : EarphoneList) {
                        out.print("<a href=\"CompareProductController?input2=" + earphone.getProductID() + "\" style=\"text-decoration: none\"><li style=\"font-size: 20px\">" + earphone.getName() + "</li></a><br>");
                    }
                }
                return;
            } else {
                String productID = request.getParameter("productID");
                Earphone product1 = pdao.getProductByIDComPare(productID);
                product1.setSalePrice(decimalFormat.format(Float.parseFloat(product1.getSalePrice())).replace(",", "."));
                session.setAttribute("product1", product1);
            }
            request.getRequestDispatcher("compareProduct.jsp").forward(request, response);
//            out.print("productName: "+ request.getParameter("productName")); 
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
