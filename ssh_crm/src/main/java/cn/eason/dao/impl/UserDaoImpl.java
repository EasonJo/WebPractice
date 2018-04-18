package cn.eason.dao.impl;

import cn.eason.dao.UserDao;
import cn.eason.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eason
 * @date Create in 13:04 18/04/2018
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Resource(name = "sessionFactory")
    public void setHibernateSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    public User findUser(String uName) {

        /*User user = getHibernateTemplate().execute(new HibernateCallback<User>() {
            @Override
            public User doInHibernate(Session session) throws HibernateException {
                String sql = "from user where user_code = ?";
                Query  query = session.createQuery(sql);
                query.setParameter(0,uName);
                return (User) query.uniqueResult();
            }
        });
        return user;*/

        //Criteria 离线查询
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        detachedCriteria.add(Restrictions.eq("user_code", uName));
        List<User> list = (List<User>) getHibernateTemplate().findByCriteria(detachedCriteria);

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }

    }

    @Override
    public void saveUser(User user) {
        getHibernateTemplate().save(user);
    }
}
