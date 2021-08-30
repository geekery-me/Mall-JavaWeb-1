package mall_category_servlet;

import mall_bean.Mall_Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Do_AddCate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("进入程序lala");
        String parentID = request.getParameter("parentID");
        String cate_name = request.getParameter("cate_name");

        int cate_parent_id=Integer.parseInt(parentID);
        Mall_Category cate=new Mall_Category(0,cate_name,cate_parent_id);
        int count = Cate_Dao.addCate(cate);
        if (count>0){
            response.sendRedirect("/08_shop/manage/selectallcate");
        }else {
            request.getRequestDispatcher("admin_AddCate.jsp").forward(request,response);
        }

    }
}
