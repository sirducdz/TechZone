package Controller.Admin;

import Controller.View.*;
import Dal.CategoriesDAO;
import Dal.ProductDAO;
import Model.Categories;
import Model.Earphone;
import Model.Products;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class EditProductController extends HttpServlet {

    ProductDAO productDAO = new ProductDAO();

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditProductController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        String id = request.getParameter("id");
        Products p = productDAO.getProductsByID(id);
        if (p != null) {
            if("1".equals(p.getCategories().getCategoryID()))
                request.setAttribute("earphone", 
                        productDAO.getEarphoneByProductID(p.getProductID()));
            CategoriesDAO ca = new CategoriesDAO();
            request.setAttribute("categoriesList", ca.GetCategoriesList());
            request.setAttribute("p", p);
            request.getRequestDispatcher("addproduct.jsp").forward(request, response);
        } else {
            CategoriesDAO ca = new CategoriesDAO();
            request.setAttribute("categoriesList", ca.GetCategoriesList());
            request.getRequestDispatcher("addproduct.jsp").forward(request, response);
        }
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
        String id = request.getParameter("id");
        Products p = productDAO.getProductsByID(id);
//        Earphone e = productDAO.
        if (p != null) {
            String category = request.getParameter("category");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String image = request.getParameter("image");
            String image2 = request.getParameter("image2");
            String image3 = request.getParameter("image3");
            String quantity = request.getParameter("quantity");
            String price = request.getParameter("price");
            String status = request.getParameter("status");
            
            p.setProductID(id);
            p.setProduct_categoryID(category);
            p.setName(name);
            p.setDesciption(description);
            p.setPicture(image);
            p.setPicture2(image2);
            p.setPicture3(image3);
            p.setQuantity(quantity);
            p.setPrice(price);
            p.setStatus(status);
            productDAO.updateProduct(p);
            if("1".equals(category)){
            Earphone e = new Earphone();
            String type = request.getParameter("type");
            String frequency = request.getParameter("frequency");
            String sensitive = request.getParameter("sensitive");
            String impedance = request.getParameter("impedance");
            String meterial = request.getParameter("meterial");
            String size = request.getParameter("size");
            String battery = request.getParameter("battery");
            String connection_distance= request.getParameter("connection_distance");
            String wire_length = request.getParameter("wire_length");
            
            e.setType(type);
            e.setFrequency(frequency);
            e.setSensitive(sensitive);
            e.setImpedance(impedance);
            e.setMeterial(meterial);
            e.setSize(size);
            e.setBattery(battery);
            e.setConnection_distance(connection_distance);
            e.setWire_length(wire_length);
            e.setEarphone_ProductID(id);
            productDAO.updateEarphone(e);
            }
            
        } 
        else {
            p = new Products();
            String category = request.getParameter("category");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String image = request.getParameter("image");
            String image2 = request.getParameter("image2");
            String image3 = request.getParameter("image3");
            String quantity = request.getParameter("quantity");
            String price = request.getParameter("price");
            String status = request.getParameter("status");
            String date = request.getParameter("date");
            
            p.setProduct_categoryID(category);
            p.setName(name);
            p.setDesciption(description);
            p.setPicture(image);
            p.setPicture2(image2);
            p.setPicture3(image3);
            p.setQuantity(quantity);
            p.setPrice(price);
            p.setStatus(status);
            p.setDate(date);
            productDAO.addNewProduct(p);
            if(category == "1"){
            Earphone e = new Earphone();
            String type = request.getParameter("type");
            String frequency = request.getParameter("frequency");
            String sensitive = request.getParameter("sensitive");
            String impedance = request.getParameter("impedance");
            String meterial = request.getParameter("meterial");
            String size = request.getParameter("size");
            String battery = request.getParameter("battery");
            String connection_distance= request.getParameter("connection_distance");
            String wire_length = request.getParameter("wire_length");
            
            e.setType(type);
            e.setFrequency(frequency);
            e.setSensitive(sensitive);
            e.setImpedance(impedance);
            e.setMeterial(meterial);
            e.setSize(size);
            e.setBattery(battery);
            e.setConnection_distance(connection_distance);
            e.setWire_length(wire_length);
            e.setEarphone_ProductID(productDAO.getLastId()+"");
            productDAO.addNewEarphone(e);
            }
        }
        response.sendRedirect("AdminController");
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