package cn.sierac.service;

import cn.sierac.dao.CodeDataImportErrorDao;
import cn.sierac.entity.CodeDataImportError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jack on 2017/8/7.
 */
@Service
public class CodeDataImportErrorService {

    @Autowired
    private CodeDataImportErrorDao codeDataImportErrorDao;

    @Transactional(readOnly =  false)
    public void saveBatch(List<CodeDataImportError> codeDataImportErrors){
          codeDataImportErrorDao.insertBatch(codeDataImportErrors);
    }

}
