package cn.sierac.service;

import cn.sierac.dao.DealerMoveScanCheckDao;
import cn.sierac.dao.DealerReceiveScanCheckDao;
import cn.sierac.entity.DealerMoveScanCheck;
import cn.sierac.entity.DealerReceiveScanCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/4.
 */
@Service
public class DealerReceiveScanCheckService {
    @Autowired
    private DealerReceiveScanCheckDao dealerReceiveScanCheckDao;

    /**
     * 经销商收货扫描代码
     * @param dealerReceiveScanCheck
     * @return
     */
    public List<DealerReceiveScanCheck> findDealerReceiveDetail(DealerReceiveScanCheck dealerReceiveScanCheck){
        return dealerReceiveScanCheckDao.findDealerReceiveScanCheck(dealerReceiveScanCheck);
    }
}
