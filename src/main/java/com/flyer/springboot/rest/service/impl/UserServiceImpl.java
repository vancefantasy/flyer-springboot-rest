package com.flyer.springboot.rest.service.impl;

import com.flyer.springboot.rest.common.exception.BizException;
import com.flyer.springboot.rest.constant.ErrorEnum;
import com.flyer.springboot.rest.dao.UserDao;
import com.flyer.springboot.rest.domain.User;
import com.flyer.springboot.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jianying.li on 2018/9/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User saveUser(User user) {
        int result = userDao.saveUser(user);
        if (result == 0) {
            BizException.throwOut(ErrorEnum.DB_FAIL);
        }
        return user;
    }

    @Override
    public Integer updateUser(User user) {
        int result = userDao.updateUser(user);
        if (result == 0) {
            throw new BizException(ErrorEnum.DB_FAIL);
        }
        return result;
    }

    @Override
    public Integer removeUser(Long id) {
        int result = userDao.removeUser(id);
        if (result == 0) {
            throw new BizException(ErrorEnum.DB_FAIL);
        }
        return result;
    }

    @Override
    public User findUserById(Long id) {
        User user = userDao.findUserById(id);
        if (user == null) {
            throw new BizException(ErrorEnum.NOT_FOUND);
        }
        return user;
    }

}
