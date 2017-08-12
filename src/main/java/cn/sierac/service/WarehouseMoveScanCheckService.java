package cn.sierac.service;

import cn.sierac.dao.WarehouseMoveScanCheckDao;
import cn.sierac.entity.WarehouseMoveScanCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Service
public class WarehouseMoveScanCheckService {
    @Autowired
    private WarehouseMoveScanCheckDao warehouseMoveScanCheckDao;

    /**
     * 仓库调拨扫描代码
     * @param warehouseMoveScanCheck
     * @return
     */
    public List<WarehouseMoveScanCheck> findWarehouseMoveDetail(WarehouseMoveScanCheck warehouseMoveScanCheck){
        return warehouseMoveScanCheckDao.findWarehouseMoveScanCheck(warehouseMoveScanCheck);
    }
}
