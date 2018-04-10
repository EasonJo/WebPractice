package com.eason.demo.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @author Eason
 */
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpServletRequest request = (HttpServletRequest) req;

        HttpServletRequest httpServletRequest = (HttpServletRequest) Proxy.newProxyInstance(getClass().getClassLoader(),
            new Class[]{HttpServletRequest.class}, (proxy, method, args) -> {
                String name = request.getMethod();
                if ("get".equals(name) && "getParameter".equals(method.getName())) {
                    String value = (String) method.invoke(request, args);
                    return new String(value.getBytes("UTF-8"), "UTF-8");
                }
                return method.invoke(request, args);
            }
        );
        chain.doFilter(httpServletRequest, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
