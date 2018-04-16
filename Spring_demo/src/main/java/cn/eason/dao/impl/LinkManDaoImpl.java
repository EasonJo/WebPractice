package cn.eason.dao.impl;

import cn.eason.dao.LinkManDao;
import org.springframework.stereotype.Repository;

/**
 * @author Eason
 */
@Repository("linkManDao")
public class LinkManDaoImpl implements LinkManDao {
    @Override
    public void create() {
        System.out.println("create LinkManDao");
    }

    @Override
    public void readLinkMan() {
        System.out.println("读取联系人");
    }

    @Override
    public void updateLinkMan() {
        System.out.println("更新联系人");
    }

    @Override
    public void deleteLinkMan() {
        System.out.println("删除联系人");
    }
}
