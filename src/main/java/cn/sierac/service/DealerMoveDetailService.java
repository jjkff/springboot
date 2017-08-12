package cn.sierac.service;

import cn.sierac.dao.DealerMoveDetailDao;
import cn.sierac.entity.DealerMoveDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/2.
 */
@Service
public class DealerMoveDetailService {
    @Autowired
    private DealerMoveDetailDao dealerMoveDetailDao;

    /**
     * 根据发货单据单号查找经销商调拨出库单据详细信息
     * @param dealerMoveDetail
     * @return
     */
    public List<DealerMoveDetail> findDealerMoveDetail(DealerMoveDetail dealerMoveDetail){
        return dealerMoveDetailDao.findDealerMoveDetail(dealerMoveDetail);
    }

    /**
     * 经销商调拨数据上传跟新
     * @param dealerMoveDetail
     */
    public void update(DealerMoveDetail dealerMoveDetail){
        dealerMoveDetailDao.update(dealerMoveDetail);
    }
}
