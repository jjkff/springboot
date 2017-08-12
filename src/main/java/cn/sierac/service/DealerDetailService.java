package cn.sierac.service;

import cn.sierac.dao.DealerDetailDao;
import cn.sierac.entity.DealerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jack on 2017/8/1.
 */
@Service
public class DealerDetailService {

    @Autowired
    private DealerDetailDao dealerDetailDao;

    @Transactional(readOnly = true)
    public List<DealerDetail> findDealerDetail(DealerDetail dealerDetail){
        return dealerDetailDao.findDealerDetail(dealerDetail);
    }
}
