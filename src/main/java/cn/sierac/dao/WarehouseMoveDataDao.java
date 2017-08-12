package cn.sierac.dao;

import cn.sierac.entity.WarehouseMoveData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by pinkMan on 2017/7/31.
 */
@Mapper
public interface WarehouseMoveDataDao {

    /**
     *
     * @param warehouseMoveData
     */
    public void insertBatch(List<WarehouseMoveData> warehouseMoveData);

}
