package mall_category_servlet;

import mall_bean.Mall_Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class To_UpdateCate extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("jinruaaa");
        String cate_id = request.getParameter("cate_id");
        if (cate_id!=null){
            int id=Integer.parseInt(cate_id);
            Mall_Category cate = Cate_Dao.selectByID(id);
            if (cate!=null){
                request.setAttribute("cate",cate);
                ArrayList<Mall_Category> list = Cate_Dao.selectAll();
                request.setAttribute("catelist", list);
                request.getRequestDispatcher("admin_cateUpate.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("/08_shop/manage/selectallcate").forward(request,response);
            }
        }else {request.getRequestDispatcher("/08_shop/manage/selectallcate").forward(request,response);}
    }
}
