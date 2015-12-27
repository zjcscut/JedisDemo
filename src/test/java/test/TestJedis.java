package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springjedis.RedisService;


/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/27-23:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class TestJedis {

    @Autowired
    private RedisService redisService;

    @Test
    public void TestClient(){
        try {
            redisService.set("zjc","zjcppfix",5);
            Thread.sleep(3);
            System.out.println(redisService.get("zjc"));

            Thread.sleep(3);

            System.out.println(redisService.get("zjc"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
