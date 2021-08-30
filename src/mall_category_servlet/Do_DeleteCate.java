package mall_category_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Do_DeleteCate extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("ccc");
        String cateid = request.getParameter("cate_id");
        PrintWriter out = response.getWriter();
        if (cateid.equals("")){
            out.write("<script>");
            out.write("alert('未获得id');");
            out.write("location.href='selectallcate';");
            out.write("</script>");

        }else{
            int cate_id=Integer.parseInt(cateid);
            int count = Cate_Dao.deleteByID(cate_id);
            if (count>0){
                response.sendRedirect("selectallcate");
            }else{
                out.write("<script>");
                out.write("alert('修改失败');");
                out.write("location.href=selectallcate;");
                out.write("</script>");
            }
        }
        out.close();
    }
}
