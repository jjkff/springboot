package cn.sierac.dao;

import cn.sierac.entity.CodeDataUploadRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack on 2017/8/7.
 */
@Mapper
public interface CodeDataUploadRecordDao {

    public void insert(CodeDataUploadRecord codeDataUploadRecord);

}
