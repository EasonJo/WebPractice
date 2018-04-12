package cn.eason.query.hql;

import cn.eason.domain.Customer;
import cn.eason.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

//学习HQL语法
public class Demo {

    //基本语法
    @Test
    public void fun1() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //----------------------------------------------------
        String hql = "from Customer";//完整写法
        String hql2 = "from Customer"; //简单写法
        String hql3 = "from java.lang.Object ";

        Query query = session.createQuery(hql2);

        List list = query.list();

        System.out.println(list);
        //----------------------------------------------------
        tx.commit();
        session.close();

    }


    @Test
    //排序
    public void fun2() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //----------------------------------------------------
        String hql1 = "from  Customer order by cust_id asc";//完整写法
        String hql2 = "from  Customer order by cust_id desc";//完整写法

        Query query = session.createQuery(hql2);

        List list = query.list();

        System.out.println(list);
        //----------------------------------------------------
        tx.commit();
        session.close();

    }

    @Test
    //条件查询
    public void fun3() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //----------------------------------------------------
        String hql1 = "from  Customer where cust_id =?";//完整写法
        String hql2 = "from  Customer where cust_id = :id";//完整写法

        Query query = session.createQuery(hql2);

//		query.setParameter(0, 2l);
        query.setParameter("id", 2L);


        List list = query.list();

        System.out.println(list);
        //----------------------------------------------------
        tx.commit();
        session.close();

    }

    @Test
    //分页查询
    public void fun4() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //----------------------------------------------------
        String hql1 = "from Customer";//完整写法

        Query query = session.createQuery(hql1);

        //limit ?,?
        // (当前页数-1)*每页条数
        query.setFirstResult(2);
        query.setMaxResults(2);

        List list = query.list();

        System.out.println(list);
        //----------------------------------------------------
        tx.commit();
        session.close();

    }

    @Test
    //统计查询
    //count	计数
    //sum 	求和
    //avg	平均数
    //max
    //min
    public void fun5() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //----------------------------------------------------
        String hql1 = "select count(*) from  Customer";//完整写法
        String hql2 = "select sum(cust_id) from  Customer";//完整写法
        String hql3 = "select avg(cust_id) from  Customer";//完整写法
        String hql4 = "select max(cust_id) from  Customer";//完整写法
        String hql5 = "select min(cust_id) from  Customer";//完整写法

        Query query = session.createQuery(hql5);

        Number number = (Number) query.uniqueResult();

        System.out.println(number);
        //----------------------------------------------------
        tx.commit();
        session.close();

    }


    @Test
    //投影查询
    public void fun6() {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //----------------------------------------------------
        String hql1 = "select cust_name from Customer";
        String hql2 = "select cust_name,cust_id from Customer";
        String hql3 = "select new Customer(cust_id,cust_name) from  Customer";

        Query query = session.createQuery(hql2);

        List list = query.list();

        System.out.println(list);

        //----------------------------------------------------
        tx.commit();
        session.close();

    }

    //抓取数量
    @Test
    public void fun7() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        //----------------------------------------------------

        String hql = "from Customer";
        Query query = session.createQuery(hql);
        List<Customer> list = query.list();

        for (Customer c : list) {
            System.out.println(c.getLinkMans());
        }

        //----------------------------------------------------
        tx.commit();

    }

    @Test
    // load方法(默认):是在执行时,不发送任何sql语句.返回一个对象.使用该对象时,才执行查询.
    // 延迟加载: 仅仅获得没有使用.不会查询.在使用时才进行查询.
    // 是否对类进行延迟加载: 可以通过在class元素上配置lazy属性来控制.
    //lazy:true  加载时,不查询.使用时才查询b
    //lazy:false 加载时立即查询.
    public void fun8() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        //----------------------------------------------------

        Customer c = session.load(Customer.class, 2l);

        //----------------------------------------------------
        tx.commit();
        System.out.println(c);

    }
}
