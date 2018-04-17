package cn.eason.dao.impl;

import cn.eason.bean.SpringUser;
import cn.eason.dao.SpringUserDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Eason
 * @date Create in 10:49 17/04/2018
 */
@Repository("springDao")
public class SpringDaoImpl extends JdbcDaoSupport implements SpringUserDao {

//    @Resource(name = "jdbcTemplate")
//    private JdbcTemplate jt;

    @Resource(name = "datasource")
    public void setDaoDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public void insert(SpringUser springUser) {
        String sql = "INSERT INTO spring_user VALUES (NULL,?,?)";
        getJdbcTemplate().update(sql, springUser.getName(), springUser.getAge());
    }

    @Override
    public void update(SpringUser springUser) {
        String sql = "UPDATE spring_user SET name = ? , age = ? WHERE id =?";
        getJdbcTemplate().update(sql, springUser.getName(), springUser.getAge(), springUser.getId());
    }

    @Override
    public SpringUser findUser(int id) {
        String sql = "SELECT * FROM spring_user WHERE id = ?";
        return getJdbcTemplate().queryForObject(sql, (resultSet, i) -> parseResult(resultSet), id);
    }

    @Override
    public int getTotalCount() {
        String sql = "SELECT count(*) FROM spring_user";
        return getJdbcTemplate().queryForObject(sql, Integer.class);
    }

    @Override
    public List<SpringUser> getAll() {
        String sql = "SELECT * FROM spring_user";
        return getJdbcTemplate().query(sql, (rs, rowNum) -> parseResult(rs));
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM spring_user WHERE id =?";
        getJdbcTemplate().update(sql, id);
    }

    private SpringUser parseResult(ResultSet rs) throws SQLException {
        SpringUser springUser = new SpringUser();
        springUser.setId(rs.getInt("id"));
        springUser.setName(rs.getString("name"));
        springUser.setAge(rs.getInt("age"));
        return springUser;
    }
}
