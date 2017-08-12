package cn.sierac.entity;

/**
 * Created by Jack on 2017/7/21.
 */
public class Shop  {

    /**
     * id
     */
    private Integer id ;
    /**
     * 商店名称
     */
    private String sName;
    /**
     * 商店地址
     */
    private String sAddress;

    public Shop() {
    }

    public Shop(Integer id, String sName, String sAddress) {
        this.id = id;
        this.sName = sName;
        this.sAddress = sAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }
}
