package cn.sierac.dao;

import cn.sierac.entity.CodeData;
import org.apache.ibatis.annotations.Mapper;
import org.aspectj.apache.bcel.classfile.Code;

import java.util.List;
import java.util.Map;

/**
 * Created by Jack on 2017/7/31.
 */
@Mapper
public interface CodeDataDao
{

     public void updateAll(CodeData codeData);

     public List<CodeData> findByParentCode(CodeData codeData);

     public void updateByParentCode(Map<String,Object> map);

     public void insert(CodeData codeData);

     public void insertBatch(List<CodeData> codeData);

     public CodeData findByCode(String code);

}
