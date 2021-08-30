package mall_front_servlet;

import mall_bean.Mall_Category;
import mall_bean.Mall_Product;
import mall_category_servlet.Cate_Dao;
import mall_product_servlet.Product_Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SelectProductView extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        ArrayList<Mall_Category> flist = Cate_Dao.selectCate("father");
        ArrayList<Mall_Category> clist = Cate_Dao.selectCate("Chill");
        request.setAttribute("flist",flist);
        request.setAttribute("clist", clist);
        PrintWriter out = response.getWriter();
        String id = request.getParameter("pid");
        if (id!=null){
            int product_id = Integer.parseInt(id);
            Mall_Product product = Product_Dao.seleteById(product_id);
            if (product!=null){
                Mall_Category c = Cate_Dao.selectByID(product.getProduct_cid());
                Mall_Category f = Cate_Dao.selectByID(product.getProduct_fid());
                request.setAttribute("ccate", c);
                request.setAttribute("fcate", f);
                request.setAttribute("product", product);

                //最近访问
                HttpSession session = request.getSession();
                ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");
                if(ids==null){
                    ids=new ArrayList<Integer>();
                }
                //最大5个
                if (ids.size()>=5){
                    ids.remove(0);
                }

                if (!ids.contains(product_id)){
                    ids.add(product_id);
                }

                session.setAttribute("ids",ids);


                //通过session查询product
                ids=(ArrayList<Integer>)session.getAttribute("ids");
                if (ids!=null){
                    ArrayList<Mall_Product> products = Product_Dao.selectMoreByIds(ids);
                    request.setAttribute("recent",products);
                }

                //推荐列表
                int[] i=new int[2];
                i[1]=product.getProduct_cid();
                ArrayList<Mall_Product> ps = Product_Dao.seleteByFidOrCid("cid", i);

                request.setAttribute("recommended",ps);
                request.getRequestDispatcher("productview.jsp").forward(request,response);
            }else {

                out.write("<script>");
                out.write("alert('未查询到该商品');");
                out.write("location.href='indexselect';");
                out.write("</script>");
                out.close();
            }
        }else{
            out.write("<script>");
            out.write("alert('页面加载失败');");
            out.write("location.href='indexselect';");
            out.write("</script>");
            out.close();
        }


    }
}
