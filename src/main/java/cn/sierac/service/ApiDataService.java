package cn.sierac.service;

import cn.sierac.dao.ApiDataDao;
import cn.sierac.entity.ApiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack on 2017/8/7.
 */
@Service
public class ApiDataService {

    @Autowired
    private ApiDataDao apiDataDao;

    @Transactional(readOnly = false)
    public void save(ApiData apiData){
        apiDataDao.insert(apiData);
    }

}
