package cn.sierac.dao;

import cn.sierac.entity.Dealer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 经销商出库单据下载
 * Created by Jack on 2017/7/28.
 */
@Mapper
public interface DealerMapperDao {

    /**
     *经销商出库单据下载接口
     * @param dealer
     * @return
     */
    public List<Dealer> findAll(Dealer dealer);

    /**
     * 单据状态接口
     * @param code
     * @return
     */
    public Dealer findByCode(String code);

}
