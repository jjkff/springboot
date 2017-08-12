package cn.sierac.dao;

import cn.sierac.entity.ApiDealerData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Jack on 2017/8/1.
 */
@Mapper
public interface ApiDealerDataDao {

     public void insertBatch(List<ApiDealerData> apiDealerDatas);

}
