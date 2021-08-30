package mall_product_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Do_DeleteProduct extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String product_id = request.getParameter("product_id");
        String cpage = request.getParameter("cpage");
        PrintWriter out = response.getWriter();
        if (cpage!=null&&product_id!=null){
            int pid = Integer.parseInt(product_id);
            int cp = Integer.parseInt(cpage);
            int count = Product_Dao.deleteById(pid);

            if (count>0){
                request.setAttribute("cp", cp);
                request.getRequestDispatcher("productselect").forward(request,response);
            }else {
                out.write("<script>");
                out.write("<alert('删除失败')>");
                out.write("location.href='http://localhost:8888/08_shop/manage/productselect?cp="+cpage+"'");
                out.write("</script>");
            }
        }else {
            out.write("<script>");
            out.write("<alert('缺少信息')>");
            out.write("location.href='http://localhost:8888/08_shop/manage/productselect?cp="+cpage+"'");
            out.write("</script>");
        }
    }
}
