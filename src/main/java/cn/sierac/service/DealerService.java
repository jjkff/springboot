package cn.sierac.service;

import cn.sierac.dao.DealerMapperDao;
import cn.sierac.entity.Dealer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jack on 2017/7/27.
 */
@Service
public class DealerService {

    @Autowired
    private DealerMapperDao dealerMapperDao;

    @Transactional(readOnly = true)
    public List<Dealer> findAll(Dealer dealer){
        return dealerMapperDao.findAll(dealer);
    }

    @Transactional(readOnly = true)
    public Dealer findByCode(String code){
        return dealerMapperDao.findByCode(code);
    }

}
