package cn.sierac.service;

import cn.sierac.dao.ApiDealerDetailDao;
import cn.sierac.entity.ApiDealerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack on 2017/8/1.
 */
@Service
public class ApiDealerDetailService {

    @Autowired
    private ApiDealerDetailDao apiDealerDetailDao;

    @Transactional(readOnly = false)
    public void save(ApiDealerDetail apiRdcOutDetail ){
        apiDealerDetailDao.update(apiRdcOutDetail);
    }
}
