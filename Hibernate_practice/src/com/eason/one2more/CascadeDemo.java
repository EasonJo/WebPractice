package com.eason.one2more;

import cn.eason.domain.Customer;
import cn.eason.domain.LinkMan;
import cn.eason.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class CascadeDemo {

    @Test
    public void fun1() {
        Session session = HibernateUtils.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Customer customer = new Customer();
            customer.setCust_name("蒲军霖");

            LinkMan linkMan = new LinkMan();
            linkMan.setLkm_name("李1");


            LinkMan linkMan1 = new LinkMan();
            linkMan1.setLkm_name("李2");

            customer.getLinkMans().add(linkMan);
            customer.getLinkMans().add(linkMan1);
            linkMan.setCustomer(customer);
            linkMan1.setCustomer(customer);

            session.save(customer);
            session.save(linkMan);
            session.save(linkMan1);

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }


    /**
     * 级联 save_update
     */
    @Test
    public void fun1_Cascade() {
        Session session = HibernateUtils.getCurrentSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Customer eason = new Customer();
            eason.setCust_name("Eaosn");
            LinkMan fish = new LinkMan();
            fish.setLkm_name("小鱼儿");
            eason.getLinkMans().add(fish);

            //只保存 eaosn,因为 Custom 做了 sava-update 的级联,所以会自动保存小鱼儿.
            session.save(eason);

            //只保存 小鱼儿,此时小鱼儿没有关联 Customer.所以表中小鱼儿的记录外键就是 Null
            //fish.setLkm_name("小鱼儿1");
            //如果设置了 One 的一方,此时 LinkMan 作为主控方,需要配置级联属性. Cascade
            //fish.setCustomer(eason);

            session.save(fish);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }


    /**
     * 级联删除
     */
    @Test
    public void fun_Delete() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Customer customer = session.get(Customer.class, 1L);
            session.remove(customer);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }


    @Test
    public void fun_update() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            LinkMan fish = session.get(LinkMan.class, 3L);
            System.out.println(fish);

            Customer eason = session.get(Customer.class, 7L);

            System.out.println(eason);
            fish.setCustomer(eason);
            eason.getLinkMans().add(fish);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }


}
