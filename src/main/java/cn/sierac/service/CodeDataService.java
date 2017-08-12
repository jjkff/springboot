package cn.sierac.service;

import cn.sierac.dao.CodeDataDao;
import cn.sierac.entity.CodeData;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Jack on 2017/7/31.
 */
@Service
public class CodeDataService {

    @Autowired
    private CodeDataDao codeDataDao;

    @Transactional(readOnly = false)
    public void updateAll(CodeData codeData){
        codeDataDao.updateAll(codeData);
    }

    @Transactional(readOnly = true)
    public List<CodeData> findByParentCode(CodeData codeData){
        return codeDataDao.findByParentCode(codeData);
    }

    @Transactional(readOnly = false)
    public void updateByParentCode(Map<String,Object> map){
        codeDataDao.updateByParentCode(map);
    }

    @Transactional(readOnly = false)
    public void save(CodeData codeData){
        codeDataDao.insert(codeData);
    }

    @Transactional(readOnly = false)
    public void saveBatch(List<CodeData> codeDatas){
        codeDataDao.insertBatch(codeDatas);
    }

    @Transactional(readOnly = false)
    public CodeData findByCode(String code){
        return codeDataDao.findByCode(code);
    }

}
