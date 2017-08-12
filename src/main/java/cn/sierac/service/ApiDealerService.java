package cn.sierac.service;

import cn.sierac.dao.ApiDealerDao;
import cn.sierac.entity.ApiDealer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack on 2017/8/1.
 */
@Service
public class ApiDealerService
{
    @Autowired
    private ApiDealerDao apiDealerDao;

    @Transactional(readOnly = false)
    public void save(ApiDealer apiDealer){
        apiDealerDao.update(apiDealer);
    }
}
