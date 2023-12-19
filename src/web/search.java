package web;

import backEnd.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/*搜索界面*/
@WebServlet("/search1")
public class search extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String product_name = req.getParameter("search");
        System.out.println(product_name+"2");
        if(product_name==null||product_name.equals("")){
            req.getRequestDispatcher("index").forward(req, resp);
        }
        else {
            List<Map<String, Object>> listMaps = database.user_eamil_queryId(product_name);
            req.setAttribute("listMaps",listMaps);
            System.out.println(listMaps);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
