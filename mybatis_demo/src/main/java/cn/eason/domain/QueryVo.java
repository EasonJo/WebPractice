package cn.eason.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 封装查询条件
 *
 * @author Eason
 * @date Create in 10:16 19/04/2018
 */
public class QueryVo implements Serializable {
    private User user;

    public List<Integer> idsList;
    public Integer[] ids;


    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public List<Integer> getIdsList() {
        return idsList;
    }

    public void setIdsList(List<Integer> idsList) {
        this.idsList = idsList;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
