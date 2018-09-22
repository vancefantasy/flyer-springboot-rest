package com.flyer.springboot.rest.service;

import com.flyer.springboot.rest.domain.User;

/**
 * Created by jianying.li on 2018/9/16.
 */
public interface UserService {

    User saveUser(User user);

    Integer removeUser(Long id);

    Integer updateUser(User user);

    User findUserById(Long id);

}
