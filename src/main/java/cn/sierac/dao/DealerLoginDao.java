package cn.sierac.dao;

import cn.sierac.entity.DealerLogin;
import cn.sierac.entity.WareHouseLogin;
import org.apache.ibatis.annotations.Mapper;

/**
 * 经销商登录
 * Created by Jack on 2017/7/27.
 */
@Mapper
public interface DealerLoginDao {

    /**
     * 根据登录名获取经销商id
     * @param loginName
     * @return
     */
    public DealerLogin findDealerId(String loginName);

}
