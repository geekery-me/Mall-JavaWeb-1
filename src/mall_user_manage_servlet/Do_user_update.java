package mall_user_manage_servlet;

import mall_user_servlet.User_dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Do_user_update extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("进入程序");
        String userID = req.getParameter("user_id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String birthday  =req.getParameter("user_birthday");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String cpage = req.getParameter("cpage");

        System.out.println(userID);
        System.out.println(cpage);
        User_dao user_dao=new User_dao();
        int count = user_dao.updateuser(username, password, sex, birthday, email, phone, address,userID);
        System.out.println(count);
        if (count>0){
            resp.sendRedirect("http://localhost:8888/08_shop/manage/do_user_select?cp="+cpage+"");
        }else{
            req.getRequestDispatcher("/manage/to_user_update?user_id="+userID).forward(req,resp);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
