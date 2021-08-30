package mall_user_manage_servlet;

import mall_user_servlet.User_dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Do_user_delete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        User_dao user_dao=new User_dao();

        String[] ids = request.getParameterValues("id[]");
        for (int i=0;i<ids.length;i++){
            user_dao.deleteByID(ids[i]);
        }


        response.sendRedirect("http://localhost:8888/08_shop/manage/do_user_select");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String user_id = request.getParameter("user_id");
        String cpage = request.getParameter("cpage");

        User_dao user_dao=new User_dao();
        int count = user_dao.deleteByID(user_id);
        if (count>0){
            response.sendRedirect("http://localhost:8888/08_shop/manage/do_user_select?cp="+cpage+"");
        }else{
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("<alert('添加失败')>");
            out.write("location.href='http://localhost:8888/08_shop/manage/do_user_select?cp="+cpage+"'");
            out.write("</script>");
            out.close();
        }

    }
}
