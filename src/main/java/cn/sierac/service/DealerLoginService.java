package cn.sierac.service;

import cn.sierac.dao.DealerLoginDao;
import cn.sierac.entity.Dealer;
import cn.sierac.entity.DealerLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack on 2017/7/28.
 */
@Service
public class DealerLoginService {

    @Autowired
    private DealerLoginDao dealerLoginDao;

    @Transactional(readOnly =  true)
    public DealerLogin findDealerId(String loginName){
        return dealerLoginDao.findDealerId(loginName);
    }
}
