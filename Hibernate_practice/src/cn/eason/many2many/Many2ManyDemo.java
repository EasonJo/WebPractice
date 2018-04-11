package cn.eason.many2many;

import cn.eason.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class Many2ManyDemo {
    @Test
    public void fun() {
        User eason = new User();
        eason.setUserName("老蒲");

        User fish = new User();
        fish.setUserName("小鱼儿");

        User huzi = new User();
        huzi.setUserName("虎子");

        Role father = new Role();
        father.setRoleName("爸爸");

        Role worker = new Role();
        worker.setRoleName("开发人员");

        Role daughter = new Role();
        daughter.setRoleName("女儿");

        eason.getRoles().add(father);
        eason.getRoles().add(worker);

        huzi.getRoles().add(father);
        huzi.getRoles().add(worker);

        fish.getRoles().add(daughter);

        father.getUsers().add(eason);
        father.getUsers().add(huzi);

        worker.getUsers().add(eason);
        worker.getUsers().add(huzi);

        daughter.getUsers().add(fish);


        Session session = HibernateUtils.getCurrentSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(eason);
            session.save(huzi);
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
}
