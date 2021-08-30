package mall_user_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入程序");
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("isUser");
        request.getRequestDispatcher("indexselect").forward(request,response);
    }
}
