package web.Click;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/exitLogin_click_2")
public class exitLogin_click_2 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        System.out.println(session.getAttribute("a_name"));
        System.out.println(session.getAttribute("u_name"));
        if(session.getAttribute("a_name")!=null||session.getAttribute("u_name")!=null) {
            session.invalidate();
            resp.sendRedirect("login.jsp");
        }
        else
            req.getRequestDispatcher("index").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
