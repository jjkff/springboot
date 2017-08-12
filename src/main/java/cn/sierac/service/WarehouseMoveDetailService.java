package cn.sierac.service;

import cn.sierac.dao.WarehouseMoveDetailDao;
import cn.sierac.entity.WarehouseMoveDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Service
public class WarehouseMoveDetailService {
    @Autowired
    private WarehouseMoveDetailDao warehouseMoveDetailDao;

    /**
     * 根据发货单据单号查找仓库调拨出库单据详细信息
     * @param warehouseMoveDetail
     * @return
     */
    public List<WarehouseMoveDetail> findWarehouseMoveDetail(WarehouseMoveDetail warehouseMoveDetail){
        return warehouseMoveDetailDao.findWarehouseMoveDetail(warehouseMoveDetail);
    }

    /**
     * 仓库调拨数据上传跟新
     * @param warehouseMoveDetail
     */
    public void update(WarehouseMoveDetail warehouseMoveDetail){
        warehouseMoveDetailDao.update(warehouseMoveDetail);
    }
}
