package com.flyer.springboot.rest.web;

import com.flyer.springboot.rest.AbstractMVCTest;
import com.flyer.springboot.rest.common.BaseResponse;
import com.flyer.springboot.rest.data.UserData;
import com.flyer.springboot.rest.domain.User;
import com.flyer.springboot.rest.service.UserService;
import com.vip.vjtools.vjkit.mapper.JsonMapper;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;

import javax.inject.Inject;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by jianying.li on 2018/9/15.
 */
public class UserControllerTest extends AbstractMVCTest {

    @Mock
    private UserService userService;

    @Inject
    @InjectMocks
    private UserController userController;

    @Test
    public void addUser() throws Exception {

        User postUser = UserData.generatOne(false);

        when(userService.saveUser(any(User.class))).thenReturn(UserData.generatOne(true));

        this.mockMvc.perform(post("/user/add").contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(JsonMapper.INSTANCE.toJson(postUser))).andExpect(status().isOk())
            .andDo(print()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("code").value(BaseResponse.CODE_SUCCESS));
    }

    @Test
    public void getUser() throws Exception {

        when(userService.findUserById(anyLong())).thenReturn(UserData.generatOne(true));

        this.mockMvc.perform(get("/user/get").param("id", "1")).andExpect(status().isOk())
            .andDo(print()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("code").value(BaseResponse.CODE_SUCCESS));
    }

    @Test
    public void editUser() throws Exception {
        User editUser = UserData.generatOne(true);

        when(userService.updateUser(any(User.class))).thenReturn(1);

        this.mockMvc.perform(post("/user/edit").contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(JsonMapper.INSTANCE.toJson(editUser))).andExpect(status().isOk())
            .andDo(print()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("code").value(BaseResponse.CODE_SUCCESS));
    }

    @Test
    public void removeUser() throws Exception {
        User removeUser = UserData.generatOne(true);

        when(userService.removeUser(removeUser.getId())).thenReturn(1);

        this.mockMvc.perform(get("/user/remove").param("id", String.valueOf(removeUser.getId())))
            .andExpect(status().isOk()).andDo(print())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("code").value(BaseResponse.CODE_SUCCESS));
    }

}
