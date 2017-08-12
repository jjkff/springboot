package cn.sierac.service;

import cn.sierac.dao.WarehouseDetailDao;
import cn.sierac.entity.WarehouseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jack on 2017/7/29.
 */
@Service
public class WarehouseDetailService
{

    @Autowired
    private WarehouseDetailDao warehouseDetailDao;

    @Transactional(readOnly =  true)
    public List<WarehouseDetail> findWarehouseDetail(String orderCode){
        return warehouseDetailDao.findWarehouseDetail(orderCode);
    }


}
