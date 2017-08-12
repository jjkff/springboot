package cn.sierac.service;

import cn.sierac.dao.DealerMoveScanCheckDao;
import cn.sierac.dao.WarehouseMoveScanCheckDao;
import cn.sierac.entity.DealerMoveScanCheck;
import cn.sierac.entity.WarehouseMoveScanCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/2.
 */
@Service
public class DealerMoveScanCheckService {
    @Autowired
    private DealerMoveScanCheckDao dealerMoveScanCheckDao;

    /**
     * 经销商调拨扫描代码
     * @param dealerMoveScanCheck
     * @return
     */
    public List<DealerMoveScanCheck> findDealerMoveDetail(DealerMoveScanCheck dealerMoveScanCheck){
        return dealerMoveScanCheckDao.findDealerMoveScanCheck(dealerMoveScanCheck);
    }
}
