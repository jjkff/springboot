package cn.sierac.service;

import cn.sierac.dao.ApiDealerDataDao;
import cn.sierac.entity.ApiDealerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jack on 2017/8/1.
 */
@Service
public class ApiDealerDataService {

    @Autowired
    private ApiDealerDataDao apiDealerDataDao;

    @Transactional(readOnly = false)
    public void saveBatch(List<ApiDealerData> apiDealerData){

        apiDealerDataDao.insertBatch(apiDealerData);

    }

}
