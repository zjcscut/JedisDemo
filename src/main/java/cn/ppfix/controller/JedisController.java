package cn.ppfix.controller;

import cn.ppfix.springjedis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
            Thread.sleep(3);
            System.out.println(redisService.get("zjc"));

            Thread.sleep(3);

            System.out.println(redisService.get("zjc"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
