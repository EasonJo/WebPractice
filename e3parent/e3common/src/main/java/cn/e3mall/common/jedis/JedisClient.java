package cn.e3mall.common.jedis;

import java.util.List;

/**
 * jedis 通用方法封装
 */
public interface JedisClient {

    /**
     * 设置属性
     */
    String set(String key, String value);

    /**
     * 获取属性
     */
    String get(String key);

    /**
     * 判断 key 是否存在
     */
    Boolean exists(String key);

    /**
     * 设置 Key 的过期时间,倒计时方式
     *
     * @param key     key
     * @param seconds 过期时间,单位是秒
     * @return 剩余时间
     */
    Long expire(String key, int seconds);

    /**
     * 获取某个 key 是否还在存在,并返回剩余的时间.参考 {@link #expire(String, int)}
     *
     * @return key 过期的时间
     */
    Long ttl(String key);

    /**
     * 自增 key
     *
     * @param key
     * @return
     */
    Long incr(String key);


    /**
     * 设置 Key 关联的(K,V)中对应的 Field 值,类似于 HashMap<String,Map>结构.存入到其中 map 对应的值.
     * <pre>
     *    HashMap<String,Map> map ....
     *    HashMap<String, String> hash = map.get(key);
     *    hash.put(field)
     * </pre>
     *
     * @param key   key
     * @param field hash 的 key
     * @param value hash 中对应的key 的 value
     */
    Long hset(String key, String field, String value);

    /**
     * 获取 Key 关联的(K,V)中对应的 Field 值,类似于先从 HashMap<String,Map>结构.
     * <blockquote>
     * <pre>
     *    HashMap<String,Map> map ....
     *    HashMap<String, String> hash = map.get(key);
     *    String value  = hash.get(field)
     * </pre>
     * </blockquote>
     *
     * @param key   key
     * @param field key in hash
     * @return value in hash
     */
    String hget(String key, String field);

    /**
     * 删除 Key--> Hash-->中的键值对
     *
     * @param key   key in redis item
     * @param field key In hash
     * @return
     */
    Long hdel(String key, String... field);

    /**
     * 判断 Key 对应的 Hash 中 key 为 field 的键值对是否存在
     *
     * @param key   key in redis item
     * @param field key in hash
     * @return
     */
    Boolean hexists(String key, String field);

    /**
     * 获取 key 对应的 Hash 的所有value
     *
     * @param key key in redis item
     * @return
     */
    List<String> hvals(String key);

    /**
     * 删除某个 Key
     *
     * @param key
     * @return
     */
    Long del(String key);
}
