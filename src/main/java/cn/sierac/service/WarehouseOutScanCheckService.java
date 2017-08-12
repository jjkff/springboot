package cn.sierac.service;

import cn.sierac.dao.WarehouseOutScanCheckDao;
import cn.sierac.entity.WarehouseOutScanCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jack on 2017/7/29.
 */
@Service
public class WarehouseOutScanCheckService {


    @Autowired
    private WarehouseOutScanCheckDao warehouseOutScanCheckDao;

    @Transactional(readOnly =  true)
    public List<WarehouseOutScanCheck> findAll(String code){
        return  warehouseOutScanCheckDao.findAll(code);
    }
}
