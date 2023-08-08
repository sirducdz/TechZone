package Controller.View;

import Dal.AccountDao;
import Dal.CartDAO;
import Model.Cart;
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
public class CartController extends HttpServlet {

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
            String tab = request.getParameter("tab");
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            AccountDao accountDao = new AccountDao();
//            User user = accountDao.GetUserByEmail("ducnvhe160331@fpt.edu.vn");
//            session.setAttribute("user", user);
//            tab = "cartList";// nhap
            if (tab.equals("cartList") && user != null) { // là thành viên m?i du?c quy?n vào gi? hàng ** thi?u di?u ki?n
                // tao them 1 bien de phan biet khi ma no gui ve day la qua ajax
                CartDAO cartDAO = new CartDAO();
                ArrayList<Cart> cartList;
                if (request.getParameter("DeleteProduct") != null) {
//                    out.print("haha");
                    cartDAO.DeleteCartByID(request.getParameter("cartID"));

                } else if (request.getParameter("buyProductsSubmit") != null) {
                    DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                    decimalFormat.applyPattern("#,###");
                    ArrayList<Cart> data = new ArrayList<>();
                    String cartIDArray[] = request.getParameterValues("cartCheckBox");
                    if (cartIDArray != null) {
                        float totalPrice = 0;
                        for (String string : cartIDArray) {
                            Cart cart = cartDAO.getCartbyCartID(string);
                            totalPrice += Float.parseFloat(cart.getTotalcost().replace(".", ""));
                            data.add(cart);
                        }
                        session.setAttribute("totalPrice", totalPrice);
                        request.setAttribute("totalPrice", decimalFormat.format(totalPrice).replace(",", "."));
                        session.setAttribute("data", data);
                        request.getRequestDispatcher("checkout.jsp").forward(request, response);
                    } else {
                        cartList = cartDAO.GetCartListByUserId(user.getUserID());
                        request.setAttribute("message", "Bạn cần chọn sản phẩm để thanh toán!");
                        request.setAttribute("cartList", cartList);
                        request.getRequestDispatcher("listCart.jsp").forward(request, response);
                    }
                    return;
                } else if (request.getParameter("updatequantity") != null || request.getParameter("cartCheckBox") != null) {
                    float totalAmount = 0;
                    String cartIDArray[];
                    String cartIDString = request.getParameter("cartIDArray");
                    if (request.getParameter("updatequantity") != null) {

                        String quantity = request.getParameter("quantity");
                        String cartID = request.getParameter("cartID");
                        Cart cart = new Cart(cartID, quantity, user.getUserID()); //??
                        cartDAO.updateQuantity(quantity, cartID, user.getUserID());//??
//                        out.print("cartidArray: "+request.getParameter("cartIDArray")); 
//                        return;
                    }
                    cartIDArray = request.getParameter("cartIDArray").split(",");

                    for (String string : cartIDArray) {
                        totalAmount += cartDAO.getTotalCostbyCartID(string);
                    }
                    DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                    decimalFormat.applyPattern("#,###");
                    cartList = cartDAO.GetCartListByUserId(user.getUserID());
//                    String totalAmount = cartDAO.getTotalCostbyUserID("10");
                    out.print("<div class=\"container\">\n"
                            + "                        <article class=\"row cart__head pc\">\n"
                            + "                            <nav class=\"menu__nav col-lg-3 col-md-12 col-sm-0\">\n"
                            + "                                <ul class=\"menu__list\">\n"
                            + "                                    <li class=\"menu__item menu__item--active\">\n"
                            + "                                        <a href=\"headphone.jsp\" class=\"menu__link\">\n"
                            + "                                            <img src=\"images1/item/headphone.jpg\" alt=\"\"  class=\"menu__item-icon\" id=\"Capa_1\" enable-background=\"new 0 0 512 512\" height=\"512\" viewBox=\"0 0 512 512\" width=\"512\">\n"
                            + "                                            Tai nghe</a>\n"
                            + "                                    </li>\n"
                            + "                                    <li class=\"menu__item\">\n"
                            + "                                        <a href=\"mouse.jsp\" class=\"menu__link\">\n"
                            + "                                            <img src=\"images1/item/mouse.jpg\" alt=\"\" class=\"menu__item-icon\" id=\"Capa_1\" enable-background=\"new 0 0 512 512\" height=\"512\" viewBox=\"0 0 512 512\" width=\"512\">\n"
                            + "                                            Chuột</a>\n"
                            + "                                    </li>\n"
                            + "\n"
                            + "                                    <li class=\"menu__item\">\n"
                            + "                                        <a href=\"keyboard.jsp\" class=\"menu__link\">\n"
                            + "                                            <img src=\"images1/item/keyboard.jpg\" alt=\"\" class=\"menu__item-icon\"  viewBox=\"0 0 512 512\" width=\"1012\" height=\"512\">\n"
                            + "                                            Bàn phím</a>\n"
                            + "                                    </li>\n"
                            + "                                </ul>\n"
                            + "                            </nav>\n"
                            + "                            <div class=\"col-6 cart__head-name\">\n"
                            + "                                Thông tin sản phẩm\n"
                            + "                            </div>\n"
                            + "                            <div class=\"col-3 cart__head-quantity\">\n"
                            + "                                Số lượng\n"
                            + "                            </div>\n"
                            + "                            <div class=\"col-3 cart__head-price\">\n"
                            + "                                Đơn giá\n"
                            + "                            </div>\n"
                            + "                        </article>");
                    for (Cart item : cartList) {
                        out.print("<article  class=\"row cart__body\">\n"
                                + "                            <div class=\"col-6 cart__body-name\">\n"
                                + "<input type=\"checkbox\" " + (cartIDString.contains(item.getCartID()) ? "checked" : "") + " name=\"cartCheckBox\" value=\"" + item.getCartID() + "\"  onclick=\"cartCheckBoxFunc('cartCheckBox')\">\n"
                                + "                                <div class=\"cart__body-name-img\">\n"
                                + "                                    <img src=\"" + item.getPicture() + "\">\n"
                                + "                                </div>\n"
                                + "                                <a href=\"\" class=\"cart__body-name-title\">\n"
                                + "                                    " + item.getProductName() + "\n"
                                + "                                </a>\n"
                                + "                            </div>\n"
                                + "\n"
                                + "                            <div class=\"col-3 cart__body-quantity\">\n"
                                + "                                <input type=\"button\" value=\"-\" class=\"cart__body-quantity-minus\" onclick=\"decreaseQuantity('" + item.getCartID() + "');UpdateContent('" + item.getCartID() + "','cartCheckBox');\">\n"
                                + "                                <input type=\"number\" readonly=\"\" name=\"quantityValue\" step=\"1\" min=\"1\" max=\"999\" value=\"" + item.getQuantity() + "\" class=\"cart__body-quantity-total\" id=\"" + item.getCartID() + "\">\n"
                                + "                                <input type=\"button\" value=\"+\" class=\"cart__body-quantity-plus\" onclick=\"increaseQuantity('" + item.getCartID() + "','" + item.getProduct_Quantity() + "');UpdateContent('" + item.getCartID() + "','cartCheckBox');\">\n"
                                + "                            </div>\n"
                                + "\n"
                                + "                            <div class=\"col-3 cart__body-price\">\n"
                                + "                                <span>" + item.getTotalcost() + "đ</span>\n"
                                + "\n"
                                + "                                <a href=\"CartController?tab=cartList&DeleteProduct&cartID=" + item.getCartID() + "\">Xóa</a>\n"
                                + "                            </div>\n"
                                + "                        </article>");
                    }
                    out.print("<article class=\"row cart__foot\">\n"
                            + "                        <div class=\"col-6 col-lg-6 col-sm-6 cart__foot-update\">\n"
                            + "                            <!--<button class=\"cart__foot-update-btn\">Cập nhật giỏ hàng</button>-->\n"
                            + "                        </div>\n"
                            + "\n"
                            + "                        <p class=\"col-3 col-lg-3 col-sm-3 cart__foot-total\">\n"
                            + "                            Tổng cộng: \n"
                            + "                        </p>\n"
                            + "\n"
                            + "                        <span class=\"col-3 col-lg-3 col-sm-3 cart__foot-price\">\n"
                            + "                            " + decimalFormat.format(totalAmount) + "đ <br>\n"
                            + "\n"
                            + "                            <button class=\"cart__foot-price-btn\" name=\"buyProductsSubmit\">Mua hàng</button>\n"
                            + "                        </span>\n"
                            + "                    </article>\n"
                            + "                </div>");

//                    out.print("cartid: " + request.getParameter("cartID") + "<br>");
//                    out.print("quantity: " + request.getParameter("quantity") + "<br>");
//                    out.print("updatequantity: " + request.getParameter("updatequantity") + "<br>");
                    return;
                }
//                ArrayList<Cart> cartList =  cartDAO.GetCartListByUserId(user.getUserID());
                cartList = cartDAO.GetCartListByUserId(user.getUserID());
                request.setAttribute("cartList", cartList);
//                request.setAttribute("totalAmount",cartDAO.getTotalCostbyUserID(user.getUserID())); 
//                request.setAttribute("totalAmount", cartDAO.getTotalCostbyUserID("10"));
                session.setAttribute("AmountOfProductType", cartDAO.AmountOfProductTypeByUserID(user.getUserID()));
                request.getRequestDispatcher("listCart.jsp").forward(request, response);
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
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            out.print("cartid: " + request.getParameter("cartID") + "<br>");
//            out.print("quantity: " + request.getParameter("quantity") + "<br>");
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
