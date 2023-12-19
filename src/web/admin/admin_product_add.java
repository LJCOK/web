package web.admin;

import backEnd.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/*添加商品*/
@WebServlet("/admin_product_add")
public class admin_product_add extends HttpServlet {
    // 判断数据的合法性
    public Boolean judge(String product_name,String product_price,String product_num){
        if(product_name==null||product_num==null||product_price==null)
            return false;
 else return product_name.length() <= 30 && product_num.length() <= 5 && product_price.length() <= 5;
    }
    // 判断是否为整数
    public static boolean isNum(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (Exception e) {
            System.out.println("can not change to Int!");
            return false;
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String product_name = req.getParameter("product_name");
        String product_price = req.getParameter("product_price");
        String product_num = req.getParameter("product_num");
        if(judge(product_name,product_price,product_num)&&isNum(product_num)&&isNum(product_price)){
            HttpSession session = req.getSession();
            String phone = (String) session.getAttribute("phone");
            database.admin_add_product(product_name,product_price,product_num,phone);
            req.getRequestDispatcher("admin_product_show").forward(req,resp);
        }
        else
            req.getRequestDispatcher("admin_product_add.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
