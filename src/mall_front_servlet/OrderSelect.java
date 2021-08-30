package mall_front_servlet;

import mall_bean.Mall_Cart;
import mall_bean.Mall_Category;
import mall_cart_servlet.Cart_Dao;
import mall_category_servlet.Cate_Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OrderSelect extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        ArrayList<Mall_Category> flist = Cate_Dao.selectCate("father");
        ArrayList<Mall_Category> clist = Cate_Dao.selectCate("Chill");
        request.setAttribute("flist",flist);
        request.setAttribute("clist", clist);


        String ids = request.getParameter("ids");
        ArrayList<Mall_Cart> list=new ArrayList<>();
        HttpSession session = request.getSession();
        String isUser =(String) session.getAttribute("isUser");
        PrintWriter out = response.getWriter();
        double allprice=0;
        if (isUser!=null&&isUser.equals("1")){
            if (ids.equals("")){
                request.getRequestDispatcher("cartselect").forward(request,response);
            }else{
                String[] split = ids.split("-");
                for (int i=0;i<split.length;i++){
                    Mall_Cart cart = Cart_Dao.selectByCartId(Integer.parseInt(split[i]));
                    list.add(cart);
                    allprice+=(cart.getCart_quantity()*cart.getCart_p_price());
                }
                request.setAttribute("allprice", allprice);
                request.setAttribute("orderlist", list);
                request.getRequestDispatcher("order.jsp").forward(request,response);
            }
        }else {
            out.write("<script>");
            out.write("alert('请先登录');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
        }

        out.close();





    }
}
