package mall_user_servlet;

import mall_bean.Mall_User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("进入程序");
        String user_id = request.getParameter("user_id");
        String user_password = request.getParameter("user_password");
        User_dao user_dao=new User_dao();
        int count = user_dao.login(user_id, user_password);
        PrintWriter out = response.getWriter();
        if (count>0){
            HttpSession session = request.getSession();
            Mall_User user = user_dao.queryUserByID(user_id);
            session.setAttribute("user",user);
            session.setAttribute("isUser", "1");//设置标记位
            response.sendRedirect("indexselect");
        }else {
            out.write("<script>");
            out.write("alert('输入的id或密码有误');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
            out.close();
        }
    }


}
