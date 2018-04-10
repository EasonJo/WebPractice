package com.itheima.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * redis 连接池
 */
public class JedisPoolUtils {

    private static JedisPool pool = null;

    static {

        //加载配置文件
        InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获得池子对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最大闲置个数
        poolConfig.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));
        //最小闲置个数
        poolConfig.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));
        //最大连接数
        poolConfig.setMaxTotal(Integer.parseInt(pro.get("redis.maxTotal").toString()));
        pool = new JedisPool(poolConfig, pro.getProperty("redis.url"), Integer.parseInt(pro.get("redis.port").toString()));
    }

    /**
     * 获得jedis资源的方法
     */
    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void main(String[] args) {
        Jedis jedis = getJedis();
        jedis.set("username","pujl");
        jedis.set("age","32");

        System.out.println(jedis.get("username"));
        System.out.println(jedis.get("age"));
    }
}
