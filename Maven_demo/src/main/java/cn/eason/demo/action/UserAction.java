package cn.eason.demo.action;

import cn.eason.demo.domain.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class UserAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return customer;
    }

    public String allUsers() {

        return SUCCESS;
    }
}
