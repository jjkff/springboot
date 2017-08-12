package cn.sierac.service;

import cn.sierac.dao.CodeDataUploadRecordDao;
import cn.sierac.entity.CodeDataUploadRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack on 2017/8/7.
 */
@Service
public class CodeDataUploadRecordService {

    @Autowired
    private CodeDataUploadRecordDao codeDataUploadRecordDao;

    @Transactional(readOnly = false)
    public void save(CodeDataUploadRecord codeDataUploadRecord){
        codeDataUploadRecordDao.insert(codeDataUploadRecord);
    }
}
