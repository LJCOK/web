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

/*此为最终的结算界面*/
@WebServlet("/user_products_account_click")
public class user_products_account_click extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        int p_id = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        int u_id = (int) session.getAttribute("id");
        String u_name=(String) session.getAttribute("u_name");
        if(p_id==88888)
        {
            // 清空购物车，都买了
            database.user_product_deleteAll(u_id);
            List<Map<String,Object>> listMaps = database.user_shoppingCart_queryId(u_id);
            for (Map<String, Object> map : listMaps){
                database.log_add((Integer) map.get("p_id"),u_name,3);   // 加入日志
                database.email_send((Integer) map.get("p_id"),u_id);             // 发送邮件
                database.user_product_delete2((Integer) map.get("p_id"),u_id);
            }
            req.getRequestDispatcher("shoppingCart_click").forward(req,resp);
        }
        else{
            // 只买对应的
            database.log_add(p_id,u_name,3);   // 加入日志
            database.email_send(p_id,u_id);             // 发送邮件
            database.user_product_delete2(p_id,u_id);
            req.getRequestDispatcher("shoppingCart_click").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
