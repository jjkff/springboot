package cn.sierac.service;

import cn.sierac.dao.ApiRdcOutDetailDao;
import cn.sierac.entity.ApiRdcOutDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack on 2017/7/31.
 */
@Service
public class ApiRdcOutDetailService {

//    public void update(ApiRdcOutDetail apiRdcOutDetail);

    @Autowired
    private ApiRdcOutDetailDao apiRdcOutDetailDao;

    @Transactional(readOnly = false)
    public void save(ApiRdcOutDetail apiRdcOutDetail){
        apiRdcOutDetailDao.update(apiRdcOutDetail);
    }

}
