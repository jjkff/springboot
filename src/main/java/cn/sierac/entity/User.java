package cn.sierac.entity;

import cn.sierac.utils.UuidUtils;

import java.util.UUID;

/**
 * 用户实体
 * Created by Jack on 2017/7/26.
 */
public class User {

    /**
     * id
     */
    private String id ;

    /**
     * 用户名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;



    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
