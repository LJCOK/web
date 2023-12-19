package web.admin;

import backEnd.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/*修改商品*/
@WebServlet("/admin_product_modify")
public class admin_product_modify extends HttpServlet {
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
            System.out.println("num is not intergal!");
            return false;
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String p_id = req.getParameter("p_id");
        String p_describe = req.getParameter("product_name");
        String p_price = req.getParameter("product_price");
        String p_num = req.getParameter("product_num");
        if(judge(p_describe,p_price,p_num)&&isNum(p_num)&&isNum(p_price)){
            database.admin_modify_product(p_describe,p_price,p_num,p_id);
//            resp.sendRedirect("admin_product");
            req.getRequestDispatcher("admin_product_show").forward(req,resp);
        }
        else
            req.getRequestDispatcher("admin_product_modify.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
