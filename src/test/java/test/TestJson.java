package test;

import cn.jedis.entity.User;
import cn.jedis.util.JsonUtil;
import org.junit.Test;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/27-16:12
 */
public class TestJson {

    @Test
    public void JSONtest(){
        User user = new User();
        user.setId(1);
        user.setName("zjc");
        Object object = JsonUtil.EntityToJason(user);
        System.out.println("json : " + object);

        User newUser = JsonUtil.JsonToEntity(object,User.class);

        System.out.println("json转回User对象 :" +newUser.getName());
    }
}
