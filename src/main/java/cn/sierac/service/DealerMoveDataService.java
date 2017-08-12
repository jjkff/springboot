package cn.sierac.service;

import cn.sierac.dao.DealerMoveDataDao;
import cn.sierac.dao.WarehouseMoveDataDao;
import cn.sierac.entity.DealerMoveData;
import cn.sierac.entity.WarehouseMoveData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/2.
 */
@Service
public class DealerMoveDataService {

    @Autowired
    private DealerMoveDataDao dealerMoveDataDao;

    /**
     * 经销商调拨数据上传
     * @param dealerMoveDataList
     */
    public void insertBatch(List<DealerMoveData> dealerMoveDataList){
        dealerMoveDataDao.insertBatch(dealerMoveDataList);
    }

}
