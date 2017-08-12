package cn.sierac.dao;

import cn.sierac.entity.CodeDataBatchReport;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Jack on 2017/8/7.
 */
@Mapper
public interface CodeDataBatchReportDao {

    public void insert(CodeDataBatchReport codeDataBatchReport);

}
