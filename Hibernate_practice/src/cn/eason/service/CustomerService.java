package cn.eason.service;

import cn.eason.domain.Customer;

import java.util.List;

public interface CustomerService {
    //保存客户
    void save(Customer c);

    //获得所有客户
    List<Customer> getAll();

}
