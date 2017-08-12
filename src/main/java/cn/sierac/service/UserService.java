package cn.sierac.service;

import cn.sierac.dao.UserMapperDao;
import cn.sierac.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack on 2017/7/26.
 */
@Service
public class UserService {

    @Autowired
    private UserMapperDao userMapperDao;

    @Transactional(readOnly = true)
    public User getUserByName(String loginName){
         return userMapperDao.getUserByName(loginName);
    }
}
