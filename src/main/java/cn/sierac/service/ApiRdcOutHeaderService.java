package cn.sierac.service;

import cn.sierac.dao.ApiRdcOutHeaderDao;
import cn.sierac.entity.ApiRdcOutHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack on 2017/7/31.
 */
@Service
public class ApiRdcOutHeaderService {

    @Autowired
    private ApiRdcOutHeaderDao apiRdcOutHeaderDao;

    @Transactional(readOnly =  false)
    public void save(ApiRdcOutHeader apiRdcOutHeader){
         apiRdcOutHeaderDao.update(apiRdcOutHeader);
    }

}
