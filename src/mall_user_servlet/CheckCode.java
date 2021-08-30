package mall_user_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckCode extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("进入程序");
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String code1 = (String)session.getAttribute("code");
        PrintWriter out = response.getWriter();
        if (code.equals(code1)){
            out.write("true");
        }else{
            out.write("false");
        }
        out.close();
    }
}
