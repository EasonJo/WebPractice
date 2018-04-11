package cn.eason.service.impl;

import cn.eason.dao.CustomerDao;
import cn.eason.dao.impl.CustomerDaoImpl;
import cn.eason.domain.Customer;
import cn.eason.service.CustomerService;
import cn.eason.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public void save(Customer c) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            //调用Dao保存客户
            customerDao.save(c);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Override
    public List<Customer> getAll() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = null;
        List<Customer> list = null;
        try {
            tx = session.beginTransaction();
            list = customerDao.getAll();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return list;
    }

}
