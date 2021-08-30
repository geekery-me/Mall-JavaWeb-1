package mall_user_manage_servlet;

import mall_bean.Mall_User;
import mall_user_servlet.User_dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Do_user_add extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("进入程序");
        String userID = request.getParameter("userID");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String sex = request.getParameter("sex");
        String birthday  =request.getParameter("user_birthday");



        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        Mall_User user=new Mall_User(userID,username,password,sex,birthday,null,email,phone,address,1);

        //System.out.println(password+address+userID+username+email+phone+sex);
        //把用户添加进用户表

        User_dao user_dao=new User_dao();
        int count = user_dao.adduser(user);
        //System.out.println(count);
        //添加成功或失败
        if (count>0){
            response.sendRedirect("admin_user.jsp");
        }else{
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('添加失败');");
            out.write("location.href='manage/admin_useradd.jsp';");
            out.write("</script>");
            out.close();
            response.sendRedirect("admin_useradd.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
