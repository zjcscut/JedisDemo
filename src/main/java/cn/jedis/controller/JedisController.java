package cn.jedis.controller;

import cn.jedis.jedis.ThreadSleep;
import cn.jedis.springjedis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/28-2:13
 */
@RestController
public class JedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "test")
    public String Test() {
        try {
            redisService.set("zjc", "zjcppfix", 5);
            ThreadSleep.Sleep(); //sleep 3s
            System.out.println(redisService.get("zjc"));
            ThreadSleep.Sleep();//sleep 3s
            System.out.println(redisService.get("zjc"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
