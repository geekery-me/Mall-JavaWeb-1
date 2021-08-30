package filter;

import mall_bean.Mall_User;
import mall_user_servlet.User_dao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FilterRegister implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");


        String user_id = request.getParameter("user_id");
        HttpSession session = request.getSession();
        String code=(String) session.getAttribute("code");
        String code1 = request.getParameter("Code");
        PrintWriter out = response.getWriter();




        //用户id验证
        if (user_id==null){
            out.write("<script>");
            out.write("alert('ID不能为空');");
            out.write("location.href='http://localhost:8888/08_shop/reg.jsp';");
            out.write("</script>");
            return;
        }else{
            User_dao user_dao=new User_dao();
            Mall_User mall_user = user_dao.queryUserByID(user_id);
            if (mall_user!=null){
                out.write("<script>");
                out.write("alert('ID不能使用');");
                out.write("location.href='http://localhost:8888/08_shop/reg.jsp';");
                out.write("</script>");
                return;
            }
        }

        //用户密码验证
        String user_password = request.getParameter("user_password");
        if (user_password.equals("")){
            out.write("<script>");
            out.write("alert('用户密码不能为空');");
            out.write("location.href='http://localhost:8888/08_shop/reg.jsp';");
            out.write("</script>");
            return;
        }


        //验证码的验证
        if (code1!=null) {
            if (!code.equals(code1)){
                out.write("<script>");
                out.write("alert('验证码错误');");
                out.write("location.href='http://localhost:8888/08_shop/reg.jsp';");
                out.write("</script>");
                return;
            }
        }else {
            out.write("<script>");
            out.write("alert('验证码错误');");
            out.write("location.href='http://localhost:8888/08_shop/reg.jsp';");
            out.write("</script>");
            return;
        }



        out.close();
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
