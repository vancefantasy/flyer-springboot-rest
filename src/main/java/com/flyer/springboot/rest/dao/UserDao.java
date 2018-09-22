package com.flyer.springboot.rest.dao;

import com.flyer.springboot.rest.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by jianying.li on 2018/9/16.
 */
@Repository
public interface UserDao {

    Integer saveUser(User user);

    Integer removeUser(Long id);

    Integer updateUser(User user);

    User findUserById(Long id);
}
