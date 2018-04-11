package cn.eason.web;

import cn.eason.domain.Customer;
import cn.eason.service.CustomerService;
import cn.eason.service.impl.CustomerServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Eason
 */
@WebServlet(name = "AddCustomerServlet")
public class AddCustomerServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer c = new Customer();
        try {
            BeanUtils.populate(c, request.getParameterMap());

            CustomerService service = new CustomerServiceImpl();
            service.save(c);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //通知浏览器重定向到列表页
        response.sendRedirect(request.getContextPath()+"/ListCustomerServlet");
    }
}
