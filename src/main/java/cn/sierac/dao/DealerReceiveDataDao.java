package cn.sierac.dao;

import cn.sierac.entity.DealerReceiveData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/5.
 */
@Mapper
public interface DealerReceiveDataDao {

    /**
     *
     * @param dealerReceiveData
     */
    public void insertBatch(List<DealerReceiveData> dealerReceiveData);

}
