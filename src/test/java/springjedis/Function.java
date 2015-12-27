package springjedis;

/**
 * created by IntelliJ IDEA
 * Jedis回调函数
 * @author zjc
 * @time 2015/12/27-21:58
 */
public interface Function<E,T> {

    public T callback(E e);
}
