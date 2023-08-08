package Controller.Account;

import Dal.AccountDao;
import Dal.CartDAO;
import Impl.LoginWithGoogle;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author DucPhaoLo
 */
// file name not match??
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String urlString= request.getRequestURI();
            if(urlString.equals(request.getContextPath()+"/view/homepage"))
            {
                HttpSession session =request.getSession();
                if(session.getAttribute("user")!=null)
                {
                    User u =(User)session.getAttribute("user");
                    if(u.getUser_roleID()!=null)
                        session.setAttribute("role",u.getUser_roleID()); 
                }   
                request.getRequestDispatcher("/view/HomePageController").forward(request, response);
            }
            else if(urlString.equals(request.getContextPath()+"/auth/LoginWithGoogle"))
            {
                String code =request.getParameter("code"); 
                LoginWithGoogle loginWithGoogle = new LoginWithGoogle();
                String email=loginWithGoogle.LoginWithGoogle(code, request, response);
                AccountDao accountDao=new AccountDao();
                if(accountDao.checkExistAccountByEmail(email))
                {
                    User user = new User();
                    user.setEmail(email);
                    HttpSession mySession = request.getSession();
                    user=accountDao.GetUserByEmail(email);
                    CartDAO cartDAO=new CartDAO();
                    mySession.setAttribute("AmountOfProductType", cartDAO.AmountOfProductTypeByUserID(user.getUserID()));
//                    System.out.println("cartDAO.AmountOfProductTypeByUserID(user.getUserID()): "+cartDAO.AmountOfProductTypeByUserID(user.getUserID()));
                    mySession.setAttribute("user", user); 
                    response.sendRedirect(request.getContextPath()+"/view/homepage");
                }
                else// neu khong dang nhap thanh cong quay lai trang login
                {
                    response.sendRedirect(request.getContextPath()+"/auth/login.jsp");
                }
            }
            else
            {
                request.getRequestDispatcher("/auth/login.jsp").forward(request, response); 
            }
                
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try ( PrintWriter out = response.getWriter()) {

            if (request.getParameter("signUp") != null) {
                request.getRequestDispatcher("/auth/register.jsp").forward(request, response);
            } else if (request.getParameter("signIn") != null) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                User user = new User(username, password);
                AccountDao accountDao = new AccountDao();
                if (accountDao.checkLogin(user)) {
                    user=accountDao.getUserByUserName(username);
                    HttpSession mySession = request.getSession();
                    mySession.setAttribute("user", user); 
                    response.sendRedirect(request.getContextPath()+"/view/homepage");
                } else {
                    request.setAttribute("message", "Login Fails!");
                    request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
                }
            }
        }

    }
    

}
