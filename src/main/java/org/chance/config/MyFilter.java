package org.chance.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * Created by wqg on 2016/3/23.
 */

@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("执行过滤操作");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.debug("过滤器销毁");
    }
}
