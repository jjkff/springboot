package cn.sierac.dao;

import cn.sierac.entity.WarehouseMoveScanCheck;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Mapper
public interface WarehouseMoveScanCheckDao {
    /**
     * 获取仓库调拨出库单据扫描代码信息
     * @param warehouseMoveScanCheck
     * @return
     */
    public List<WarehouseMoveScanCheck> findWarehouseMoveScanCheck(WarehouseMoveScanCheck warehouseMoveScanCheck);
}
