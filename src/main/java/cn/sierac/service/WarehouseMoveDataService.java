package cn.sierac.service;

import cn.sierac.dao.WarehouseMoveDao;
import cn.sierac.dao.WarehouseMoveDataDao;
import cn.sierac.entity.WarehouseMove;
import cn.sierac.entity.WarehouseMoveData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/1.
 */
@Service
public class WarehouseMoveDataService {

    @Autowired
    private WarehouseMoveDataDao warehouseMoveDataDao;

    /**
     * 仓库调拨数据上传
     * @param warehouseMoveDataList
     */
    public void insertBatch(List<WarehouseMoveData> warehouseMoveDataList){
        warehouseMoveDataDao.insertBatch(warehouseMoveDataList);
    }

}
