package Controller.Admin;

import Dal.AccountDao;
import Dal.OrderDAO;
import Dal.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author trand
 */
public class AdminIncomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        ProductDAO dao = new ProductDAO();
        OrderDAO od = new OrderDAO();
        AccountDao ad = new AccountDao();

        int count = dao.CountProduct();
        int count1 = od.CountOrder();
        int count2 = dao.CountProductOut();
        int count3 = od.CountOrderCancelled();
        int count4 = ad.AccountBanned();
        int total = dao.totalIncome();
        List listpro = dao.BestSellerProducts();
        List listun = dao.limitProducts();
        int months = Calendar.getInstance().get(Calendar.MONTH);
       
        request.setAttribute("firstMonth", dao.totalIncomeByMonth(months - 4));
        request.setAttribute("secondMonth", dao.totalIncomeByMonth(months - 3));
        request.setAttribute("thirdMonth", dao.totalIncomeByMonth(months - 2));
        request.setAttribute("fourthMonth",dao.totalIncomeByMonth(months - 1));
        request.setAttribute("fifthMonth", dao.totalIncomeByMonth(months - 0));
        request.setAttribute("currMonth", dao.totalIncomeByMonth(months +1));
        
        request.setAttribute("EfirstMonth", dao.countEarPhoneByMonth(months - 4));
        request.setAttribute("EsecondMonth", dao.countEarPhoneByMonth(months - 3));
        request.setAttribute("EthirdMonth", dao.countEarPhoneByMonth(months - 2));
        request.setAttribute("EfourthMonth", dao.countEarPhoneByMonth(months - 1));
        request.setAttribute("EfifthMonth", dao.countEarPhoneByMonth(months - 0));
        request.setAttribute("EcurrMonth", dao.countEarPhoneByMonth(months + 1));

        request.setAttribute("KfirstMonth", dao.countKeyBoardByMonth(months - 4));
        request.setAttribute("KsecondMonth", dao.countKeyBoardByMonth(months - 3));
        request.setAttribute("KthirdMonth", dao.countKeyBoardByMonth(months - 2));
        request.setAttribute("KfourthMonth", dao.countKeyBoardByMonth(months - 1));
        request.setAttribute("KfifthMonth", dao.countKeyBoardByMonth(months - 0));
        request.setAttribute("KcurrMonth", dao.countKeyBoardByMonth(months + 1));

        request.setAttribute("MfirstMonth", dao.countMouseByMonth(months - 4));
        request.setAttribute("MsecondMonth", dao.countMouseByMonth(months - 3));
        request.setAttribute("MthirdMonth", dao.countMouseByMonth(months - 2));
        request.setAttribute("MfourthMonth", dao.countMouseByMonth(months - 1));
        request.setAttribute("MfifthMonth", dao.countMouseByMonth(months - 0));
        request.setAttribute("McurrMonth", dao.countMouseByMonth(months + 1));
        
        request.setAttribute("product", count);
        request.setAttribute("order", count1);
        request.setAttribute("het", count2);
        request.setAttribute("huy", count3);
        request.setAttribute("chan", count4);
        request.setAttribute("tong", total);
        request.setAttribute("listP", listpro);
        request.setAttribute("listun", listun);

        request.getRequestDispatcher("/admin/incomemanager.jsp").forward(request, response);
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
