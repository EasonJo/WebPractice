package cn.eason.api;

import cn.eason.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Demo {

    @Test
    public void fun1() {
        //配置加载类
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Customer c = new Customer();
        c.setCust_name("百度");
        c.setCust_mobile("18611729965");
        c.setCust_level("1");

        session.save(c);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
