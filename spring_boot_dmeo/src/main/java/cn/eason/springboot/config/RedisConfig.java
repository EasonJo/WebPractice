package cn.eason.springboot.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author Eason
 * @date Create in 15:28 15/05/2018
 */
@Configuration
public class RedisConfig {


   /* @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;

    @Bean(name = "jedisCluster")
    public JedisCluster getJedisCluster() {

        // 截取集群节点
        String[] cluster = clusterNodes.split(",");
        // 创建set集合
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        // 循环数组把集群节点添加到set集合中
        for (String node : cluster) {
            String[] host = node.split(":");
            //添加集群节点
            nodes.add(new HostAndPort(host[0], Integer.parseInt(host[1])));

        }
        JedisCluster jc = new JedisCluster(nodes);

        return jc;
    }*/
}
