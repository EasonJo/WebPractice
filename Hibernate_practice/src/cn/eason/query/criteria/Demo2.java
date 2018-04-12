package cn.eason.query.criteria;

import cn.eason.domain.Customer;
import cn.eason.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

//学习离线Criteria
public class Demo2 {

    @Test
    public void fun1() {
        //Service/web层
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);

        dc.add(Restrictions.idEq(6l));//拼装条件(全部与普通Criteria一致)

        //----------------------------------------------------
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //----------------------------------------------------
        Criteria c = dc.getExecutableCriteria(session);

        List list = c.list();

        System.out.println(list);
        //----------------------------------------------------
        tx.commit();
        session.close();

    }

}
