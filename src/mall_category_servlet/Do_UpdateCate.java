package mall_category_servlet;

import mall_bean.Mall_Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Do_UpdateCate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("bbb");
        String cateid = request.getParameter("cate_id");
        String parentID = request.getParameter("parentID");
        String cate_name = request.getParameter("cate_name");
        PrintWriter out = response.getWriter();
        if (cate_name.equals("")){
            out.write("<script>");
            out.write("alert('分类名不能为空');");
            out.write("location.href='manage/admin_cateUpdate.jsp';");
            out.write("</script>");

        }else{
            int cate_id=Integer.parseInt(cateid);
            int cate_parent_id=Integer.parseInt(parentID);
            Mall_Category cate=new Mall_Category(cate_id,cate_name,cate_parent_id);
            int count = Cate_Dao.updateByID(cate);
            if (count>0){
                response.sendRedirect("selectallcate");
            }else{
                out.write("<script>");
                out.write("alert('修改失败');");
                out.write("location.href='manage/admin_cateUpdate.jsp';");
                out.write("</script>");
            }
        }
        out.close();
    }


}
