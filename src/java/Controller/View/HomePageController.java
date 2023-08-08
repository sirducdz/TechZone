package Controller.View;

import Dal.ProductDAO;
import Model.Categories;
import Model.Products;
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
 * @author DucPhaoLo
 */
public class HomePageController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String tab = request.getParameter("tab");
            ProductDAO productDAO = new ProductDAO();
            HttpSession session = request.getSession();
            if (tab == null || tab.equals("homepage")) {
                ArrayList<Products> bestProductList = new ArrayList<>();
                bestProductList = productDAO.BestSellerProducts();
                session.setAttribute("bestProductList", bestProductList);
//                out.print(bestProductList.size()+"<br>"); 
                String type = request.getParameter("type");
                ArrayList<Products> typeProductList = null;
                if (type != null) {

                    typeProductList = productDAO.getProductListByType(type);
                    out.print("<nav class=\"row\">\n"
                            + "                                <ul class=\"product__list hide-on-mobile\" id=\"UlObject\">");
                    if (type.equals("Wired")) {
                        out.print("<li class=\"product__item product__item--active\">\n"
                                + "                                            <a href=\"HomePageController?type=Wired\" id=\"Wired\" onclick=\"TypeChangeFunc('Wired','articleTab',)\" class=\"product__link\">Sản Phẩm Kết Nối Dây</a>\n"
                                + "                                        </li>");
                    }
                    if (!type.equals("Wired")) {
                        out.print("<li class=\"product__item\">\n"
                                + "                                            <a href=\"HomePageController?type=Wired\" id=\"Wired\" onclick=\"TypeChangeFunc('Wired','articleTab')\" class=\"product__link\">Sản Phẩm Kết Nối Dây</a>\n"
                                + "                                        </li>");
                    }
                    if (type.equals("Wireless")) {
                        out.print("<li class=\"product__item product__item--active\">\n"
                                + "                                            <a href=\"HomePageController?type=Wireless\" id=\"Wireless\" onclick=\"TypeChangeFunc('Wireless','articleTab')\" class=\"product__link\">Sản Phẩm Kết Nối Bluetooth</a>\n"
                                + "                                        </li>");
                    }
                    if (!type.equals("Wireless")) {
                        out.print("<li class=\"product__item\">\n"
                                + "                                            <a href=\"HomePageController?type=Wireless\" id=\"Wireless\" onclick=\"TypeChangeFunc('Wireless','articleTab')\" class=\"product__link\">Sản Phẩm Kết Nối Bluetooth</a>\n"
                                + "                                        </li>");
                    }
                    if (type.equals("Console")) {
                        out.print("<li class=\"product__item product__item--active\">\n"
                                + "                                            <a href=\"HomePageController?type=Console\" id=\"Console\" onclick=\"TypeChangeFunc('Console','articleTab')\" class=\"product__link\">Sản Phẩm Mới Nhất </a>\n"
                                + "                                        </li>");
                    }
                    if (!type.equals("Console")) {
                        out.print("<li class=\"product__item\">\n"
                                + "                                            <a href=\"HomePageController?type=Console\" id=\"Console\" onclick=\"TypeChangeFunc('Console','articleTab')\" class=\"product__link\">Sản Phẩm Mới Nhất </a>\n"
                                + "                                        </li>");
                    }
                    if (type.equals("HighPrice")) {
                        out.print("<li class=\"product__item product__item--active\">\n"
                                + "                                            <a href=\"HomePageController?type=HighPrice\" id=\"HighPrice\" onclick=\"TypeChangeFunc('HighPrice','articleTab')\" class=\"product__link\">Sản Phẩm Cao Cấp</a>\n"
                                + "                                        </li>");
                    }
                    if (!type.equals("HighPrice")) {
                        out.print("<li class=\"product__item\">\n"
                                + "                                            <a href=\"HomePageController?type=HighPrice\" id=\"HighPrice\" onclick=\"TypeChangeFunc('HighPrice','articleTab')\" class=\"product__link\">Sản Phẩm Cao Cấp</a>\n"
                                + "                                        </li>");
                    }
                    out.print("</ul>                              \n"
                            + "                            </nav>\n"
                            + "\n"
                            + "                            <div class=\"row product__panel\" id=\"row product__panel\">");
                    for (Products item : typeProductList) {
                        out.print("<div class=\"product__panel-item col-lg-3 col-md-4 col-sm-6\">\n"
                                + "                                        <div class=\"product__panel-item-wrap\">\n"
                                + "                                            <div class=\"product__panel-img-wrap\">\n"
                                + "                                                <a href=\"ProductDetailController?ProductID=" + item.getProductID() + "\">\n"
                                + "                                                    <img src=\"" + item.getPicture() + "\" alt=\"\" class=\"product__panel-img\">\n"
                                + "                                                </a>\n"
                                + "                                            </div>\n"
                                + "                                            <h3 class=\"product__panel-heading\">\n"
                                + "                                                <a href=\"ProductDetailController?ProductID=" + item.getProductID() + "\" class=\"product__panel-link\">" + item.getName() + "</a>\n"
                                + "                                            </h3>\n"
                                + "                                            <div class=\"product__panel-rate-wrap\">\n"
                                + "                                                <i class=\"product__panel-rate\" style=\"text-decoration: underline;font-size: 20px; margin-right: 5px\">" + item.getRateStar() + "</i>\n"
                                + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                + "                                            </div>\n"
                                + "\n"
                                + "                                            <div class=\"product__panel-price\">\n");
                        if (!item.getSale().equals("0")) {
                            out.print("<span class=\"product__panel-price-old\">\n"
                                    + "                                                        " + item.getPrice() + "đ\n"
                                    + "                                                    </span>");
                        }
                        out.print("<span class=\"product__panel-price-current\">\n"
                                + "                                                    " + item.getSalePrice() + "đ\n"
                                + "                                                </span>\n"
                                + "                                            </div>");
                        if (!item.getSale().equals("0")) {
                            out.print("<div class=\"product__panel-price-sale-off\">\n"
                                    + "                                                    -" + item.getSale() + "%\n"
                                    + "                                                </div>");
                        }
                        out.print(" </div>\n"
                                + "                                    </div>");
                    }
                    out.print("</div>");
                    return;
                } else if (session.getAttribute("type") != null) {
                    type = (String) session.getAttribute("type");
                    typeProductList = productDAO.getProductListByType(type);
                } else {
                    type = "Wired";
                    typeProductList = productDAO.getProductListByType(type);
                }
                session.setAttribute("typeProductList", typeProductList);
                session.setAttribute("type", type);

                ArrayList<Products> bottomDataList = productDAO.GetRandomProduct(productDAO.GetProductListByCategoryID(null), 6);
                session.setAttribute("bottomDataList", bottomDataList);
//                out.print(typeProductList.size()); 
            } else if (tab.equals("logOut")) {
                session.removeAttribute("user");
                session.removeAttribute("role");
                session.removeAttribute("AmountOfProductType");
                session.removeAttribute("checkBuyProduct");
            }

            session.setAttribute("tab", "allProduct");

            request.getRequestDispatcher("/view/homepage.jsp").forward(request, response);
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
