package cn.eason.service.impl;

import cn.eason.dao.CustomerDao;
import cn.eason.dao.impl.CustomerDaoImpl;
import cn.eason.domain.Customer;
import cn.eason.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public void save(Customer c) {
		//调用Dao保存客户
		customerDao .save(c);
	}

}
