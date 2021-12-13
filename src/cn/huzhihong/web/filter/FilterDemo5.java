package cn.huzhihong.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/user/*")
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD) //只有转发访问时过滤器才执行
@WebFilter(value = "/*",dispatcherTypes ={ DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo5 implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("filterdemo5...");
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {


    }

}
