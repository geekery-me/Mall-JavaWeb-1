package mall_cart_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CartUpdateQuantity extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String count = request.getParameter("count");
        String cart_id = request.getParameter("cart_id");
       if (cart_id!=null && count!=null){
           System.out.println(cart_id+"--"+count);
           int id=Integer.parseInt(cart_id);
           int quantity=Integer.parseInt(count);
           int i = Cart_Dao.updateByid(id, quantity);
          if (i<=0){
              PrintWriter out = response.getWriter();
              out.write("<script>");
              out.write("alert('修改数量失败');");
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
