package com.flyer.springboot.rest.dao;

import com.flyer.springboot.rest.AbstractTest;
import com.flyer.springboot.rest.DBUtils;
import com.flyer.springboot.rest.data.UserData;
import com.flyer.springboot.rest.domain.User;
import com.vip.vjtools.vjkit.mapper.JsonMapper;
import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by jianying.li on 2018/9/16.
 */
public class UserDaoTest extends AbstractTest {

    @Autowired
    private UserDao userDao;

    @AfterClass
    public static void clean() {
        DBUtils.truncateTable("user");
    }

    @Test
    public void saveUser() throws Exception {
        User user = UserData.generatOne(false);
        userDao.saveUser(user);
        assertNotNull("user id is null", user.getId());
        log.warn("saveUser run res : {}", JsonMapper.INSTANCE.toJson(user));
    }

    @Test
    public void removeUser() throws Exception {
        User user = UserData.generatOne(false);
        userDao.saveUser(user);
        assertNotNull("user id is null", user.getId());
        userDao.removeUser(user.getId());
        User nullUser = userDao.findUserById(user.getId());
        assertNull("user is remove", nullUser);
    }

    @Test
    public void updateUser() throws Exception {
        User user = UserData.generatOne(false);
        userDao.saveUser(user);
        User updateUser = UserData.generatOne(false);
        updateUser.setId(user.getId());
        userDao.updateUser(updateUser);
        User selectUser = userDao.findUserById(user.getId());
        assertEquals("must equals", selectUser.getLanguage(), updateUser.getLanguage());
    }

    @Test
    public void findUserById() throws Exception {
        User user = UserData.generatOne(false);
        userDao.saveUser(user);

        User selectUser = userDao.findUserById(user.getId());
        assertNotNull("userId should not be null", selectUser.getId());
        assertNotNull("user should not be null", selectUser);
        log.warn("findUserById res : {}", JsonMapper.INSTANCE.toJson(user));
    }

}
