package cn.huzhihong.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/user/*")
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD) //只有转发访问时过滤器才执行
//@WebFilter(value = "/*",dispatcherTypes ={ DispatcherType.FORWARD,DispatcherType.REQUEST})
@WebFilter("/*")
public class FilterDemo6 implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("filterdemo6执行了...");
        chain.doFilter(req, resp);
        System.out.println("filterdemo6回来了...");
    }

    public void init(FilterConfig config) throws ServletException {


    }

}
