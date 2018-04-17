package cn.eason.dao;

import cn.eason.bean.SpringUser;

import java.util.List;

/**
 * @author Eason
 * @date Create in 10:46 17/04/2018
 */
public interface SpringUserDao {
    void insert(SpringUser springUser);

    void update(SpringUser springUser);

    SpringUser findUser(int id);

    int getTotalCount();

    List<SpringUser> getAll();

    void delete(int id);
}
