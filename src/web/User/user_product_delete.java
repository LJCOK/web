package web.User;

import backEnd.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user_product_delete")
public class user_product_delete extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String p_id = req.getParameter("id");
        HttpSession session = req.getSession();
        int u_id = (int) session.getAttribute("id");
        String u_name=(String) session.getAttribute("u_name");
        database.log_add(Integer.parseInt(p_id),u_name,2);   // 加入日志
        database.user_product_delete(p_id,u_id);
        req.getRequestDispatcher("shoppingCart_click").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
