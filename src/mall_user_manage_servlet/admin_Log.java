package mall_user_manage_servlet;

import mall_bean.Mall_User;
import mall_user_servlet.User_dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class admin_Log extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("进入程序");
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        session.removeAttribute("isUser");
        session.removeAttribute("isManagerUser");
        resp.sendRedirect("admin_login.jsp");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("进入程序");
        String user_id = request.getParameter("user_id");
        String user_password = request.getParameter("user_password");
        if (user_id!=null&&request!=null){
            User_dao user_dao=new User_dao();
            int count = user_dao.login(user_id, user_password);

            HttpSession session = request.getSession();

            PrintWriter out = response.getWriter();

            if (count>0){
                Mall_User user = user_dao.queryUserByID(user_id);
                session.setAttribute("user",user);
                session.setAttribute("isUser", "1");//设置标记位
                if (user.getUser_status()==2){
                    session.setAttribute("isManagerUser", "1");
                    response.sendRedirect("/08_shop/manage/admin_index.jsp");
                }else{


                    out.write("<script>");
                    out.write("alert('非管理员不能登录');");
                    out.write("location.href='admin_login.jsp'");
                    out.write("</script>");
                    out.close();

                }
            }else {

                out.write("<script>");
                out.write("alert('非管理员不能登录');");
                out.write("location.href='admin_login.jsp'");
                out.write("</script>");
                out.close();

            }
        }else {
            return;
        }

    }


}
