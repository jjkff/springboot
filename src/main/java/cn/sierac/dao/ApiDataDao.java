package cn.sierac.dao;

import cn.sierac.entity.ApiData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Jack on 2017/8/7.
 */
@Mapper
public interface ApiDataDao {

    @Transactional(readOnly = false)
    public void insert(ApiData apiData);

}
