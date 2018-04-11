package cn.eason.dao.impl;

import cn.eason.dao.LinkManDao;
import cn.eason.domain.LinkMan;
import cn.eason.utils.HibernateUtils;
import org.hibernate.Session;


public class LinkManDaoImpl implements LinkManDao {

    @Override
    public void save(LinkMan lm) {
        //1 获得session
        Session session = HibernateUtils.getCurrentSession();
        session.save(lm);
    }

}
