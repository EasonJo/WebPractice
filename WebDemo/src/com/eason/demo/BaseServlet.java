package com.eason.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Eason
 */
@WebServlet(name = "BaseServlet")
public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String methodName = req.getParameter("method");
            if (methodName == null) {
                methodName = "execute";
            }

            //反射当前类的 execute 方法,传递两个参数.
            Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //获取当前的路径
            String jspPath = (String) method.invoke(this, req, resp);

            if (jspPath != null) {
                req.getRequestDispatcher(jspPath).forward(req, resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String execute(HttpServletRequest req, HttpServletResponse reqp) throws ServletException, IOException{
        return "";
    }
}
