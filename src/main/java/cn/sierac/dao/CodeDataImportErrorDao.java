package cn.sierac.dao;

import cn.sierac.entity.CodeDataImportError;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Jack on 2017/8/7.
 */
@Mapper
public interface CodeDataImportErrorDao {

    public CodeDataImportError get(String id) ;

    public List<CodeDataImportError> findList(CodeDataImportError codeDataImportError);

    public void insertBatch(List<CodeDataImportError> codeDataImportError);


}
