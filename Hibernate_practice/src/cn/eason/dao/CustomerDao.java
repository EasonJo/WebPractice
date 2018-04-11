package cn.eason.dao;

import cn.eason.domain.Customer;

import java.util.List;

public interface CustomerDao {
	//保存客户
	void save(Customer c);
	//查询所有客户
	List getAll();
	//根据id获得客户
	Customer getById(Long cust_id);


}
