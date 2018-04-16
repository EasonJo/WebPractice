package cn.itheima.service.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.dao.impl.CustomerDaoImpl;
import cn.itheima.domain.Customer;
import cn.itheima.service.CustomerService;
import cn.itheima.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public void save(Customer c) {
        Session session = HibernateUtils.getCurrentSession();
        //打开事务
        Transaction tx = session.beginTransaction();
        //调用Dao保存客户
        try {
            customerDao.save(c);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        //关闭事务
        tx.commit();
    }

    @Override
    public List<Customer> getAll() {
        Session session = HibernateUtils.getCurrentSession();
        //打开事务
        Transaction tx = session.beginTransaction();

        List<Customer> list = customerDao.getAll();


        //关闭事务
        tx.commit();
        return list;
    }

    @Override
    public List<Customer> getAll(DetachedCriteria dc) {
        Session session = HibernateUtils.getCurrentSession();
        //打开事务
        Transaction tx = session.beginTransaction();

        List<Customer> list = customerDao.getAll(dc);


        //关闭事务
        tx.commit();
        return list;
    }

}