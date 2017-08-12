package cn.sierac.service;

import cn.sierac.dao.DealerScanCheckDao;
import cn.sierac.entity.DealerScanCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jack on 2017/8/1.
 */
@Service
public class DealerScanCheckServcie {

    @Autowired
    private DealerScanCheckDao dealerScanCheckDao;

    @Transactional(readOnly = true)
    public List<DealerScanCheck> findAll(String code){
        return  dealerScanCheckDao.findAll(code);
    }

}
