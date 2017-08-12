package cn.sierac.service;

import cn.sierac.dao.DealerReceiveDetailDao;
import cn.sierac.entity.DealerReceiveDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/4.
 */
@Service
public class DealerReceiveDetailService {
    @Autowired
    private DealerReceiveDetailDao dealerReceiveDetailDao;

    /**
     * 根据发货单据单号查找经销商售后单据详细信息s
     * @param dealerReceiveDetail
     * @return
     */
    public List<DealerReceiveDetail> findDealerReceiveDetail(DealerReceiveDetail dealerReceiveDetail){
        return dealerReceiveDetailDao.findDealerReceiveDetail(dealerReceiveDetail);
    }

    /**
     * 经销商收货数据上传跟新
     * @param dealerReceiveDetail
     */
    public void update(DealerReceiveDetail dealerReceiveDetail){
        dealerReceiveDetailDao.update(dealerReceiveDetail);
    }
}
