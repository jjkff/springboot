package cn.sierac.dao;

import cn.sierac.entity.DealerMove;
import cn.sierac.entity.DealerMoveHeader;
import cn.sierac.entity.WarehouseMove;
import cn.sierac.entity.WarehouseMoveHeader;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/2.
 */
@Mapper
public interface DealerMoveDao {

    /**
     * 获取所有经销商调拨信息
     * @param
     * @return
     */
    public List<DealerMove> findAll(DealerMove dealerMove);

    /**
     *
     * @param code
     * @return
     */
    public DealerMove findByCode(String code);

    /**
     * 跟新经销商调拨数据
     * @param dealerMoveHeader
     */
    public void update(DealerMoveHeader dealerMoveHeader);

    /**
     * 数据上传状态
     * @param dealerMoveHeader
     */
    public void updateStatus(DealerMoveHeader dealerMoveHeader);


}
