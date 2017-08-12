package cn.sierac.service;

import cn.sierac.dao.DealerMoveDataDao;
import cn.sierac.dao.DealerReceiveDataDao;
import cn.sierac.entity.DealerMoveData;
import cn.sierac.entity.DealerReceiveData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/5.
 */
@Service
public class DealerReceiveDataService {

    @Autowired
    private DealerReceiveDataDao dealerReceiveDataDao;

    /**
     * 经销商收货数据上传
     * @param dealerReceiveDataList
     */
    public void insertBatch(List<DealerReceiveData> dealerReceiveDataList){
       dealerReceiveDataDao.insertBatch(dealerReceiveDataList);
    }

}
