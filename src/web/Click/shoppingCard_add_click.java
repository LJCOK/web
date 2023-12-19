package web.Click;

import backEnd.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*加入购物车点击*/
@WebServlet("/shoppingCard_add_click")
public class shoppingCard_add_click extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        if (session.getAttribute("status")==null){
            // 无登录状态
            resp.sendRedirect("login.jsp");
        }
        else if (session.getAttribute("status").equals("1")) {
            // 用户登录状态
            int id = (int) session.getAttribute("id");
            String p_id = req.getParameter("id");
            String u_name = (String) session.getAttribute("u_name");
            database.shoppingCard_add(id,p_id,u_name);
            req.getRequestDispatcher("index").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("index").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
