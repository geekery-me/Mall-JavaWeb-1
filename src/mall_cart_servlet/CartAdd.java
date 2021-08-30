package mall_cart_servlet;

import mall_bean.Mall_Cart;
import mall_bean.Mall_Product;
import mall_bean.Mall_User;
import mall_product_servlet.Product_Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CartAdd extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String pid = request.getParameter("pid");
        String count = request.getParameter("count");
        String flag = request.getParameter("flag");
        PrintWriter out = response.getWriter();


        Mall_Product product=null;
        int id=-1;
        Mall_Cart cart=null;


        if (pid!=null){
            id=Integer.parseInt(pid);
            product = Product_Dao.seleteById(id);
        }


        //先判断是否登录
        HttpSession session = request.getSession();
        String isUser =(String) session.getAttribute("isUser");
        int quantity=-1;
        if (count!=null && Integer.parseInt(count)>0){
            quantity=Integer.parseInt(count);
        }

        if (isUser!=null && isUser.equals("1")){
            Mall_User user=(Mall_User) session.getAttribute("user");
            //获取cart对象
            if (product.getProduct_stock()>quantity &&product!=null){
                Mall_Cart hascart = Cart_Dao.selectCartByPidAndUid(user.getUser_id(), id);
                if (hascart!=null){
                    int newcount=hascart.getCart_quantity()+quantity;
                    if(newcount>=5){
                        newcount=5;
                    }
                    //更新quantity

                    int i = Cart_Dao.updateByid(hascart.getCart_id(), newcount);

                    if (i>0){
                        if (flag.equals("z")){
                            request.getRequestDispatcher("cartselect").forward(request,response);
                        }else if(flag.equals("s")){
                            request.getRequestDispatcher("selectproductview?pid="+pid).forward(request,response);
                        }
                    }else {
                        out.write("<script>");
                        out.write("alert('加入购物车失败');");
                        out.write("location.href='selectproductview?pid="+pid+"';");
                        out.write("</script>");
                    }

                }else {
                    cart = new Mall_Cart();
                    cart.setCart_p_filename(product.getProduct_filename());
                    cart.setCart_p_name(product.getProduct_name());
                    cart.setCart_p_price(product.getProduct_price());
                    cart.setCart_p_stock(product.getProduct_stock());
                    cart.setCart_p_id(product.getProduct_id());
                    cart.setCart_quantity(quantity);
                    cart.setCart_u_id(user.getUser_id());
                    cart.setCart_valid(1);
                    int i = Cart_Dao.cartAdd(cart);
                    if (i>0){
                        //判断是否要跳转
                        if (flag.equals("z")){
                            request.getRequestDispatcher("cartselect").forward(request,response);
                        }else if(flag.equals("s")){
                            request.getRequestDispatcher("selectproductview?pid="+pid).forward(request,response);
                        }
                    }else {
                        out.write("<script>");
                        out.write("alert('加入购物车失败');");
                        out.write("location.href='selectproductview?pid="+pid+"';");
                        out.write("</script>");
                    }
                }

            }else {
                out.write("<script>");
                out.write("alert('该商品已无库存');");
                out.write("location.href='indexselect';");
                out.write("</script>");
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
