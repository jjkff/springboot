package cn.sierac.dao;

import cn.sierac.entity.ApiRdcOutData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Jack on 2017/7/31.
 */
@Mapper
public interface ApiRdcOutDataDao {

    public void insertBatch(List<ApiRdcOutData> apiRdcOutDatas);

}
