package web.Click;

import backEnd.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/*购物车点击*/
@WebServlet("/shoppingCart_click")
public class shoppingCard_click extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        if (session.getAttribute("status")==null){
            resp.sendRedirect("login.jsp");
        }
        else if (session.getAttribute("status").equals("1")){
            // 用户胡登录状态
            int u_id = (int) session.getAttribute("id");
            List<Map<String, Object>> listMaps = database.user_shoppingCart_queryId(u_id);
            System.out.println(listMaps);
            req.setAttribute("listMaps",listMaps);
            req.getRequestDispatcher("user_shoppingCart.jsp").forward(req, resp);
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
