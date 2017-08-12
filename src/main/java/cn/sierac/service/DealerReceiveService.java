package cn.sierac.service;

import cn.sierac.dao.DealerMoveDao;
import cn.sierac.dao.DealerReceiveDao;
import cn.sierac.entity.DealerMove;
import cn.sierac.entity.DealerMoveHeader;
import cn.sierac.entity.DealerReceive;
import cn.sierac.entity.DealerReceiveHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/4.
 */
@Service
public class DealerReceiveService {

    @Autowired
    private DealerReceiveDao dealerReceiveDao;

    /**
     * 经销商收货
     * @param dealerReceive
     * @return
     */
    @Transactional(readOnly = true)
    public List<DealerReceive> findAll(DealerReceive dealerReceive){

        return dealerReceiveDao.findAll(dealerReceive);

    }

    /**
     * 经销商收货状态查询
     * @param code
     * @return
     */
    @Transactional(readOnly = true)
    public DealerReceive findByCode(String code){
        return dealerReceiveDao.findByCode(code);
    }


    /**
     * 经销商收货数据上传跟新
     * @param dealerReceiveHeader
     */
    public void update(DealerReceiveHeader dealerReceiveHeader){
        dealerReceiveDao.update(dealerReceiveHeader);
    }

    /**
     * 数据上传跟新
     * @param dealerReceiveHeader
     */
    public void updateStatus(DealerReceiveHeader dealerReceiveHeader){
        dealerReceiveDao.update(dealerReceiveHeader);
    }





}
