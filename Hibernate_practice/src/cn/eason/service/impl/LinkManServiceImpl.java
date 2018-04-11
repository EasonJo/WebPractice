package cn.eason.service.impl;


import cn.eason.dao.CustomerDao;
import cn.eason.dao.LinkManDao;
import cn.eason.dao.impl.CustomerDaoImpl;
import cn.eason.dao.impl.LinkManDaoImpl;
import cn.eason.domain.Customer;
import cn.eason.domain.LinkMan;
import cn.eason.service.LinkManService;
import cn.eason.utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {

	private CustomerDao cd =new CustomerDaoImpl();
	private LinkManDao lmd = new LinkManDaoImpl();
	@Override
    public void save(LinkMan lm) {
		//打开事务
		HibernateUtils.getCurrentSession().beginTransaction();
		
		try {
			//1 根据客户id获得客户对象
			Long cust_id = lm.getCust_id();
			Customer c = cd.getById(cust_id);
			//2 将客户放入LinkMan中表达关系
			lm.setCustomer(c);
			//3 保存LinkMan
			lmd.save(lm);
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			HibernateUtils.getCurrentSession().getTransaction().rollback();
		}
		//提交事务
		HibernateUtils.getCurrentSession().getTransaction().commit();
		
	}

}
