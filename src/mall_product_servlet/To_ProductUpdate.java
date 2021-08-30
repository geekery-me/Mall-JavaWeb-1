package mall_product_servlet;

import mall_bean.Mall_Category;
import mall_bean.Mall_Product;
import mall_category_servlet.Cate_Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class To_ProductUpdate extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String product_id = request.getParameter("product_id");
        String cpage = request.getParameter("cpage");
        ArrayList<Mall_Category> flist = Cate_Dao.selectCate("father");
        ArrayList<Mall_Category> clist = Cate_Dao.selectCate("Chill");
        request.setAttribute("flist",flist);
        request.setAttribute("clist", clist);
        PrintWriter out = response.getWriter();

        if (cpage!=null&&product_id!=null){
            int pid = Integer.parseInt(product_id);
            int cp = Integer.parseInt(cpage);
            Mall_Product product = Product_Dao.seleteById(pid);
            request.setAttribute("product", product);
            request.setAttribute("cp", cp);
            request.getRequestDispatcher("admin_productupdate.jsp").forward(request,response);
        }else {
            out.write("<script>");
            out.write("<alert('缺少信息')>");
            out.write("location.href='http://localhost:8888/08_shop/manage/productselect?cp=" + cpage + "'");
            out.write("</script>");
        }
    }
}
