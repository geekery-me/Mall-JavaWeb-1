package mall_cart_servlet;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String[] ids = request.getParameterValues("ids");

        for (int i=0;i<ids.length;i++){
            int count = Cart_Dao.deleteById(Integer.parseInt(ids[i]));
        }
        request.getRequestDispatcher("cartselect").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String cart_id = request.getParameter("cart_id");
        if (cart_id!=null){
            int id = Integer.parseInt(cart_id);
            int count = Cart_Dao.deleteById(id);
            if (count<=0){
                PrintWriter out = response.getWriter();
                out.write("<script>");
                out.write("alert('删除失败');");
                out.write("location.href='cartselect';");
                out.write("</script>");
                out.close();

            }
        }else {

            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('信息缺失');");
            out.write("location.href='cartselect';");
            out.write("</script>");
            out.close();
        }
    }
}
