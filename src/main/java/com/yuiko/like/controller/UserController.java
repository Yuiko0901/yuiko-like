package com.yuiko.like.controller;


import com.yuiko.like.common.BaseResponse;
import com.yuiko.like.common.ResultUtils;
import com.yuiko.like.constant.UserConstant;
import com.yuiko.like.entity.po.User;
import com.yuiko.like.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public BaseResponse<User> login(String userId, HttpServletRequest request) {

        User user = userService.getById(userId);
        request.getSession().setAttribute(UserConstant.LOGIN_USER, user);
        return ResultUtils.success(user);

    }


    @GetMapping("/get/login")
    public BaseResponse<User> getLoginUser(HttpServletRequest request) {
        User loginUser = (User) request.getSession().getAttribute(UserConstant.LOGIN_USER);
        return ResultUtils.success(loginUser);
    }










}
