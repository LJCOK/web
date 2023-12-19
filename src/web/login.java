package web;

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

/*登录界面*/
@WebServlet("/login")
public class login extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        // 获取前端传送的手机号、密码等信息
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String user = req.getParameter("radio1");
        String admin = req.getParameter("radio1");
        // 做判断
        if (user==null|| admin==null||phone==null||password==null){
            // 为空，则返回登录页面
            resp.sendRedirect("login.jsp");
        }
        else if (database.Login(phone, password,1).size()!=0&&user.equals("user")){
            // 用户登录状态，用session记录登录的信息，跳转到主页
            List<Map<String,Object>> listMaps =database.Login(phone, password,1);
            HttpSession session = req.getSession();
            session.setAttribute("id",listMaps.get(0).get("u_id"));
            session.setAttribute("u_name",listMaps.get(0).get("u_name"));
            session.setAttribute("status", "1");
            session.setAttribute("phone",phone);
            session.setMaxInactiveInterval(30 * 60);
            req.getRequestDispatcher("index").forward(req, resp);
        }
        else if (database.Login(phone, password,2).size()!=0 && admin.equals("admin")) {
            // 管理员登录状态，用session记录登录的信息，跳转到主页
            List<Map<String,Object>> listMaps =database.Login(phone, password,2);
            HttpSession session = req.getSession();
            session.setAttribute("id",listMaps.get(0).get("a_id"));
            session.setAttribute("a_name",listMaps.get(0).get("a_name"));
            session.setAttribute("status","2");
            session.setAttribute("phone",phone);
            session.setMaxInactiveInterval(30 * 60);
            req.getRequestDispatcher("index").forward(req, resp);
        }
        else {
            // 密码错误，重定向
            resp.sendRedirect("login.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }
}
