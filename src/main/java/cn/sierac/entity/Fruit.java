package cn.sierac.entity;

/**
 * Created by Jack on 2017/7/21.
 */
public class Fruit {

    /**
     * 价格
     */
    private String price;
    /**
     * 水果类型
     */
    private String type;
    /**
     * 商店id
     */
    private Integer sid ;

    /**
     * id
     */
    private Integer id;

    public Fruit() {
    }

    public Fruit(String price, String type, Integer sid, int id) {
        this.price = price;
        this.type = type;
        this.sid = sid;
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
