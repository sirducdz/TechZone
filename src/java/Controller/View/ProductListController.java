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
import java.util.ArrayList;

/**
 *
 * @author DucPhaoLo
 */
public class ProductListController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String tab = request.getParameter("tab");
            if (tab == null) {
                tab = "allProduct";
            }
            HttpSession session = request.getSession();
            ProductDAO pdao = new ProductDAO();
            if (tab.equals("headphone") || tab.equals("allProduct")) {
                if (tab.equals("headphone")) {
                    session.setAttribute("tab", "headphone");
//                    request.setAttribute("tab", "headphone");
                } else {
                    session.setAttribute("tab", "allProduct");
//                    request.setAttribute("tab", "allProduct");
                }
                int headPhonepageIndex = 1;
                if (request.getParameter("headPhonepageIndex") != null
                        || request.getParameter("mousesortOrder") != null
                        || request.getParameter("mousepageIndex") != null
                        || request.getParameter("keyboardpageIndex") != null
                        || request.getParameter("keyboardsortOrder") != null) {// click phan trang
                    if (request.getParameter("headPhonepageIndex") != null) {
                        headPhonepageIndex = Integer.parseInt(request.getParameter("headPhonepageIndex"));
                    } else {
                        headPhonepageIndex = (int) session.getAttribute("headPhonepageIndex");
                    }

                } else {// làn dau = null, các l?n click vao nut khac
                    ArrayList<Products> headPhoneData;
                    String searchInput = "";
                    String headPhonesortOrder = null;
                    String searchSubmit = request.getParameter("searchSubmit");
                    if (searchSubmit != null) {// click search
                        searchInput = request.getParameter("searchInput").trim();
                        headPhonesortOrder = (String) session.getAttribute("headPhonesortOrder");
//                        out.print("e"); 
                        if (headPhonesortOrder == null) {
                            headPhoneData = pdao.getProductListByCategoryIDAndNameAndSort("1", searchInput, "rate");
                        } else {
                            headPhoneData = pdao.getProductListByCategoryIDAndNameAndSort("1", searchInput, headPhonesortOrder);
                        }
//                        return; 
                    } else {//  click sortOrder //searchSubmit == null
                        headPhonesortOrder = request.getParameter("headPhonesortOrder");
                        if (headPhonesortOrder != null) {
                            searchInput = (String) session.getAttribute("searchInput");
                            headPhoneData = pdao.getProductListByCategoryIDAndNameAndSort("1", searchInput, headPhonesortOrder);
                        } else {// first time called sortorder= rate(default)
                            headPhoneData = pdao.getProductListByCategoryIDAndNameAndSort("1", searchInput, "rate");
                        }
                    }
                    session.setAttribute("headPhonesortOrder", headPhonesortOrder);
                    session.setAttribute("searchInput", searchInput);
                    session.setAttribute("headPhoneData", headPhoneData);
                    int headPhoneamountElementInPage;
                    if (request.getParameter("headPhoneamountElementInPage") != null) {
                        headPhoneamountElementInPage = Integer.parseInt(request.getParameter("headPhoneamountElementInPage"));
                    } else {
                        if (session.getAttribute("headPhoneamountElementInPage") == null) {
                            headPhoneamountElementInPage = 6;
                        } else {
                            headPhoneamountElementInPage = (int) session.getAttribute("headPhoneamountElementInPage");
                        }
                    }
                    session.setAttribute("headPhoneamountElementInPage", headPhoneamountElementInPage);
                    int headPhonepageAmount = headPhoneData.size() / headPhoneamountElementInPage;
                    if (headPhoneData.size() % headPhoneamountElementInPage != 0) {
                        ++headPhonepageAmount;
                    }
                    session.setAttribute("headPhonepageAmount", headPhonepageAmount);

                }
                session.setAttribute("headPhonepageIndex", headPhonepageIndex);
            }

            ///mouse
            if (tab.equals("mouse") || tab.equals("allProduct")) {
                if (tab.equals("mouse")) {
                    request.setAttribute("tab", "mouse");
//                    session.setAttribute("tab", "mouse");
                } else {
//                    session.setAttribute("tab", "allProduct");
                    request.setAttribute("tab", "allProduct");
                }
                int mousepageIndex = 1;
                if (request.getParameter("mousepageIndex") != null
                        || request.getParameter("headPhonesortOrder") != null
                        || request.getParameter("headPhonepageIndex") != null
                        || request.getParameter("keyboardpageIndex") != null
                        || request.getParameter("keyboardsortOrder") != null) {// click phan trang
                    if (request.getParameter("mousepageIndex") != null) {
                        mousepageIndex = Integer.parseInt(request.getParameter("mousepageIndex"));
                    } else {
                        mousepageIndex = (int) session.getAttribute("mousepageIndex");
                    }
                } else {
                    ArrayList<Products> mouseData;
                    String searchInput = "";
                    String mousesortOrder = null;
                    String searchSubmit = request.getParameter("searchSubmit");
                    if (searchSubmit != null) {// click search
                        searchInput = request.getParameter("searchInput").trim();
                        mousesortOrder = (String) session.getAttribute("mousesortOrder");
                        if (mousesortOrder == null) {
                            mouseData = pdao.getProductListByCategoryIDAndNameAndSort("3", searchInput, "rate");
                        } else {
                            mouseData = pdao.getProductListByCategoryIDAndNameAndSort("3", searchInput, mousesortOrder);
                        }
                    } else {//  click sortOrder //searchSubmit == null
                        mousesortOrder = request.getParameter("mousesortOrder");
                        if (mousesortOrder != null) {
                            searchInput = (String) session.getAttribute("searchInput");
                            mouseData = pdao.getProductListByCategoryIDAndNameAndSort("3", searchInput, mousesortOrder);
                        } else {// first time called sortorder= rate(default)
                            mouseData = pdao.getProductListByCategoryIDAndNameAndSort("3", searchInput, "rate");
                        }
                    }
                    session.setAttribute("mousesortOrder", mousesortOrder);
                    session.setAttribute("searchInput", searchInput);
                    session.setAttribute("mouseData", mouseData);
                    int mouseamountElementInPage;
                    if (request.getParameter("mouseamountElementInPage") != null) {
                        mouseamountElementInPage = Integer.parseInt(request.getParameter("mouseamountElementInPage"));
                    } else {
                        if (session.getAttribute("mouseamountElementInPage") == null) {
                            mouseamountElementInPage = 6;
                        } else {
                            mouseamountElementInPage = (int) session.getAttribute("mouseamountElementInPage");
                        }
                    }
                    session.setAttribute("mouseamountElementInPage", mouseamountElementInPage);
                    int mousepageAmount = mouseData.size() / mouseamountElementInPage;
                    if (mouseData.size() % mouseamountElementInPage != 0) {
                        ++mousepageAmount;
                    }
                    session.setAttribute("mousepageAmount", mousepageAmount);

                }
                session.setAttribute("mousepageIndex", mousepageIndex);
            }

            //keyboard
            if (tab.equals("keyboard") || tab.equals("allProduct")) {
                if (tab.equals("keyboard")) {
                    request.setAttribute("tab", "keyboard");
//                    session.setAttribute("tab", "keyboard");
                } else {
//                    session.setAttribute("tab", "allProduct");
                    request.setAttribute("tab", "allProduct");
                }
                int keyboardpageIndex = 1;
                if (request.getParameter("keyboardpageIndex") != null
                        || request.getParameter("headPhonesortOrder") != null
                        || request.getParameter("headPhonepageIndex") != null
                        || request.getParameter("mousesortOrder") != null
                        || request.getParameter("mousepageIndex") != null) {// click phan trang
                    if (request.getParameter("keyboardpageIndex") != null) {
                        keyboardpageIndex = Integer.parseInt(request.getParameter("keyboardpageIndex"));
                    } else {
                        keyboardpageIndex = (int) session.getAttribute("keyboardpageIndex");
                    }
                } else {
                    ArrayList<Products> keyboardData;
                    String searchInput = "";
                    String keyboardsortOrder = null;
                    String searchSubmit = request.getParameter("searchSubmit");
                    if (searchSubmit != null) {// click search
                        searchInput = request.getParameter("searchInput").trim();
                        keyboardsortOrder = (String) session.getAttribute("keyboardsortOrder");
                        if (keyboardsortOrder == null) {
                            keyboardData = pdao.getProductListByCategoryIDAndNameAndSort("2", searchInput, "rate");
                        } else {
                            keyboardData = pdao.getProductListByCategoryIDAndNameAndSort("2", searchInput, keyboardsortOrder);
                        }
                    } else {//  click sortOrder //searchSubmit == null
                        keyboardsortOrder = request.getParameter("keyboardsortOrder");
                        if (keyboardsortOrder != null) {
                            searchInput = (String) session.getAttribute("searchInput");
                            keyboardData = pdao.getProductListByCategoryIDAndNameAndSort("2", searchInput, keyboardsortOrder);
                        } else {// first time called sortorder= rate(default)
                            keyboardData = pdao.getProductListByCategoryIDAndNameAndSort("2", searchInput, "rate");
                        }
                    }
                    session.setAttribute("keyboardsortOrder", keyboardsortOrder);
                    session.setAttribute("searchInput", searchInput);
                    session.setAttribute("keyboardData", keyboardData);
                    int keyboardamountElementInPage;
                    if (request.getParameter("keyboardamountElementInPage") != null) {
                        keyboardamountElementInPage = Integer.parseInt(request.getParameter("keyboardamountElementInPage"));
                    } else {
                        if (session.getAttribute("keyboardamountElementInPage") == null) {
                            keyboardamountElementInPage = 6;
                        } else {
                            keyboardamountElementInPage = (int) session.getAttribute("keyboardamountElementInPage");
                        }
                    }
                    session.setAttribute("keyboardamountElementInPage", keyboardamountElementInPage);
                    int keyboardpageAmount = keyboardData.size() / keyboardamountElementInPage;
                    if (keyboardData.size() % keyboardamountElementInPage != 0) {
                        ++keyboardpageAmount;
                    }
                    session.setAttribute("keyboardpageAmount", keyboardpageAmount);
                }
                session.setAttribute("keyboardpageIndex", keyboardpageIndex);
            }
            if (request.getParameter("checkResponse") != null) {
                return;
            }
            request.getRequestDispatcher("/view/listProduct.jsp").forward(request, response);
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
        if (request.getParameter("headPhonesortOrder") != null || request.getParameter("keyboardsortOrder") != null || request.getParameter("mousesortOrder") != null || request.getParameter("searchInput") != null) {
            processRequest(request, response);
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            out.print(request.getParameter("tab")+"<br>"); 
//            out.print(request.getParameter("headPhonepageIndex")); 
            HttpSession session = request.getSession();
            String tab = (String) session.getAttribute("tab");
            if (request.getParameter("headPhonepageIndex") != null) {
                String headPhonesortOrder = (String) session.getAttribute("headPhonesortOrder");
                int headPhoneamountElementInPage = (int) session.getAttribute("headPhoneamountElementInPage");
                int headPhonepageAmount = (int) session.getAttribute("headPhonepageAmount");
                int headPhonepageIndex = Integer.parseInt(request.getParameter("headPhonepageIndex"));
                ArrayList<Products> headPhoneData = (ArrayList<Products>) session.getAttribute("headPhoneData");
                String category1 = "category1";
                out.print("                    <div class=\"container\">\n"
                        + "                        <div class=\"row bg-white\">\n"
                        + "                            <div class=\"col-lg-10 col-md-10 col-sm-10 product__love-title\">\n"
                        + "                                <h2 class=\"product__love-heading upper\">\n"
                        + "                                    Tai Nghe  \n"
                        + "                                </h2>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"col-lg-2 col-md-2 col-sm-2 product__love-title\">\n"
                        + "                                <div class=\"show-entries\">");
                if ((headPhonesortOrder == null) || headPhonesortOrder.equals("rate")) {
                    out.print("<select name=\"headPhonesortOrder\" style=\"font-size: 15px;\"  onchange=\"changeHeadPhone()\">\n"
                            + "                                            <option value=\"rate\" selected>Bán chạy nhất</option>\n"
                            + "                                            <option value=\"descendingSalePrice\">Giá giảm dần</option>\n"
                            + "                                            <option value=\"ascendingSalePrice\">Giá tăng dần</option>\n"
                            + "                                            <option value=\"rate\">Đánh Giá Cao Nhất</option>\n"
                            + "                                        </select>");
                } else if (headPhonesortOrder.equals("descendingSalePrice")) {
                    out.print("<select name=\"headPhonesortOrder\" style=\"font-size: 15px;\"  onchange=\"changeHeadPhone()\">\n"
                            + "                                            <option value=\"rate\">Bán chạy nhất</option>\n"
                            + "                                            <option value=\"descendingSalePrice\" selected>Giá giảm dần</option>\n"
                            + "                                            <option value=\"ascendingSalePrice\">Giá tăng dần</option>\n"
                            + "                                            <option value=\"rate\">Đánh Giá Cao Nhất</option>\n"
                            + "                                        </select>");
                } else if (headPhonesortOrder.equals("ascendingSalePrice")) {
                    out.print("<select style=\"font-size: 15px;\" name=\"headPhonesortOrder\" onchange=\"changeHeadPhone()\">\n"
                            + "                                            <option value=\"rate\">Bán chạy nhất</option>\n"
                            + "                                            <option value=\"descendingSalePrice\">Giá giảm dần</option>\n"
                            + "                                            <option value=\"ascendingSalePrice\" selected>Giá tăng dần</option>\n"
                            + "                                            <option value=\"rate\">Đánh Giá Cao Nhất</option>\n"
                            + "                                        </select>");
                }
                out.print("</div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"col-lg-12 col-md-12 col-sm-12 product__love-title\">\n"
                        + "                                <div class=\"show-entries\">\n"
                        + "                                    <label class=\"hint-text\" style=\"margin-right: 3px;\">Hiển thị </label>");
                if (headPhoneamountElementInPage == 6) {
                    out.print("<select class=\"form-control\" style=\"font-size: 15px;\" name=\"headPhoneamountElementInPage\">\n"
                            + "                                            <option value=\"6\" selected>6</option>\n"
                            + "                                            <option value=\"12\">12</option>\n"
                            + "                                            <option value=\"18\">18</option>\n"
                            + "                                            <option value=\"24\">24</option>\n"
                            + "                                        </select>");
                } else if (headPhoneamountElementInPage == 12) {
                    out.print("<select class=\"form-control\" style=\"font-size: 15px;\" name=\"headPhoneamountElementInPage\">\n"
                            + "                                            <option value=\"6\" >6</option>\n"
                            + "                                            <option value=\"12\" selected>12</option>\n"
                            + "                                            <option value=\"18\">18</option>\n"
                            + "                                            <option value=\"24\">24</option>\n"
                            + "                                        </select>");
                } else if (headPhoneamountElementInPage == 18) {
                    out.print("<select class=\"form-control\" style=\"font-size: 15px;\" name=\"headPhoneamountElementInPage\">\n"
                            + "                                            <option value=\"6\" selected>6</option>\n"
                            + "                                            <option value=\"12\">12</option>\n"
                            + "                                            <option value=\"18\" selected>18</option>\n"
                            + "                                            <option value=\"24\">24</option>\n"
                            + "                                        </select>");
                } else if (headPhoneamountElementInPage == 24) {
                    out.print("<select class=\"form-control\" style=\"font-size: 15px;\" name=\"headPhoneamountElementInPage\">\n"
                            + "                                            <option value=\"6\" selected>6</option>\n"
                            + "                                            <option value=\"12\">12</option>\n"
                            + "                                            <option value=\"18\">18</option>\n"
                            + "                                            <option value=\"24\" selected>24</option>\n"
                            + "                                        </select>");
                }
                out.print("\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"row bg-white\">");
                int countDisplayElement = 0;
                if (headPhonepageAmount > 0) {
                    int i = (headPhonepageIndex - 1) * headPhoneamountElementInPage;
                    int end = headPhonepageIndex * headPhoneamountElementInPage - 1;

                    for (int j = i; j <= end; ++j) {
                        if (i < headPhoneData.size()) {
                            countDisplayElement++;
                            out.print("<div class=\"product__panel-item col-lg-2 col-md-3 col-sm-6\">\n"
                                    + "                                                <div class=\"product__panel-img-wrap\">\n"
                                    + "                                                    <a href=\"ProductDetailController?ProductID=" + headPhoneData.get(i).getProductID() + "\"> <img src=\"" + headPhoneData.get(i).getPicture() + "\" class=\"product__panel-img\"></a>\n"
                                    + "                                            </div>\n"
                                    + "                                            <h3 class=\"product__panel-heading\">\n"
                                    + "                                                <a href=\"ProductDetailController?ProductID=" + headPhoneData.get(i).getProductID() + "\"  class=\"product__panel-link\">" + headPhoneData.get(i).getName() + "</a>\n"
                                    + "                                            </h3>                       \n"
                                    + "                                            <div class=\"product__panel-rate-wrap\">\n"
                                    + "                                                <i class=\"product__panel-rate\" style=\"text-decoration: underline;font-size: 20px; margin-right: 5px\">" + headPhoneData.get(i).getRateStar() + "</i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                            </div>\n"
                                    + "                                            <div class=\"product__panel-price\">\n"
                                    + "                                                <span class=\"product__panel-price-old-1 product__panel-price-old-1-hide\">\n"
                                    + "                                                    <div>    \n"
                                    + "                                                        <a href=\"CompareProductController?productID=" + headPhoneData.get(i).getProductID() + "\" class=\"bestselling__product-btn\">So sánh</a>\n"
                                    + "                                                    </div>\n"
                                    + "                                                </span>\n"
                                    + "                                                <span class=\"product__panel-price-current\">\n"
                                    + "                                                    <button href=\"compareProduct.jsp\" class=\"bestselling__product-btn\">" + headPhoneData.get(i).getSalePrice() + "đ</button>\n"
                                    + "                                                </span>\n"
                                    + "                                            </div>");
                            if (Double.parseDouble(headPhoneData.get(i).getSale()) > 0) {
                                out.print("<div class=\"product__panel-price-sale-off\">\n"
                                        + "                                                    -" + headPhoneData.get(i).getSale() + "%\n"
                                        + "                                                </div>");
                            }
                            out.print("</div>");
                        }
                        i++;
                    }
                }
                out.print("</div>\n"
                        + "                        <div class=\"clearfix\">");
                if (headPhonepageAmount > 0) {
                    out.print("<div class=\"hint-text\" style=\"font-size: 15px;\">Hiển thị " + countDisplayElement + " trong số " + headPhoneData.size() + " sản phẩm</div>\n"
                            + "                                <ul class=\"pagination\">");
                    int count = 1;
                    if (headPhonepageIndex != 1) {
                        out.print("<li class=\"page-item disabled\"><a onclick=\"Paging('" + (headPhonepageIndex - 1) + "','" + category1 + "')\" id=\"" + (headPhonepageIndex - 1) + "\" href=\"ProductListController?tab=" + tab + "&headPhonepageIndex=" + (headPhonepageIndex - 1) + "\">Previous</a></li>");
                    }
                    for (count = 1; count <= headPhonepageAmount; ++count) {
                        if (headPhonepageIndex == count) {
                            out.print("<li class=\"page-item active\"><a onclick=\"Paging('" + count + "','" + category1 + "')\"  id=\"" + count + "\" href=\"ProductListController?tab=" + tab + "&headPhonepageIndex=" + count + "\" class=\"page-link\">" + count + "</a></li>");
                        } else {
                            out.print("<li class=\"page-item \"><a onclick=\"Paging('" + count + "','" + category1 + "')\"  id=\"" + count + "\" href=\"ProductListController?tab=" + tab + "&headPhonepageIndex=" + count + "\" class=\"page-link\">" + count + "</a></li>");
                        }
                    }
                    if (headPhonepageIndex != headPhonepageAmount) {
                        out.print("<li class=\"page-item disabled\"><a onclick=\"Paging('" + (headPhonepageIndex + 1) + "','" + category1 + "')\"  id=\"" + (headPhonepageIndex + 1) + "\" href=\"ProductListController?tab=" + tab + "&headPhonepageIndex=" + (headPhonepageIndex + 1) + "\">Next</a></li>");
                    }
                    out.print("</ul>");
                }
                out.print("</div>\n");

            }//mouse 
            else if (request.getParameter("mousepageIndex") != null) {
                String mousesortOrder = (String) session.getAttribute("mousesortOrder");
                int mouseamountElementInPage = (int) session.getAttribute("mouseamountElementInPage");
                int mousepageAmount = (int) session.getAttribute("mousepageAmount");
                int mousepageIndex = Integer.parseInt(request.getParameter("mousepageIndex"));
                ArrayList<Products> mouseData = (ArrayList<Products>) session.getAttribute("mouseData");
                String category2 = "category2";
                out.print("                    <div class=\"container\">\n"
                        + "                        <div class=\"row bg-white\">\n"
                        + "                            <div class=\"col-lg-10 col-md-10 col-sm-10 product__love-title\">\n"
                        + "                                <h2 class=\"product__love-heading upper\">\n"
                        + "                                    Chuột  \n"
                        + "                                </h2>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"col-lg-2 col-md-2 col-sm-2 product__love-title\">\n"
                        + "                                <div class=\"show-entries\">");
                if ((mousesortOrder == null) || mousesortOrder.equals("rate")) {
                    out.print("<select name=\"mousesortOrder\" style=\"font-size: 15px;\"  onchange=\"changeMouse()\">\n"
                            + "                                            <option value=\"rate\" selected>Bán chạy nhất</option>\n"
                            + "                                            <option value=\"descendingSalePrice\">Giá giảm dần</option>\n"
                            + "                                            <option value=\"ascendingSalePrice\">Giá tăng dần</option>\n"
                            + "                                            <option value=\"rate\">Đánh Giá Cao Nhất</option>\n"
                            + "                                        </select>");
                } else if (mousesortOrder.equals("descendingSalePrice")) {
                    out.print("<select name=\"mousesortOrder\" style=\"font-size: 15px;\"  onchange=\"changeMouse()\">\n"
                            + "                                            <option value=\"rate\">Bán chạy nhất</option>\n"
                            + "                                            <option value=\"descendingSalePrice\" selected>Giá giảm dần</option>\n"
                            + "                                            <option value=\"ascendingSalePrice\">Giá tăng dần</option>\n"
                            + "                                            <option value=\"rate\">Đánh Giá Cao Nhất</option>\n"
                            + "                                        </select>");
                } else if (mousesortOrder.equals("ascendingSalePrice")) {
                    out.print("<select style=\"font-size: 15px;\" name=\"mousesortOrder\" onchange=\"changeMouse()\">\n"
                            + "                                            <option value=\"rate\">Bán chạy nhất</option>\n"
                            + "                                            <option value=\"descendingSalePrice\">Giá giảm dần</option>\n"
                            + "                                            <option value=\"ascendingSalePrice\" selected>Giá tăng dần</option>\n"
                            + "                                            <option value=\"rate\">Đánh Giá Cao Nhất</option>\n"
                            + "                                        </select>");
                }
                out.print("</div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"col-lg-12 col-md-12 col-sm-12 product__love-title\">\n"
                        + "                                <div class=\"show-entries\">\n"
                        + "                                    <label class=\"hint-text\" style=\"margin-right: 3px;\">Hiển thị </label>");
                if (mouseamountElementInPage == 6) {
                    out.print("<select class=\"form-control\" style=\"font-size: 15px;\" name=\"mouseamountElementInPage\">\n"
                            + "                                            <option value=\"6\" selected>6</option>\n"
                            + "                                            <option value=\"12\">12</option>\n"
                            + "                                            <option value=\"18\">18</option>\n"
                            + "                                            <option value=\"24\">24</option>\n"
                            + "                                        </select>");
                } else if (mouseamountElementInPage == 12) {
                    out.print("<select class=\"form-control\" style=\"font-size: 15px;\" name=\"mouseamountElementInPage\">\n"
                            + "                                            <option value=\"6\" >6</option>\n"
                            + "                                            <option value=\"12\" selected>12</option>\n"
                            + "                                            <option value=\"18\">18</option>\n"
                            + "                                            <option value=\"24\">24</option>\n"
                            + "                                        </select>");
                } else if (mouseamountElementInPage == 18) {
                    out.print("<select class=\"form-control\" style=\"font-size: 15px;\" name=\"mouseamountElementInPage\">\n"
                            + "                                            <option value=\"6\" selected>6</option>\n"
                            + "                                            <option value=\"12\">12</option>\n"
                            + "                                            <option value=\"18\" selected>18</option>\n"
                            + "                                            <option value=\"24\">24</option>\n"
                            + "                                        </select>");
                } else if (mouseamountElementInPage == 24) {
                    out.print("<select class=\"form-control\" style=\"font-size: 15px;\" name=\"mouseamountElementInPage\">\n"
                            + "                                            <option value=\"6\" selected>6</option>\n"
                            + "                                            <option value=\"12\">12</option>\n"
                            + "                                            <option value=\"18\">18</option>\n"
                            + "                                            <option value=\"24\" selected>24</option>\n"
                            + "                                        </select>");
                }
                out.print("\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"row bg-white\">");
                int countDisplayElement = 0;
                if (mousepageAmount > 0) {
                    int i = (mousepageIndex - 1) * mouseamountElementInPage;
                    int end = mousepageIndex * mouseamountElementInPage - 1;

                    for (int j = i; j <= end; ++j) {
                        if (i < mouseData.size()) {
                            countDisplayElement++;
                            out.print("<div class=\"product__panel-item col-lg-2 col-md-3 col-sm-6\">\n"
                                    + "                                                <div class=\"product__panel-img-wrap\">\n"
                                    + "                                                    <a href=\"ProductDetailController?ProductID=" + mouseData.get(i).getProductID() + "\"> <img src=\"" + mouseData.get(i).getPicture() + "\" class=\"product__panel-img\"></a>\n"
                                    + "                                            </div>\n"
                                    + "                                            <h3 class=\"product__panel-heading\">\n"
                                    + "                                                <a href=\"ProductDetailController?ProductID=" + mouseData.get(i).getProductID() + "\"  class=\"product__panel-link\">" + mouseData.get(i).getName() + "</a>\n"
                                    + "                                            </h3>                       \n"
                                    + "                                            <div class=\"product__panel-rate-wrap\">\n"
                                    + "                                                <i class=\"product__panel-rate\" style=\"text-decoration: underline;font-size: 20px; margin-right: 5px\">" + mouseData.get(i).getRateStar() + "</i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                            </div>\n"
                                    + "                                            <div class=\"product__panel-price\">\n"
                                    + "                                                <span class=\"product__panel-price-old-1 product__panel-price-old-1-hide\">\n"
                                    + "                                                    <div>    \n"
                                    + "                                                        <button class=\"bestselling__product-btn\">So sánh</button>\n"
                                    + "                                                    </div>\n"
                                    + "                                                </span>\n"
                                    + "                                                <span class=\"product__panel-price-current\">\n"
                                    + "                                                    <button href=\"compareProduct.jsp\" class=\"bestselling__product-btn\">" + mouseData.get(i).getSalePrice() + "đ</button>\n"
                                    + "                                                </span>\n"
                                    + "                                            </div>");
                            if (Double.parseDouble(mouseData.get(i).getSale()) > 0) {
                                out.print("<div class=\"product__panel-price-sale-off\">\n"
                                        + "                                                    -" + mouseData.get(i).getSale() + "%\n"
                                        + "                                                </div>");
                            }
                            out.print("</div>");
                        }
                        i++;
                    }
                }
                out.print("</div>\n"
                        + "                        <div class=\"clearfix\">");
                if (mousepageAmount > 0) {
                    out.print("<div class=\"hint-text\" style=\"font-size: 15px;\">Hiển thị " + countDisplayElement + " trong số " + mouseData.size() + " sản phẩm</div>\n"
                            + "                                <ul class=\"pagination\">");
                    int count = 1;
                    if (mousepageIndex != 1) {
                        out.print("<li class=\"page-item disabled\"><a onclick=\"Paging('m" + (mousepageIndex - 1) + "','" + category2 + "')\" id=\"m" + (mousepageIndex - 1) + "\" href=\"ProductListController?tab=" + tab + "&mousepageIndex=" + (mousepageIndex - 1) + "\">Previous</a></li>");
                    }
                    for (count = 1; count <= mousepageAmount; ++count) {
                        if (mousepageIndex == count) {
                            out.print("<li class=\"page-item active\"><a onclick=\"Paging('m" + count + "','" + category2 + "')\"  id=\"m" + count + "\" href=\"ProductListController?tab=" + tab + "&mousepageIndex=" + count + "\" class=\"page-link\">" + count + "</a></li>");
                        } else {
                            out.print("<li class=\"page-item \"><a onclick=\"Paging('m" + count + "','" + category2 + "')\"  id=\"m" + count + "\" href=\"ProductListController?tab=" + tab + "&mousepageIndex=" + count + "\" class=\"page-link\">" + count + "</a></li>");
                        }
                    }
                    if (mousepageIndex != mousepageAmount) {
                        out.print("<li class=\"page-item disabled\"><a onclick=\"Paging('m" + (mousepageIndex + 1) + "','" + category2 + "')\"  id=\"m" + (mousepageIndex + 1) + "\" href=\"ProductListController?tab=" + tab + "&mousepageIndex=" + (mousepageIndex + 1) + "\">Next</a></li>");
                    }
                    out.print("</ul>");
                }
                out.print("</div>\n");

            } else // keyboard
            {
                String keyboardsortOrder = (String) session.getAttribute("keyboardsortOrder");
                int keyboardamountElementInPage = (int) session.getAttribute("keyboardamountElementInPage");
                int keyboardpageAmount = (int) session.getAttribute("keyboardpageAmount");
                int keyboardpageIndex = Integer.parseInt(request.getParameter("keyboardpageIndex"));
                ArrayList<Products> keyboardData = (ArrayList<Products>) session.getAttribute("keyboardData");
                String category3 = "category3";
                out.print("                    <div class=\"container\">\n"
                        + "                        <div class=\"row bg-white\">\n"
                        + "                            <div class=\"col-lg-10 col-md-10 col-sm-10 product__love-title\">\n"
                        + "                                <h2 class=\"product__love-heading upper\">\n"
                        + "                                    Chuột  \n"
                        + "                                </h2>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"col-lg-2 col-md-2 col-sm-2 product__love-title\">\n"
                        + "                                <div class=\"show-entries\">");
                if ((keyboardsortOrder == null) || keyboardsortOrder.equals("rate")) {
                    out.print("<select name=\"keyboardsortOrder\" style=\"font-size: 15px;\"  onchange=\"changeMouse()\">\n"
                            + "                                            <option value=\"rate\" selected>Bán chạy nhất</option>\n"
                            + "                                            <option value=\"descendingSalePrice\">Giá giảm dần</option>\n"
                            + "                                            <option value=\"ascendingSalePrice\">Giá tăng dần</option>\n"
                            + "                                            <option value=\"rate\">Đánh Giá Cao Nhất</option>\n"
                            + "                                        </select>");
                } else if (keyboardsortOrder.equals("descendingSalePrice")) {
                    out.print("<select name=\"keyboardsortOrder\" style=\"font-size: 15px;\"  onchange=\"changeMouse()\">\n"
                            + "                                            <option value=\"rate\">Bán chạy nhất</option>\n"
                            + "                                            <option value=\"descendingSalePrice\" selected>Giá giảm dần</option>\n"
                            + "                                            <option value=\"ascendingSalePrice\">Giá tăng dần</option>\n"
                            + "                                            <option value=\"rate\">Đánh Giá Cao Nhất</option>\n"
                            + "                                        </select>");
                } else if (keyboardsortOrder.equals("ascendingSalePrice")) {
                    out.print("<select style=\"font-size: 15px;\" name=\"keyboardsortOrder\" onchange=\"changeKeyboard()\">\n"
                            + "                                            <option value=\"rate\">Bán chạy nhất</option>\n"
                            + "                                            <option value=\"descendingSalePrice\">Giá giảm dần</option>\n"
                            + "                                            <option value=\"ascendingSalePrice\" selected>Giá tăng dần</option>\n"
                            + "                                            <option value=\"rate\">Đánh Giá Cao Nhất</option>\n"
                            + "                                        </select>");
                }
                out.print("</div>\n"
                        + "                            </div>\n"
                        + "                            <div class=\"col-lg-12 col-md-12 col-sm-12 product__love-title\">\n"
                        + "                                <div class=\"show-entries\">\n"
                        + "                                    <label class=\"hint-text\" style=\"margin-right: 3px;\">Hiển thị </label>");
                if (keyboardamountElementInPage == 6) {
                    out.print("<select class=\"form-control\" style=\"font-size: 15px;\" name=\"keyboardamountElementInPage\">\n"
                            + "                                            <option value=\"6\" selected>6</option>\n"
                            + "                                            <option value=\"12\">12</option>\n"
                            + "                                            <option value=\"18\">18</option>\n"
                            + "                                            <option value=\"24\">24</option>\n"
                            + "                                        </select>");
                } else if (keyboardamountElementInPage == 12) {
                    out.print("<select class=\"form-control\" style=\"font-size: 15px;\" name=\"keyboardamountElementInPage\">\n"
                            + "                                            <option value=\"6\" >6</option>\n"
                            + "                                            <option value=\"12\" selected>12</option>\n"
                            + "                                            <option value=\"18\">18</option>\n"
                            + "                                            <option value=\"24\">24</option>\n"
                            + "                                        </select>");
                } else if (keyboardamountElementInPage == 18) {
                    out.print("<select class=\"form-control\" style=\"font-size: 15px;\" name=\"keyboardamountElementInPage\">\n"
                            + "                                            <option value=\"6\" selected>6</option>\n"
                            + "                                            <option value=\"12\">12</option>\n"
                            + "                                            <option value=\"18\" selected>18</option>\n"
                            + "                                            <option value=\"24\">24</option>\n"
                            + "                                        </select>");
                } else if (keyboardamountElementInPage == 24) {
                    out.print("<select class=\"form-control\" style=\"font-size: 15px;\" name=\"keyboardamountElementInPage\">\n"
                            + "                                            <option value=\"6\" selected>6</option>\n"
                            + "                                            <option value=\"12\">12</option>\n"
                            + "                                            <option value=\"18\">18</option>\n"
                            + "                                            <option value=\"24\" selected>24</option>\n"
                            + "                                        </select>");
                }
                out.print("\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"row bg-white\">");
                int countDisplayElement = 0;
                if (keyboardpageAmount > 0) {
                    int i = (keyboardpageIndex - 1) * keyboardamountElementInPage;
                    int end = keyboardpageIndex * keyboardamountElementInPage - 1;

                    for (int j = i; j <= end; ++j) {
                        if (i < keyboardData.size()) {
                            countDisplayElement++;
                            out.print("<div class=\"product__panel-item col-lg-2 col-md-3 col-sm-6\">\n"
                                    + "                                                <div class=\"product__panel-img-wrap\">\n"
                                    + "                                                    <a href=\"ProductDetailController?ProductID=" + keyboardData.get(i).getProductID() + "\"> <img src=\"" + keyboardData.get(i).getPicture() + "\" class=\"product__panel-img\"></a>\n"
                                    + "                                            </div>\n"
                                    + "                                            <h3 class=\"product__panel-heading\">\n"
                                    + "                                                <a href=\"ProductDetailController?ProductID=" + keyboardData.get(i).getProductID() + "\"  class=\"product__panel-link\">" + keyboardData.get(i).getName() + "</a>\n"
                                    + "                                            </h3>                       \n"
                                    + "                                            <div class=\"product__panel-rate-wrap\">\n"
                                    + "                                                <i class=\"product__panel-rate\" style=\"text-decoration: underline;font-size: 20px; margin-right: 5px\">" + keyboardData.get(i).getRateStar() + "</i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                                <i class=\"fas fa-star product__panel-rate\"></i>\n"
                                    + "                                            </div>\n"
                                    + "                                            <div class=\"product__panel-price\">\n"
                                    + "                                                <span class=\"product__panel-price-old-1 product__panel-price-old-1-hide\">\n"
                                    + "                                                    <div>    \n"
                                    + "                                                        <button class=\"bestselling__product-btn\">So sánh</button>\n"
                                    + "                                                    </div>\n"
                                    + "                                                </span>\n"
                                    + "                                                <span class=\"product__panel-price-current\">\n"
                                    + "                                                    <button href=\"compareProduct.jsp\" class=\"bestselling__product-btn\">" + keyboardData.get(i).getSalePrice() + "đ</button>\n"
                                    + "                                                </span>\n"
                                    + "                                            </div>");
                            if (Double.parseDouble(keyboardData.get(i).getSale()) > 0) {
                                out.print("<div class=\"product__panel-price-sale-off\">\n"
                                        + "                                                    -" + keyboardData.get(i).getSale() + "%\n"
                                        + "                                                </div>");
                            }
                            out.print("</div>");
                        }
                        i++;
                    }
                }
                out.print("</div>\n"
                        + "                        <div class=\"clearfix\">");
                if (keyboardpageAmount > 0) {
                    out.print("<div class=\"hint-text\" style=\"font-size: 15px;\">Hiển thị " + countDisplayElement + " trong số " + keyboardData.size() + " sản phẩm</div>\n"
                            + "                                <ul class=\"pagination\">");
                    int count = 1;
                    if (keyboardpageIndex != 1) {
                        out.print("<li class=\"page-item disabled\"><a onclick=\"Paging('k" + (keyboardpageIndex - 1) + "','" + category3 + "')\" id=\"k" + (keyboardpageIndex - 1) + "\" href=\"ProductListController?tab=" + tab + "&keyboardpageIndex=" + (keyboardpageIndex - 1) + "\">Previous</a></li>");
                    }
                    for (count = 1; count <= keyboardpageAmount; ++count) {
                        if (keyboardpageIndex == count) {
                            out.print("<li class=\"page-item active\"><a onclick=\"Paging('k" + count + "','" + category3 + "')\"  id=\"k" + count + "\" href=\"ProductListController?tab=" + tab + "&keyboardpageIndex=" + count + "\" class=\"page-link\">" + count + "</a></li>");
                        } else {
                            out.print("<li class=\"page-item \"><a onclick=\"Paging('k" + count + "','" + category3 + "')\"  id=\"k" + count + "\" href=\"ProductListController?tab=" + tab + "&keyboardpageIndex=" + count + "\" class=\"page-link\">" + count + "</a></li>");
                        }
                    }
                    if (keyboardpageIndex != keyboardpageAmount) {
                        out.print("<li class=\"page-item disabled\"><a onclick=\"Paging('k" + (keyboardpageIndex + 1) + "','" + category3 + "')\"  id=\"k" + (keyboardpageIndex + 1) + "\" href=\"ProductListController?tab=" + tab + "&keyboardpageIndex=" + (keyboardpageIndex + 1) + "\">Next</a></li>");
                    }
                    out.print("</ul>");
                }
                out.print("</div>\n");

            }

        }
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
