package mall_user_servlet;

import mall_bean.Mall_User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserIDCheck extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("进入程序");
        String user_id = request.getParameter("user_id");
        User_dao user_dao=new User_dao();
        Mall_User mall_user = user_dao.queryUserByID(user_id);
        PrintWriter out=response.getWriter();
        if (mall_user==null){

            out.write("false");
        }else{

            out.write("true");
        }
        out.close();
    }

}
