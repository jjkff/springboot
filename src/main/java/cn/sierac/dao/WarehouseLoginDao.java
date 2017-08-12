package cn.sierac.dao;

import cn.sierac.entity.WareHouseLogin;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采集器登录
 * Created by Jack on 2017/7/27.
 */
@Mapper
public interface WarehouseLoginDao {

    /**
     * 根据登录名获取仓库id
     * @param loginName
     * @return
     */
    public WareHouseLogin findWareHouseId(String loginName);

}
