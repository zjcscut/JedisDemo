package cn.jedis.entity;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/27-16:04
 */
public class User implements java.io.Serializable{

    private Integer id;
    private String name;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
