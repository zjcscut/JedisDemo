package cn.jedis.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/27-16:05
 */
public class JsonUtil {

    /**
     * map转化为Json字符串
     * @param map
     * @return
     */
   public static String ObjectToJson(final  Map<String,Object> map){
        if(null != map){
          return JSON.toJSONString(map);
        }else
            return null;
    }

    /**
     * 实体类转化为Object Json
     * @param object
     * @return
     */
    public static Object EntityToJason(final  Object object){
        if(object != null){
          return JSON.toJSON(object);
        }else
            return null;
    }

    /**
     * Object Json转化为实体类
     * @param object
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T JsonToEntity(final Object object ,final Class<T> clazz){
        if(null != object && null != clazz){
            JSONObject jsonObject = (JSONObject) object;
            try{
                 return JSON.toJavaObject(jsonObject,clazz);
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }else
            return null;
    }
}
