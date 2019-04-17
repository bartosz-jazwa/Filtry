package com.jazwa;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Logger;

@WebFilter(urlPatterns = {"/index.jsp"})
public class BaseFilter implements Filter {
    private static final Logger FILTER_LOGGER
            = Logger.getLogger(BaseFilter.class.getName());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        FILTER_LOGGER.info(req.getRequestURI());

        Enumeration<String> headers = req.getHeaderNames();
        //Collections.list(headers).stream()
        while(headers.hasMoreElements()){
            FILTER_LOGGER.info(headers.nextElement());
        }
        response.setCharacterEncoding("ISO-8859-1");

        //FILTER_LOGGER.info(req.getParameter("name"));
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
