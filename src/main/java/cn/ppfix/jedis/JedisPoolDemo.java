package cn.ppfix.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/27-14:23
 */
public class JedisPoolDemo {

   public static void main(String[] args){
       JedisPoolConfig config = new JedisPoolConfig();

       config.setMaxTotal(50);
       config.setMaxWaitMillis(30 * 1000);

       JedisPool pool = new JedisPool(config,"127.0.0.1",6379);
       Jedis jedis = null;
       try{
           jedis = pool.getResource();

           String key = "scoreboard";
           System.out.println(jedis.zrange(key,0,-1));
       }catch (Exception e){
           e.printStackTrace();
       }
       finally {

           if(null != jedis){
             pool.returnResource(jedis);
           }

           pool.close();
       }
   }
}
