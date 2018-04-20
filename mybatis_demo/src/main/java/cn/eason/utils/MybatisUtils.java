package cn.eason.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Eason
 * @date Create in 18:00 18/04/2018
 */
public class MybatisUtils {

    static SqlSessionFactory sqlSessionFactory;

    static {
        //加载核心配置文件
        InputStream configuration = null;
        try {
            configuration = org.apache.ibatis.io.Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //创建 sql Session Factory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }


    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }


    public static SqlSession openSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
