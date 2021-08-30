package mall_cart_servlet;

import mall_bean.Mall_Cart;
import mall_bean.Mall_Category;
import mall_bean.Mall_User;
import mall_category_servlet.Cate_Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CartSelect extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        ArrayList<Mall_Category> flist = Cate_Dao.selectCate("father");
        ArrayList<Mall_Category> clist = Cate_Dao.selectCate("Chill");
        request.setAttribute("flist",flist);
        request.setAttribute("clist", clist);

        HttpSession session = request.getSession();
        String isUser =(String) session.getAttribute("isUser");
        PrintWriter out = response.getWriter();
        if (isUser!=null&&isUser.equals("1")){
            Mall_User user=(Mall_User) session.getAttribute("user");
            ArrayList<Mall_Cart> mall_carts = Cart_Dao.selectAll(user.getUser_id());
            request.setAttribute("carts", mall_carts);
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        }else {
            out.write("<script>");
            out.write("alert('请先登录');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
        }

        out.close();

    }
}
