package cn.ppfix.springjedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/27-21:59
 */
@Service
public class RedisService {

    @Autowired
    private ShardedJedisPool shareJedisPool;

    //回调基础函数
    private <T> T excute(Function<ShardedJedis, T> fun) {
        ShardedJedis shardedJedis = null;
        try {
            //从连接池中获取到jedis分片对象
            shardedJedis = shareJedisPool.getResource();
            return fun.callback(shardedJedis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != shardedJedis) {
                //close()方法的作用:关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
                shardedJedis.close();
            }
        }
        return null;
    }

    /**
     * set操作(没有设置生存时间,长期生存)
     *
     * @param key
     * @param value
     * @return
     */
    public String set(final String key, final String value) {
        return this.excute(new Function<ShardedJedis, String>() {
            public String callback(ShardedJedis shardedJedis) {
                return shardedJedis.set(key, value);
            }
        });
    }

    /**
     * get操作
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        return this.excute(new Function<ShardedJedis, String>() {
            public String callback(ShardedJedis shardedJedis) {
                return shardedJedis.get(key);
            }
        });
    }

    /**
     * set操作(同时设置生存时间)
     *
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public String set(final String key, final String value, final Integer expire) {
        return this.excute(new Function<ShardedJedis, String>() {
            public String callback(ShardedJedis shardedJedis) {
                return shardedJedis.setex(key, expire, value);
            }
        });
    }

    /**
     * 刷新生存时间
     *
     * @param key
     * @param Rexpire
     * @return
     */
    public Long expire(final String key, final Integer Rexpire) {
        return this.excute(new Function<ShardedJedis, Long>() {
            public Long callback(ShardedJedis shardedJedis) {
                return shardedJedis.expire(key, Rexpire);
            }
        });
    }

    /**
     * delete操作
     *
     * @param key
     * @return
     */
    public Long del(final String key) {
        return this.excute(new Function<ShardedJedis, Long>() {
            public Long callback(ShardedJedis shardedJedis) {
                return shardedJedis.del(key);
            }
        });
    }
}
