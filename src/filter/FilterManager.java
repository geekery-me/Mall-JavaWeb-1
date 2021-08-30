package filter;



import mall_bean.Mall_User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class FilterManager implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入程序");
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        String isManagerUser =(String) session.getAttribute("isManagerUser");
        String isUser =(String) session.getAttribute("isUser");
        Mall_User user =(Mall_User) session.getAttribute("user");
        PrintWriter out = response.getWriter();
        String path=request.getRequestURI();
        if(path.contains(".css") || path.contains(".js") || path.contains(".png")|| path.contains(".jpg") || (isUser!=null && isUser.equals("1") && isManagerUser!=null && isManagerUser.equals("1") )){
            //如果发现是css或者js文件，直接放行
            filterChain.doFilter(request, response);
        }else{
            out.write("<script>");
            out.write("alert('请先登录管理员账号');");
            out.write("location.href='http://localhost:8888/08_shop/admin_login.jsp';");
            out.write("</script>");
            out.close();
        }

    }

    @Override
    public void destroy() {

    }
}
