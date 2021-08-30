package mall_front_servlet;

import mall_bean.Mall_Category;
import mall_bean.Mall_Product;
import mall_category_servlet.Cate_Dao;
import mall_product_servlet.Product_Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SelectProductList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        ArrayList<Mall_Category> flist = Cate_Dao.selectCate("father");
        ArrayList<Mall_Category> clist = Cate_Dao.selectCate("Chill");
        request.setAttribute("flist",flist);
        request.setAttribute("clist", clist);



        String fid = request.getParameter("fid");
        String fcid = request.getParameter("id");
        int[] id=new int[2];
        if (fid!=null){
            int cate_fid=Integer.parseInt(fid);
            Mall_Category cate = Cate_Dao.selectByID(cate_fid);
            request.setAttribute("fcate",cate);
            id[0]=cate_fid;
            ArrayList<Mall_Product> fproduct = Product_Dao.seleteByFidOrCid("fid", id);
            request.setAttribute("productlist", fproduct);

        }else{
            String[] fid_cid = fcid.split("-");
            int cate_fid=Integer.parseInt(fid_cid[0]);
            int cate_cid=Integer.parseInt(fid_cid[1]);
            Mall_Category fcate = Cate_Dao.selectByID(cate_fid);
            Mall_Category ccate = Cate_Dao.selectByID(cate_cid);
            request.setAttribute("fcate",fcate);
            request.setAttribute("ccate",ccate);
            id[0]=cate_fid;
            id[1]=cate_cid;
            ArrayList<Mall_Product> cproduct = Product_Dao.seleteByFidOrCid("fcid", id);
            request.setAttribute("productlist", cproduct);



        }

        request.getRequestDispatcher("productlist.jsp").forward(request,response);
    }
}
