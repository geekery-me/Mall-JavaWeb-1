package mall_user_manage_servlet;

import mall_bean.Mall_User;
import mall_user_servlet.User_dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class to_user_update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("进入程序");
        String user_id = request.getParameter("user_id");

        User_dao user_dao=new User_dao();
        Mall_User mall_user = user_dao.queryUserByID(user_id);



        String cpage = request.getParameter("cpage");
        request.setAttribute("cpage",cpage);
        request.setAttribute("user",mall_user);
        request.getRequestDispatcher("admin_userupdate.jsp").forward(request,response);
    }
}
