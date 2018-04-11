package cn.eason.dao.impl;

import cn.eason.dao.CustomerDao;
import cn.eason.domain.Customer;
import cn.eason.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void save(Customer c) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(c);
    }

    @Override
    public List<Customer> getAll() {
        Session session = HibernateUtils.getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        return criteria.list();
    }

    @Override
    public Customer getById(Long cust_id) {
        Session session = HibernateUtils.getCurrentSession();
        return session.get(Customer.class, cust_id);
    }

}
