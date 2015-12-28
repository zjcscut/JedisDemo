package test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/28-10:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-cfg.xml" , "classpath:spring-redis.xml"})
public class BaseSpringTestCase {

}
