package cn.sierac.dao;

import cn.sierac.entity.ApiDealerDetail;
import cn.sierac.entity.ApiRdcOutDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Jack on 2017/7/31.
 */
@Mapper
public interface ApiDealerDetailDao {
    /**
     * 更新
     * @param apiRdcOutDetail
     */
     public void update(ApiDealerDetail apiRdcOutDetail);

}
