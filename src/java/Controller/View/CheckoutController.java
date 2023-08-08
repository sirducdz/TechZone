package Controller.View;

import Dal.CartDAO;
import Dal.OrderDAO;
import Dal.OrderdetailDAO;
import Dal.ProductDAO;
import Dal.SaleCodeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import Impl.Config;
import Impl.SendMail;
import Model.Cart;
import Model.Order;
import Model.Orderdetail;
import Model.SaleCode;
import Model.User;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class CheckoutController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();

// **           if (request.getParameter("vnp_ResponseCode") != null&&request.getParameter("vnp_ResponseCode").equals("00")) {
            if (request.getParameter("btnDatHang") != null && request.getParameter("checkoutType").equals("cash")) {
//                System.out.println(request.getParameter("vnp_ResponseCode"));
                SaleCodeDAO saleCodeDAO = new SaleCodeDAO();
                User user = (User) session.getAttribute("user");
//**                String checkoutType = (String) session.getAttribute("checkoutType");
                String checkoutType = request.getParameter("checkoutType");//**
                SaleCode saleCode = saleCodeDAO.getSaleCodeByName((String) session.getAttribute("inputSalecode"));
// **               String vnp_PayDate =request.getParameter("vnp_PayDate");
                Timestamp datetime = new Timestamp(System.currentTimeMillis());
                String orderDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datetime);
                CartDAO cartDAO = new CartDAO();
//                String orderDate = "20230629112930";
                ProductDAO productDAO = new ProductDAO();
                ArrayList<Cart> cartData = (ArrayList<Cart>) session.getAttribute("data");
                session.setAttribute("cartData", cartData);
                Order order;
                OrderDAO orderDAO = new OrderDAO();
                if (saleCode != null) {
                    order = new Order(user.getUserID(), saleCode.getSalecodeID(), orderDate, "Pending");
                    saleCodeDAO.decreaseSaleCodeAmount(saleCode.getSalecodeID(), saleCode.getAmount());
                } else {
                    order = new Order(user.getUserID(), null, orderDate, "Pending");
                }
                orderDAO.addOrder(order);
                String orderID = orderDAO.getOrderAfterAddByUserID(user.getUserID()).getOrderID();
                OrderdetailDAO orderdetailDAO = new OrderdetailDAO();
                for (Cart cart : cartData) {
                    cartDAO.DeleteCartByID(cart.getCartID());
                    orderdetailDAO.addOrderDetail(new Orderdetail(orderID, cart.getQuantity(), cart.getTotalcost().replace(".", ""), cart.getProductID()));
                    productDAO.decreaseProductAmount(cart.getProductID(), cart.getQuantity());
                }
                session.setAttribute("AmountOfProductType", cartDAO.AmountOfProductTypeByUserID(user.getUserID()));
                SendMail sendMail = new SendMail();
                sendMail.SendMailCheckOut(order, request, response);
                request.setAttribute("successCheckout", true);
                request.getRequestDispatcher("/view/HomePageController").forward(request, response);
