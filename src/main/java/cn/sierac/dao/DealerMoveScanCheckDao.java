package cn.sierac.dao;

import cn.sierac.entity.DealerMoveScanCheck;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/2.
 */
@Mapper
public interface DealerMoveScanCheckDao {
    /**
     * 获取经销商调拨出库单据扫描代码信息
     * @param dealerMoveScanCheck
     * @return
     */
    public List<DealerMoveScanCheck> findDealerMoveScanCheck(DealerMoveScanCheck dealerMoveScanCheck);
}
