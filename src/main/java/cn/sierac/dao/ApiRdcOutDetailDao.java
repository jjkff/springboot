package cn.sierac.dao;

import cn.sierac.entity.ApiRdcOutDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Jack on 2017/7/31.
 */
@Mapper
public interface ApiRdcOutDetailDao {
    /**
     * 更新
     * @param apiRdcOutDetail
     */
     public void update(ApiRdcOutDetail apiRdcOutDetail);

}
