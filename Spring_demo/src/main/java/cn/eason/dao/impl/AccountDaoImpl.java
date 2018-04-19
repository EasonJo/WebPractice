package cn.eason.dao.impl;

import cn.eason.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author Eason
 * @date Create in 14:23 17/04/2018
 */
@Repository("accountDao")
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Resource(name = "datasource")
    public void setDBDataSource(DataSource dbDataSource) {
        setDataSource(dbDataSource);
    }

    @Override
    public void increaseMoney(Integer id, Double money) {
        String sql = "UPDATE t_account SET money = ? WHERE id = ?";
        getJdbcTemplate().update(sql, money, id);
    }

    @Override
    public void decreaseMoney(Integer id, Double money) {

    }
}
