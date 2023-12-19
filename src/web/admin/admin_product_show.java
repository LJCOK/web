package web.admin;

import backEnd.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/*返回管理员的商品*/
@WebServlet("/admin_product_show")
public class admin_product_show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

//        HttpSession session = req.getSession();
//        // 根据手机号识别
//        String phone = (String) session.getAttribute("phone");
//        List<Map<String, Object>> listMaps = database.product_admin(phone);

        List<Map<String, Object>> listMaps = database.product_all();
        req.setAttribute("listMaps",listMaps);
        req.getRequestDispatcher("admin_product_show.jsp").forward(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
