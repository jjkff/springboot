package cn.sierac.dao;

import cn.sierac.entity.DealerDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Jack on 2017/8/1.
 */
@Mapper
public interface DealerDetailDao {

    public List<DealerDetail> findDealerDetail(DealerDetail dealerDetail);

}
