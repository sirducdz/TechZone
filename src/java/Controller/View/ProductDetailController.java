package Controller.View;

import Dal.CartDAO;
import Dal.FeedbackDAO;
import Dal.ProductDAO;
import Model.Cart;
import Model.Feedback;
import Model.Products;
import Model.User;
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
public class ProductDetailController extends HttpServlet {

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
            FeedbackDAO feedbackDAO = new FeedbackDAO();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            ProductDAO pdao = new ProductDAO();
            if (request.getParameter("addToCart") != null) {
                if (user == null) {
                    response.sendRedirect(request.getContextPath() + "/auth/login");
                    return;
                }
//                out.print(request.getParameter("quantity"));
                Products productDetail = (Products) session.getAttribute("productDetail");
                String quantity = request.getParameter("quantity");
                Cart cart = new Cart(productDetail.getSalePrice(), quantity, productDetail.getProductID(), user.getUserID(), "1");//1 default 
                CartDAO cartDAO = new CartDAO();
                boolean checkAddToCart = cartDAO.AddOrUpdateCart(cart);
                request.setAttribute("checkAddToCart", checkAddToCart);
                ArrayList<Feedback> feedbackList = feedbackDAO.getFeedbackListByProductId(productDetail.getProductID(), "3", "0");;
                request.setAttribute("feedbackList", feedbackList);//??? mai lam tiep
//                request.getRequestDispatcher("productDetail.jsp").forward(request, response);
//                out.print("checkAddToCart: "+checkAddToCart); 
//                return;
            } else if (request.getParameter("submitComment") != null) {
                String commentContent = request.getParameter("comm_details");
                String productRate = request.getParameter("star");
                Products productDetail = (Products) session.getAttribute("productDetail");
                String orderdetailID = feedbackDAO.getLatestOrderdetailIDByProductIDAndUserId(productDetail.getProductID(), user.getUserID());
                Feedback f = new Feedback(productDetail.getProductID(), user.getUserID(), commentContent, productRate, orderdetailID);
                feedbackDAO.addFeedback(f);
                ArrayList<Feedback> feedbackList;
                feedbackList = feedbackDAO.getFeedbackListByProductId(productDetail.getProductID(), "3", "0");
                for (Feedback item : feedbackList) {
                    out.print("<div class=\"comment-item\">\n"
                            + "                                    <ul class = item-reviewer>\n"
                            + "                                        <div class=\"comment-item-user\">\n"
                            + "                                            <img src=\"images/img/1.png\" alt=\"\" class=\"comment-item-user-img\">\n"
                            + "                                            <!--<img src=\"images/img/2.png\" alt=\"\" class=\"comment-item-user-img\">-->\n"
                            + "                                            <li><b>" + item.getUsername() + "</b></li> \n"
                            + "                                        </div>\n"
                            + "                                        <div class=\"product__panel-rate-wrap\">\n"
                            + "                                            <i class=\"product__panel-rate\" style=\"text-decoration: underline;font-size: 20px; margin-right: 5px\">" + item.getProduct_rate() + "</i>");
                    for (int i = 1; i <= Integer.parseInt(item.getProduct_rate()); ++i) {
                        out.print("<i class=\"fas fa-star product__panel-rate\"></i>");
                    }
                    out.print("</div>\n"
                            + "                                        <br>\n"
                            + "                                        <li>" + item.getDate() + "</li>\n"
                            + "                                        <li>\n"
                            + "                                            <h4>" + item.getInformation() + "</h4>\n"
                            + "                                        </li>\n"
                            + "                                    </ul>\n"
                            + "                                </div>");
                }
                if (feedbackList.size() >= 3) {
                    out.print("<style>\n"
                            + "                                    .load-more-button {\n"
                            + "                                        background-color: #4CAF50; /* Màu nền */\n"
                            + "                                        color: white; /* Màu chữ */\n"
                            + "                                        padding: 10px 20px; /* Kích thước nút */\n"
                            + "                                        border: none; /* Loại bỏ đường viền */\n"
                            + "                                        border-radius: 4px; /* Bo góc nút */\n"
                            + "                                        cursor: pointer; /* Hiển thị con trỏ khi di chuột vào nút */\n"
                            + "                                        font-size: 16px; /* Kích thước chữ */\n"
                            + "                                        margin-left: 500px;\n"
                            + "                                    }\n"
                            + "                                    .load-more-button:hover {\n"
                            + "                                        background-color: #45a049; /* Màu nền khi di chuột vào nút */\n"
                            + "                                    }\n"
                            + "\n"
                            + "                                </style>\n"
                            + "                                <button class=\"load-more-button\" id=\"load-more-button\" onclick=\"LoadMoreFuction('comment-item', 'feedbackContent', 'load-more-button')\" >Load More</button>");
                }
                return;
            } else {
                String ProductID = request.getParameter("ProductID");
                Products productDetail = pdao.getProductByID(ProductID);
                ArrayList<Products> bottomDataList =pdao.GetRandomProduct(pdao.GetProductListByCategoryID(pdao.getCategoryIDByProductID(ProductID)), 6) ;
                session.setAttribute("bottomDataList",bottomDataList); 
//                System.out.println("bottomDataList.size(): "+bottomDataList.size());
                ArrayList<Feedback> feedbackList;
                if (request.getParameter("loadMore") != null) {
                    String offset = request.getParameter("amount");
                    feedbackList = feedbackDAO.getFeedbackListByProductId(ProductID, "3", offset);
                    for (Feedback item : feedbackList) {
                        out.print("<div class=\"comment-item\">\n"
                                + "                                    <ul class = item-reviewer>\n"
                                + "                                        <div class=\"comment-item-user\">\n"
                                + "                                            <img src=\"images/img/1.png\" alt=\"\" class=\"comment-item-user-img\">\n"
                                + "                                            <!--<img src=\"images/img/2.png\" alt=\"\" class=\"comment-item-user-img\">-->\n"
                                + "                                            <li><b>" + item.getUsername() + "</b></li> \n"
                                + "                                        </div>\n"
                                + "                                        <div class=\"product__panel-rate-wrap\">\n"
                                + "                                            <i class=\"product__panel-rate\" style=\"text-decoration: underline;font-size: 20px; margin-right: 5px\">" + item.getProduct_rate() + "</i>");
                        for (int i = 1; i <= Integer.parseInt(item.getProduct_rate()); ++i) {
                            out.print("<i class=\"fas fa-star product__panel-rate\"></i>");
                        }
                        out.print("</div>\n"
                                + "                                        <br>\n"
                                + "                                        <li>" + item.getDate() + "</li>\n"
                                + "                                        <li>\n"
                                + "                                            <h4>" + item.getInformation() + "</h4>\n"
                                + "                                        </li>\n"
                                + "                                    </ul>\n"
                                + "                                </div>");
                    }
                    if (feedbackList.size() != 0) {
                        out.print("<button class=\"load-more-button\" id=\"" + request.getParameter("amount") + "\" onclick=\"LoadMoreFuction('comment-item', 'feedbackContent','" + request.getParameter("amount") + "')\" >Load More</button>");
                    }
                    return;
                }
                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                decimalFormat.applyPattern("#,###");
                String salePrice = String.valueOf(decimalFormat.format(Float.parseFloat(productDetail.getSalePrice())));
                salePrice = salePrice.replaceAll(",", ".");
                session.setAttribute("salePrice", salePrice);
                feedbackList = feedbackDAO.getFeedbackListByProductId(ProductID, "3", "0");
                request.setAttribute("feedbackList", feedbackList);
                session.setAttribute("productDetail", productDetail);

            }
            if (user != null) {
                session.setAttribute("checkBuyProduct", feedbackDAO.checkBuyProductByUserID(user.getUserID(), request.getParameter("ProductID")));
                CartDAO cartDAO = new CartDAO();
                session.setAttribute("AmountOfProductType", cartDAO.AmountOfProductTypeByUserID(user.getUserID()));
            }
            request.getRequestDispatcher("productDetail.jsp").forward(request, response);
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
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            if (request.getParameter("Loadmore") != null) {
//                out.print("amount: " + request.getParameter("amount"));
//                out.print("Loadmore: " + request.getParameter("Loadmore"));
//                out.print("haha");
//                    return;
//            }
//        }

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
