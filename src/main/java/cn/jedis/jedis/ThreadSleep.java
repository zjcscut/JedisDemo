package cn.jedis.jedis;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/28-10:18
 */
public class ThreadSleep {

    public static void Sleep(){
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
