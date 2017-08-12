package cn.sierac.service;

import cn.sierac.dao.ApiRdcOutDataDao;
import cn.sierac.entity.ApiRdcOutData;
import cn.sierac.entity.ApiRdcOutHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jack on 2017/7/31.
 */
@Service
public class ApiRdcOutDataService {

    @Autowired
    private ApiRdcOutDataDao apiRdcOutDataDao;

    @Transactional(readOnly = false)
    public void saveBatch(List<ApiRdcOutData> apiRdcOutDatas){
        apiRdcOutDataDao.insertBatch(apiRdcOutDatas);
    }
}
