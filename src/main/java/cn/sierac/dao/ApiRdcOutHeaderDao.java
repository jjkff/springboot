package cn.sierac.dao;

import cn.sierac.entity.ApiRdcOutHeader;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * Created by Jack on 2017/7/31.
 */
@Mapper
public interface ApiRdcOutHeaderDao {

    /**
     * 更新
     * @param apiRdcOutHeader
     */
    public void update(ApiRdcOutHeader apiRdcOutHeader);

}
