package Controller.Manager;

import Dal.CategoriesDAO;
import Dal.ManagerDAO;
import Dal.ProductDAO;
import Model.Earphone;
import Model.Products;
import com.oracle.wls.shaded.org.apache.bcel.generic.DDIV;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerUpdateProductController extends HttpServlet {

    ManagerDAO dao = new ManagerDAO();
    ProductDAO daop = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        Products p = dao.getProductsByID(id);
        if ("1".equals(p.getCategories().getCategoryID())) {
            req.setAttribute("earphone",
                    daop.getEarphoneByProductID(p.getProductID()));
        }
        System.out.println("p.getDate(): " + p.getDate());
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            p.setDate(new SimpleDateFormat("yyyy-MM-dd").format(sf.parse(p.getDate())));
        } catch (ParseException ex) {
            Logger.getLogger(ManagerUpdateProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        CategoriesDAO ca = new CategoriesDAO();
        req.setAttribute("categoriesList", ca.GetCategoriesList());
        req.setAttribute("o", p);
        req.getRequestDispatcher("editproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("pid");
        CategoriesDAO ca = new CategoriesDAO();
        req.setAttribute("categoriesList", ca.GetCategoriesList());
        Products p = dao.getProductsByID(id);

        String Cid = req.getParameter("category");
        String Name = req.getParameter("name");
        String Desciption = req.getParameter("description");
        String Image1 = req.getParameter("image");
        String Image2 = req.getParameter("image2");
        String Image3 = req.getParameter("image3");
        String Price = req.getParameter("price").replace(",", "");
        String Quantity = req.getParameter("quantity");
        String Status = req.getParameter("status");
        String date = req.getParameter("date");

        p.setProductID(id);
        p.setProduct_categoryID(Cid);
        p.setName(Name);
        p.setDesciption(Desciption);
        p.setPicture(Image1);
        p.setPicture2(Image2);
        p.setPicture3(Image3);
        p.setQuantity(Quantity);
        p.setPrice(Price);
        p.setStatus(Status);
        p.setDate(date);

        Earphone e = new Earphone();
        String type = req.getParameter("type");
        String frequency = req.getParameter("frequency");
        String sensitive = req.getParameter("sensitive");
        String impedance = req.getParameter("impedance");
        String meterial = req.getParameter("meterial");
        String size = req.getParameter("size");
        String battery = req.getParameter("battery");
        String connection_distance = req.getParameter("connection_distance");
        String wire_length = req.getParameter("wire_length");
        if ("1".equals(Cid)) {
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
            daop.updateEarphone(e);
        }

        if (Status.equals("0")) {
            p.setQuantity("0");
            dao.updateProduct(p);
            req.setAttribute("successText", "Update Successful!!!");
        } else if (Integer.parseInt(Quantity) == 0) {
            p.setStatus("0");
            dao.updateProduct(p);
            req.setAttribute("successText", "Update Successful!!!");
        } else if (Status.equals("0") && Integer.parseInt(Quantity) == 0
                || Status.equals("1") && Integer.parseInt(Quantity) > 0) {
            dao.updateProduct(p);
            req.setAttribute("successText", "Update Successful!!!");
        }

        req.setAttribute("o", p);
        req.setAttribute("earphone", e);
        req.getRequestDispatcher("editproduct.jsp").forward(req, resp);

    }
}
