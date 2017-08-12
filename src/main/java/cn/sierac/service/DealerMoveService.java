package cn.sierac.service;

import cn.sierac.dao.DealerMoveDao;
import cn.sierac.dao.WarehouseMoveDao;
import cn.sierac.entity.DealerMove;
import cn.sierac.entity.DealerMoveHeader;
import cn.sierac.entity.WarehouseMove;
import cn.sierac.entity.WarehouseMoveHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/2.
 */
@Service
public class DealerMoveService {

    @Autowired
    private DealerMoveDao dealerMoveDao;

    /**
     * 经销商调拨
     * @param dealerMove
     * @return
     */
    @Transactional(readOnly = true)
    public List<DealerMove> findAll(DealerMove dealerMove){

        return dealerMoveDao.findAll(dealerMove);

    }

    /**
     * 经销商调拨状态查询
     * @param code
     * @return
     */
    @Transactional(readOnly = true)
    public DealerMove findByCode(String code){
        return dealerMoveDao.findByCode(code);
    }


    /**
     * 经销商调拨数据上传跟新
     * @param dealerMoveHeader
     */
    public void update(DealerMoveHeader dealerMoveHeader){
        dealerMoveDao.update(dealerMoveHeader);
    }

    /**
     * 数据上传跟新
     * @param dealerMoveHeader
     */
    public void updateStatus(DealerMoveHeader dealerMoveHeader){
        dealerMoveDao.update(dealerMoveHeader);
    }


}
