package web;

import backEnd.database;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*注册界面*/
@WebServlet("/register")
public class register extends HttpServlet {
    // 判断数据的合法性
    public Boolean judge(String name,String phone,String password,String password_confirm,String checkbox) {
        if(name==null||phone==null||password==null||password_confirm==null||checkbox==null){
            // 输入框为空
            return false;}
        // 数据长度控制
        else if (name.length()>8 || name.length()<2)
            return false;
        else if (password.length()>16||password.length()<2)
            return false;
        else return password.equals(password_confirm);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        // 获取前端数据
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String password_confirm = req.getParameter("Cpassword");
        String checkbox = req.getParameter("radio");
        // 转发 地址不改变，参数共享
        if (judge(username,phone,password,password_confirm,checkbox)&&database.register_phone_judge(phone,checkbox).size()==0) {
            // 成功注册
            database.Register(username,phone,password,checkbox);
            System.out.println("register successfully!");
            req.getRequestDispatcher("login_click").forward(req, resp);
        } else {
            // 信息错误
            System.out.println("register fail!");
            resp.sendRedirect("register.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
