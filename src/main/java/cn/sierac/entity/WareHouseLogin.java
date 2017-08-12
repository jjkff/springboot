package cn.sierac.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 出库登录实体
 * Created by Jack on 2017/7/27.
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class WareHouseLogin {

    public WareHouseLogin(){}

    private static final long serialVersionUID = 1L;

    private String warehouseId;

    private String code ; // 登陆成功1，失败0

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
