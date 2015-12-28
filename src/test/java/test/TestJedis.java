package test;

import cn.jedis.jedis.ThreadSleep;
import cn.jedis.springjedis.RedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/27-23:02
 */

public class TestJedis extends BaseSpringTestCase{

    @Autowired
    private RedisService redisService;

    @Test
    public void TestClient(){
        try {
            redisService.set("zjc", "zjcppfix", 5);
            ThreadSleep.Sleep(); //sleep 3s
            System.out.println(redisService.get("zjc"));
            ThreadSleep.Sleep();//sleep 3s
            System.out.println(redisService.get("zjc"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
