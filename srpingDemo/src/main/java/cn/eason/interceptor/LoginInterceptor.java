package cn.eason.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        System.out.println("方法前 1");
        //判断用户是否登陆  如果没有登陆  重定向到登陆页面   不放行   如果登陆了  就放行了
        // URL  http://localhost:8080/springmvc-mybatis/login.action
        //URI /login.action
        String requestURI = request.getRequestURI();
        if (!requestURI.contains("/login")) {
            String username = (String) request.getSession().getAttribute("USER_SESSION");
            if (null == username) {
                response.sendRedirect(request.getContextPath() + "/login.action");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
        throws Exception {
        // TODO Auto-generated method stub
        System.out.println("方法后 1");
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
        throws Exception {
        // TODO Auto-generated method stub
        System.out.println("页面渲染后 1");

    }
}
