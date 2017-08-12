package cn.sierac.dao;

import cn.sierac.entity.DealerMove;
import cn.sierac.entity.DealerMoveHeader;
import cn.sierac.entity.DealerReceive;
import cn.sierac.entity.DealerReceiveHeader;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by pinkMan on 2017/8/4.
 */
@Mapper
public interface DealerReceiveDao {

    /**
     * 获取所有经销商收货信息
     * @param
     * @return
     */
    public List<DealerReceive> findAll(DealerReceive dealerReceive);

    /**
     *
     * @param code
     * @return
     */
    public DealerReceive findByCode(String code);

    /**
     * 跟新经销商收货数据
     * @param dealerReceiveHeader
     */
    public void update(DealerReceiveHeader dealerReceiveHeader);

    /**
     * 数据上传状态
     * @param dealerReceiveHeader
     */
    public void updateStatus(DealerReceiveHeader dealerReceiveHeader);


}
