package cn.sierac.dao;

import cn.sierac.entity.DealerMoveDetail;
import cn.sierac.entity.WarehouseMoveDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by pinkMan on 2017/7/31.
 */
@Mapper
public interface DealerMoveDetailDao {
    /**
     * 经销商出库详情
     * @param dealerMoveDetail
     * @return
     */
    public List<DealerMoveDetail> findDealerMoveDetail(DealerMoveDetail dealerMoveDetail);

    public void update(DealerMoveDetail dealerMoveDetail);
}
