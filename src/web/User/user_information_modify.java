package web.User;

import backEnd.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*用户信息修改页面*/
@WebServlet("/user_information_modify")
public class user_information_modify extends HttpServlet {
    public Boolean judge(String u_name,String u_phone,String u_email,String u_password,String u_idcard){
        return u_name != null && u_phone != null && u_email != null && u_password != null && u_idcard != null;
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String u_idcard="1";
        String u_email = "1";
        String u_name = req.getParameter("u_name");
        String u_phone = req.getParameter("u_phone");
        u_email = req.getParameter("u_email");
        String u_password = req.getParameter("u_password");
        u_idcard = req.getParameter("u_idcard");
        HttpSession session = req.getSession();
        int u_id = (int) session.getAttribute("id");
        if(judge(u_name,u_phone,u_email,u_password,u_idcard)) {
            database.user_information_modify(u_id, u_name, u_phone, u_email, u_password, u_idcard);
            req.getRequestDispatcher("user_information_show").forward(req, resp);
        }
        else
            req.getRequestDispatcher("user_information_modify_click").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
