package cn.sierac.dao;

import cn.sierac.entity.ApiDealer;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Jack on 2017/8/1.
 */
@Mapper
public interface ApiDealerDao {

    /**
     * 更新
     * @param apiDealer
     */
    public void update(ApiDealer apiDealer);
}
