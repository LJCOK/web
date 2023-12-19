package web.Click;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*'登录'按钮*/
@WebServlet("/login_click")
public class login_click extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        if (session.getAttribute("status")==null){
            resp.sendRedirect("login.jsp");
        }
        else if (session.getAttribute("status").equals("1")){
            // 用户胡登录状态
            req.getRequestDispatcher("user_information_show").forward(req, resp);
        } else if (session.getAttribute("status").equals("2")) {
            // 管理员登录状态
            req.getRequestDispatcher("admin_product_show").forward(req, resp);
        }
        else {
            resp.sendRedirect("login.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
