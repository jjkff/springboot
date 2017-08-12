package cn.sierac.dao;

import cn.sierac.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Jack on 2017/7/26.
 */
@Mapper
public interface UserMapperDao {

    /**
     * 根据用户名获取用户对象
     */
     public User getUserByName(String loginName);
}
