package cn.sierac.dao;

import cn.sierac.entity.DealerMoveDetail;
import cn.sierac.entity.DealerReceiveDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/4.
 */
@Mapper
public interface DealerReceiveDetailDao {
    /**
     * 经销商收货详情
     * @param dealerReceiveDetail
     * @return
     */
    public List<DealerReceiveDetail> findDealerReceiveDetail(DealerReceiveDetail dealerReceiveDetail);

    public void update(DealerReceiveDetail dealerReceiveDetail);
}
