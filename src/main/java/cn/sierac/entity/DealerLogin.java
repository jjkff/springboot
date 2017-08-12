package cn.sierac.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 经销商登录实体
 * Created by Jack on 2017/7/27.
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class DealerLogin {

    public DealerLogin(){}

    private String id ;

    private String dealerId;

    private String code ; // 登陆成功1，失败0


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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
