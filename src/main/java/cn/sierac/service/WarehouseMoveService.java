package cn.sierac.service;

import cn.sierac.dao.WarehouseMoveDao;
import cn.sierac.entity.WarehouseMove;
import cn.sierac.entity.WarehouseMoveDetail;
import cn.sierac.entity.WarehouseMoveHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pinkman on 2017/7/29.
 */
@Service
public class WarehouseMoveService {

    @Autowired
    private WarehouseMoveDao warehouseMoveDao;

    /**
     * 仓库调拨
     * @param warehouseMove
     * @return
     */
    @Transactional(readOnly = true)
    public List<WarehouseMove> findAll(WarehouseMove warehouseMove){

        return warehouseMoveDao.findAll(warehouseMove);

    }

    /**
     * 仓库调拨状态查询
     * @param code
     * @return
     */
    @Transactional(readOnly = true)
    public WarehouseMove findByCode(String code){
        return warehouseMoveDao.findByCode(code);
    }

    /**
     * 仓库调拨数据上传跟新
     * @param warehouseMoveHeader
     */
    public void update(WarehouseMoveHeader warehouseMoveHeader){
        warehouseMoveDao.update(warehouseMoveHeader);
    }

    /**
     * 数据上传跟新
     * @param warehouseMoveHeader
     */
    public void updateStatus(WarehouseMoveHeader warehouseMoveHeader){
        warehouseMoveDao.update(warehouseMoveHeader);
    }


}
