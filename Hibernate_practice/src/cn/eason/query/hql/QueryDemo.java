package cn.eason.query.hql;

import cn.eason.domain.LinkMan;
import cn.eason.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;


public class QueryDemo {


    @Test
    public void fun() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //基本查询
//        Query query = session.createQuery("from Customer ");
//        List<Customer> customers = query.list();
        //别名查询
//        Query query = session.createQuery("select c from Customer c");
//        List<Customer> customers = query.list();

//        Query query = session.createQuery("from Customer where cust_name = ?");
//        query.setParameter(0,"eason");
//        List<Customer> customers = query.list();

//        for (Customer customer : customers) {
//            System.out.println(customer);
//        }


        //分页查询
        Query query = session.createQuery("from LinkMan order by lkm_id desc");
        query.setFirstResult(5);
        query.setMaxResults(5);
        List<LinkMan> list = query.list();

        for (LinkMan linkMan : list) {
            System.out.println(linkMan);
        }


        tx.commit();
    }
}
