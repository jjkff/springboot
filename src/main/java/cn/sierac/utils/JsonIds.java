package cn.sierac.utils;

/**
 * 登录返回的JOSN包装类
 * Created by Jack on 2017/7/28.
 */
public class JsonIds {
    /**
     * 仓库id
     */
    private String warehouseId ;
    /**
     * 经销商id
     */
    private String dealerId;
    /**
     * 是否登录成功：0:失败   1:成功
     */
    private String code ;

    public JsonIds(){}

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
