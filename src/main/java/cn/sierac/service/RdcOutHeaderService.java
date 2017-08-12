package cn.sierac.service;

import cn.sierac.dao.RdcOutHeaderDao;
import cn.sierac.entity.RdcOutHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jack on 2017/7/28.
 */
@Service
public class RdcOutHeaderService {

    @Autowired
    private RdcOutHeaderDao rdcOutHeaderDao;

    @Transactional(readOnly = true)
    public List<RdcOutHeader> findAll(RdcOutHeader rdcOutHeader){
        return  rdcOutHeaderDao.findAll(rdcOutHeader);
    }

    @Transactional(readOnly = true)
    public RdcOutHeader findByCode(String code){
        return rdcOutHeaderDao.findByCode(code);
    }
}
