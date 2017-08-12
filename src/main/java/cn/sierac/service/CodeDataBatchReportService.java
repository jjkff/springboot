package cn.sierac.service;

import cn.sierac.dao.CodeDataBatchReportDao;
import cn.sierac.entity.CodeDataBatchReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack on 2017/8/7.
 */
@Service
public class CodeDataBatchReportService {

    @Autowired
    private CodeDataBatchReportDao codeDataBatchReportDao;

    @Transactional(readOnly = false)
    public void save(CodeDataBatchReport codeDataBatchReport){
        codeDataBatchReportDao.insert(codeDataBatchReport);
    }
}
