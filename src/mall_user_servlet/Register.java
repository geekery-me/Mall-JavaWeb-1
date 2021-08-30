package mall_user_servlet;

import mall_bean.Mall_User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("进入程序");
        String userID = req.getParameter("user_id");
        String username = req.getParameter("user_name");
        String password = req.getParameter("user_password");

        String sex = req.getParameter("user_sex");
        String birthday  =req.getParameter("user_birthday");



        String email = req.getParameter("user_email");
        String phone = req.getParameter("user_phone");
        String address = req.getParameter("user_address");
        Mall_User user=new Mall_User(userID,username,password,sex,birthday,null,email,phone,address,1);

        //System.out.println(password+address+userID+username+email+phone+sex);
        //把用户添加进用户表

        User_dao user_dao=new User_dao();
        int count = user_dao.adduser(user);
        //System.out.println(count);
        //添加成功或失败
        if (count>0){
            resp.sendRedirect("index.html");
        }else{
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alert('添加失败')");
            //out.write("location.href='manage/admin_useradd.jsp'");
            out.write("</script>");

            resp.sendRedirect("reg.jsp");
        }
    }
}


