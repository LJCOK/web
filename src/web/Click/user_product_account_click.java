package web.Click;

import backEnd.database;
import backEnd.dbOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/*连接结算界面*/
@WebServlet("/user_product_account_click")
public class user_product_account_click extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        System.out.println(id);
        if(id.equals("all")){
            // 结算所有商品
            HttpSession session = req.getSession();
            int u_id = (int) session.getAttribute("id");
            List<Map<String,Object>> listMaps= database.user_shoppingCart_queryId(u_id);
            if(listMaps.size()!=0){
                int sum = 0;
                for (Map<String, Object> map : listMaps) {
                    sum+=Integer.parseInt((String) map.get("p_price"));
                }
                req.setAttribute("sales",sum);
                req.setAttribute("number",88888);
                req.setAttribute("listMaps",listMaps);
                req.getRequestDispatcher("user_product_account.jsp").forward(req,resp);
            }
            else {
                req.getRequestDispatcher("shoppingCart_click").forward(req,resp);
            }
        }
        else {
            // 结算单个商品
            List<Map<String,Object>> listMaps = database.productSearch_id(id);
            int sum=0;
            for (Map<String, Object> map : listMaps) {
                sum+=Integer.parseInt((String) map.get("p_price"));
            }
            req.setAttribute("sales",sum);
            req.setAttribute("number",listMaps.get(0).get("p_id"));
            req.setAttribute("listMaps",listMaps);
            req.getRequestDispatcher("user_product_account.jsp").forward(req,resp);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
