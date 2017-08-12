package cn.sierac.dao;

import cn.sierac.entity.WarehouseOutScanCheck;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Jack on 2017/7/29.
 */
@Mapper
public interface WarehouseOutScanCheckDao {
     public List<WarehouseOutScanCheck> findAll(String code);
}
