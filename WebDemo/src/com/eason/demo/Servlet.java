package com.eason.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = "/demo")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("name", "Eason");


        String ab = (String) getServletContext().getInitParameter("UserName");

        response.getWriter().write("Hello. this is a demo");
        response.getWriter().write("</br>");
        response.getWriter().write("ServletContext.Attribute " + ab);

    }

}
