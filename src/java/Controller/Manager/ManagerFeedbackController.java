package Controller.Manager;

import Dal.ManagerDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManagerFeedbackController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        ManagerDAO dao = new ManagerDAO();
        dao.getFeedbackList();
        req.setAttribute("listF", dao.getFeedback());
        String id = req.getParameter("id");
        String confirmed = req.getParameter("confirmation"); // Thêm tham số confirmed từ JSP
        System.out.println("conf" + confirmed);
        if (req.getParameter("mod") != null && req.getParameter("mod").equals("1")) {
            try {
                if (confirmed != null && confirmed.equals("true")) {
                    Date parsedDate = dateFormat.parse(id);
                    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
                    dao.deleteFeedback(timestamp);
                    resp.sendRedirect("ManagerFeedbackController");
                }

            } catch (ParseException e) {
                // Xử lý ngoại lệ nếu không thể chuyển đổi chuỗi thành ngày
                e.printStackTrace();
                // Hoặc hiển thị thông báo lỗi cho người dùng
            }

        }
        req.getRequestDispatcher("feedbackmanager.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

}
