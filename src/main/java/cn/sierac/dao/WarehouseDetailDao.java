package cn.sierac.dao;

import cn.sierac.entity.WarehouseDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Jack on 2017/7/29.
 */
@Mapper
public interface WarehouseDetailDao {

    /**
     * 出库单据明细下载
     * @param orderCode
     * @return
     */
    public List<WarehouseDetail> findWarehouseDetail(String orderCode);
}
