package cn.sierac.dao;

import cn.sierac.entity.RdcOutHeader;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Jack on 2017/7/28.
 */
@Mapper
public interface RdcOutHeaderDao {

    /**
     * 获取所有仓库信息
     * @param rdcOutHeader
     * @return
     */
    public List<RdcOutHeader> findAll(RdcOutHeader rdcOutHeader);

    public RdcOutHeader findByCode(String code);

}
