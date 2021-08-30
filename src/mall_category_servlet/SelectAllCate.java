package mall_category_servlet;

import mall_bean.Mall_Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SelectAllCate extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("进入程序");

        ArrayList<Mall_Category> list = Cate_Dao.selectAll();
        request.setAttribute("catelist", list);
        request.getRequestDispatcher("admin_category.jsp").forward(request,response);
    }
}
