package cn.jedis.jedis;

import redis.clients.jedis.Jedis;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/27-14:20
 */
public class SimpleJedisDemo {

    public static void main(String[] args){
         Jedis jedis = new Jedis("127.0.0.1",6379);

        jedis.set("zjc","Hello Jedis!");

        System.out.println(jedis.get("zjc"));

        jedis.close();
    }
}
