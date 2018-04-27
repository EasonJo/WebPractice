package cn.e3mall.content.utils;

import cn.e3mall.common.jedis.JedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Eason
 * @date Create in 17:43 26/04/2018
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext_service.xml", "classpath:applicationContext_mybatis.xml",
    "classpath:spring/applicationContext_jedis.xml"})
public class JedisTest {

    @Resource(name = "jedisClientPool")
    private JedisClient jedisClient;

    @Test
    public void testJedis() {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("name", "Eason");

        System.out.println(jedis.get("name"));

        jedis.close();
    }

    /**
     * 单机版
     */
    @Test
    public void testJedisPool() {
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        Jedis jedis = jedisPool.getResource();

        System.out.println(jedis.get("name"));
        jedis.close();
        jedisPool.close();
    }

    /**
     * 连接 jedis 集群
     */
    //@Test
    public void testJedisCluster() throws IOException {
        Set<HostAndPort> hostAndPorts = new HashSet<>();
        hostAndPorts.add(new HostAndPort("localhsot", 7001));
        hostAndPorts.add(new HostAndPort("localhsot", 7002));
        hostAndPorts.add(new HostAndPort("localhsot", 7003));
        hostAndPorts.add(new HostAndPort("localhsot", 7004));
        hostAndPorts.add(new HostAndPort("localhsot", 7005));
        hostAndPorts.add(new HostAndPort("localhsot", 7006));
        JedisCluster jedisCluster = new JedisCluster(hostAndPorts);
        //直接使用 jedisCluster 来操作jedis.
        jedisCluster.set("name", "Litle fish");
        System.out.println(jedisCluster.get("name"));
        jedisCluster.close();
    }


    @Test
    public void testJedisClient() {
        System.out.println(jedisClient.get("name"));
    }

}
