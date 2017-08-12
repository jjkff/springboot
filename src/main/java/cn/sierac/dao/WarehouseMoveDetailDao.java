package cn.sierac.dao;

import cn.sierac.entity.WarehouseMoveDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Mapper
public interface WarehouseMoveDetailDao {
    /**
     *   获取仓库调拨出库单据详细信息
     * @param warehouseMoveDetail
     * @return
     */
    public List<WarehouseMoveDetail> findWarehouseMoveDetail(WarehouseMoveDetail warehouseMoveDetail);

    public void update(WarehouseMoveDetail warehouseMoveDetail);
}
