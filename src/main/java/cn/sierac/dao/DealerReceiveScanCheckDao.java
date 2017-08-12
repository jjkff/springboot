package cn.sierac.dao;

import cn.sierac.entity.DealerReceiveScanCheck;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/4.
 */
@Mapper
public interface DealerReceiveScanCheckDao {
    /**
     * 获取经销商收货单据扫描代码信息
     * @param dealerReceiveScanCheck
     * @return
     */
    public List<DealerReceiveScanCheck> findDealerReceiveScanCheck(DealerReceiveScanCheck dealerReceiveScanCheck);
}
