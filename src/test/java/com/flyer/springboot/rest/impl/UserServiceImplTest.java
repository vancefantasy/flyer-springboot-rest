package com.flyer.springboot.rest.impl;

import com.flyer.springboot.rest.AbstractTest;
import com.flyer.springboot.rest.dao.UserDao;
import com.flyer.springboot.rest.data.UserData;
import com.flyer.springboot.rest.domain.User;
import com.flyer.springboot.rest.service.UserService;
import com.flyer.springboot.rest.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Created by jianying.li on 2018/9/16.
 */
public class UserServiceImplTest extends AbstractTest {

    @MockBean
    private UserDao userDao;

    @InjectMocks
    @Inject
    private UserServiceImpl userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveUser() throws Exception {
        when(userDao.saveUser(any(User.class))).thenReturn(1);
        assertThat(userService.saveUser(UserData.generatOne(true)), is(notNullValue()));
        verify(userDao, times(1)).saveUser(any(User.class));
    }

    @Test
    public void removeUser() throws Exception {
        when(userDao.removeUser(anyLong())).thenReturn(1);
        assertThat(userService.removeUser(anyLong()), is(1));
        verify(userDao, times(1)).removeUser(anyLong());
    }

    @Test
    public void updateUser() throws Exception {
        when(userDao.updateUser(any(User.class))).thenReturn(1);
        assertThat(userService.updateUser(UserData.generatOne(true)), is(1));
        verify(userDao, times(1)).updateUser(any(User.class));
    }

    @Test
    public void findUserById() throws Exception {
        when(userDao.findUserById(anyLong())).thenReturn(UserData.generatOne(true));
        assertThat(userService.findUserById(anyLong()), is(notNullValue()));
        verify(userDao, times(1)).findUserById(anyLong());
    }

}
