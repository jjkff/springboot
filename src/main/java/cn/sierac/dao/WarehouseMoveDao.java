package cn.sierac.dao;

import cn.sierac.entity.WarehouseMove;
import cn.sierac.entity.WarehouseMoveDetail;
import cn.sierac.entity.WarehouseMoveHeader;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by pinkMan on 2017/7/29.
 */
@Mapper
public interface WarehouseMoveDao {

    /**
     * 获取所有仓库调拨信息
     * @param
     * @return
     */
    public List<WarehouseMove> findAll(WarehouseMove warehouseMove);

    /**
     *
     * @param code
     * @return
     */
    public WarehouseMove findByCode(String code);

    /**
     * 跟新仓库调拨数据
     * @param warehouseMoveHeader
     */
    public void update(WarehouseMoveHeader warehouseMoveHeader);

    /**
     * 数据上传状态
     * @param warehouseMoveHeader
     */
    public void updateStatus(WarehouseMoveHeader warehouseMoveHeader);
}
