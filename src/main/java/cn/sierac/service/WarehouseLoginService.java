package cn.sierac.service;

import cn.sierac.dao.WarehouseLoginDao;
import cn.sierac.entity.WareHouseLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack on 2017/7/27.
 */
@Service
public class WarehouseLoginService
{
    @Autowired
    private WarehouseLoginDao apiWarehouseLoginDao;

    @Transactional(readOnly = true)
    public WareHouseLogin findWareHouseId(String name){
        return apiWarehouseLoginDao.findWareHouseId(name);
    }
}
