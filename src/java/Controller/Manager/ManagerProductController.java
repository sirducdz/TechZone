package Controller.Manager;

import Dal.CategoriesDAO;
import Dal.ManagerDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class ManagerProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ManagerDAO dao = new ManagerDAO();
        CategoriesDAO cdao = new CategoriesDAO();
        dao.getAllProduct();
        req.setAttribute("dao", dao);
        req.setAttribute("listP", dao.getProduct());
        req.setAttribute("listC", cdao.GetCategoriesList());
        req.getRequestDispatcher("productmanager.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
    }

}
