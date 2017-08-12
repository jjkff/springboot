package cn.sierac.dao;

import cn.sierac.entity.DealerMoveData;
import cn.sierac.entity.WarehouseMoveData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/2.
 */
@Mapper
public interface DealerMoveDataDao {

    /**
     *
     * @param dealerMoveData
     */
    public void insertBatch(List<DealerMoveData> dealerMoveData);

}
