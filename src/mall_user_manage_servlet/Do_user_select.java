package mall_user_manage_servlet;

import mall_bean.Mall_User;
import mall_user_servlet.User_dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
public class Do_user_select extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User_dao user_dao=new User_dao();


        //当前页数
        int cpage=1;
        //每页显示的条数
        int count=5;

        String cp = request.getParameter("cp");
        if (cp!=null){
            int cp1=Integer.parseInt(cp);
            if (cp1==0){
                cpage=1;
            }else {
                cpage=cp1;
            }


        }
        //关键字查询
        String keyword=request.getParameter("keywords");
        int[] arr=user_dao.totalPage(count,keyword);

        if (cpage>arr[1]){
            cpage=arr[1];
        }

        request.setAttribute("tsum",arr[0]);
        request.setAttribute("tpage",arr[1]);
        request.setAttribute("cpage",cpage);


        ArrayList<Mall_User> mall_users = user_dao.queryAll(cpage,count,keyword);
        request.setAttribute("list",mall_users);
        if (keyword!=null){
            request.setAttribute("searchParams","&keywords="+keyword);
        }
        request.getRequestDispatcher("admin_user.jsp").forward(request,response);
    }
}