//                out.print("Checklegit is exists"); 
//                Order order = new Order(order_userID, order_salecodeID, note, date, status)
                return;
            } else if (request.getParameter("btnDatHang") != null) {
                float totalPrice = (float) session.getAttribute("totalPriceAfter");
                String vnp_Version = "2.1.0";
                String vnp_Command = "pay";
                String orderType = request.getParameter("ordertype");
//                long amount = Integer.parseInt(request.getParameter("amount")) * 100;
                long amount = (int) totalPrice * 100;
                String bankCode = request.getParameter("bankCode");
                String vnp_TxnRef = Config.getRandomNumber(8);
                String vnp_IpAddr = Config.getIpAddress(request);
                String vnp_TmnCode = Config.vnp_TmnCode;

                Map<String, String> vnp_Params = new HashMap<>();
                vnp_Params.put("vnp_Version", vnp_Version);
                vnp_Params.put("vnp_Command", vnp_Command);
                vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
                vnp_Params.put("vnp_Amount", String.valueOf(amount));
                vnp_Params.put("vnp_CurrCode", "VND");

                if (bankCode != null && !bankCode.isEmpty()) {
                    vnp_Params.put("vnp_BankCode", bankCode);
                }
                vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
                vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
                vnp_Params.put("vnp_OrderType", orderType);

                String locate = request.getParameter("language");
                if (locate != null && !locate.isEmpty()) {
                    vnp_Params.put("vnp_Locale", locate);
                } else {
                    vnp_Params.put("vnp_Locale", "vn");
                }
                vnp_Params.put("vnp_ReturnUrl", Config.vnp_Returnurl);
                vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

                Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                String vnp_CreateDate = formatter.format(cld.getTime());
                vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

                cld.add(Calendar.MINUTE, 15);
                String vnp_ExpireDate = formatter.format(cld.getTime());
                vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

                List fieldNames = new ArrayList(vnp_Params.keySet());
                Collections.sort(fieldNames);
                StringBuilder hashData = new StringBuilder();
                StringBuilder query = new StringBuilder();
                Iterator itr = fieldNames.iterator();
                while (itr.hasNext()) {
                    String fieldName = (String) itr.next();
                    String fieldValue = (String) vnp_Params.get(fieldName);
                    if ((fieldValue != null) && (fieldValue.length() > 0)) {
                        //Build hash data
                        hashData.append(fieldName);
                        hashData.append('=');
                        hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                        //Build query
                        query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                        query.append('=');
                        query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                        if (itr.hasNext()) {
                            query.append('&');
                            hashData.append('&');
                        }
                    }
                }
                String queryUrl = query.toString();
                String vnp_SecureHash = Config.hmacSHA512(Config.vnp_HashSecret, hashData.toString());
                queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
                String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
                session.setAttribute("checkoutType", request.getParameter("checkoutType"));
                response.sendRedirect(paymentUrl);
            } else if (request.getParameter("confirmSalecode") != null) {
//                out.print("confirmDiscount!"); 
                CartDAO cartDAO = new CartDAO();

                SaleCodeDAO saleCodeDAO = new SaleCodeDAO();
                ArrayList<Cart> data = (ArrayList<Cart>) session.getAttribute("data");
                String inputSalecode = request.getParameter("inputSalecode");
                float saleCodeRate = saleCodeDAO.checkValidSaleCodeAndReturnSaleRate(inputSalecode);

                float totalPrice = (float) session.getAttribute("totalPrice");
                out.print("<ul>");
                for (Cart item : data) {
//                    totalPrice += cartDAO.getTotalCostbyCartID(item.getCartID());
                    out.print("<li class=\"list-group-item d-flex justify-content-between lh-condensed\">\n"
                            + "                                        <div>\n"
                            + "                                            <h6 class=\"my-0\">" + item.getProductName() + "</h6>\n"
                            + "                                            <small class=\"text-muted\">" + item.getPrice() + " x " + item.getQuantity() + "</small>\n"
                            + "                                        </div>\n"
                            + "                                        <span class=\"text-muted\">" + item.getTotalcost() + " đ</span>\n"
                            + "                                    </li>");
                }
                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
                decimalFormat.applyPattern("#,###");
                if (saleCodeRate != 0) {
                    session.setAttribute("inputSalecode", inputSalecode);
                    float discountPrice = totalPrice * saleCodeRate / 100;
                    session.setAttribute("discountPrice", discountPrice);
                    out.print("<li class=\"list-group-item d-flex justify-content-between\">\n"
                            + "                                        <span>Đã áp dụng giảm giá</span>\n"
                            + "                                        <strong>- " + decimalFormat.format(discountPrice) + " đ</strong>\n"
                            + "                                    </li>");
                    totalPrice = totalPrice - totalPrice * saleCodeRate / 100;
                }

                out.print("<li class=\"list-group-item d-flex justify-content-between\">\n"
                        + "                                        <span>Tổng thành tiền</span>\n"
                        + "                                        <strong>" + decimalFormat.format(totalPrice).replaceAll(",", ".") + " đ</strong>\n"
                        + "                                    </li>\n"
                        + "                                </ul>");
                if (saleCodeRate == 0) {
                    out.print("<h6 style=\"font-size: 15px\" >Mã không tồn tại hoặc đã hết hạn!</h6>");
                }
                session.setAttribute("totalPriceAfter", totalPrice);
//                System.out.println("r: " + session.getAttribute("totalPriceAfter"));
                return;
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
