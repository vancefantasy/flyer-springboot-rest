package com.flyer.springboot.rest.web;

import com.flyer.springboot.rest.common.BaseController;
import com.flyer.springboot.rest.common.BaseResponse;
import com.flyer.springboot.rest.common.exception.BizException;
import com.flyer.springboot.rest.constant.ErrorEnum;
import com.flyer.springboot.rest.domain.User;
import com.flyer.springboot.rest.service.UserService;
import com.flyer.springboot.rest.web.req.SaveOrUpdateUser;
import com.vip.vjtools.vjkit.collection.MapUtil;
import jodd.bean.BeanCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by jianying.li on 2018/9/16.
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "add")
    public BaseResponse addUser(@RequestBody @Valid SaveOrUpdateUser saveOrUpdateUserReq,
        BindingResult result) {
        checkJSR303(result);
        User user = new User();
        BeanCopy.beans(saveOrUpdateUserReq, user).copy();
        user = userService.saveUser(user);
        return BaseResponse.ok(MapUtil.newHashMap("id", user.getId())).build();
    }

    @GetMapping(value = "remove")
    public BaseResponse removeUser(Long id) {
        if (id == null) {
            BizException.throwOut(ErrorEnum.PARAMETER_ILLEGAL);
        }
        userService.removeUser(id);
        return BaseResponse.ok(MapUtil.newHashMap("id", id)).build();
    }

    @PostMapping(value = "edit")
    public BaseResponse editUser(@RequestBody @Valid SaveOrUpdateUser saveOrUpdateUserReq,
        BindingResult result) {
        checkJSR303(result);
        User user = new User();
        BeanCopy.beans(saveOrUpdateUserReq, user).copy();
        userService.updateUser(user);
        return BaseResponse.ok(MapUtil.newHashMap("id", user.getId())).build();
    }

    @GetMapping(value = "get")
    public BaseResponse getUser(Long id) {
        User user = userService.findUserById(id);
        return BaseResponse.ok(user).build();
    }
}
