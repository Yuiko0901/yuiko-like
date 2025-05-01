package com.yuiko.like.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuiko.like.constant.UserConstant;
import com.yuiko.like.entity.po.User;
import com.yuiko.like.service.UserService;
import com.yuiko.like.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

/**
* @author Yui
* @description 针对表【user】的数据库操作Service实现
* @createDate 2025-05-01 12:29:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public User getLoginUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(UserConstant.LOGIN_USER);
    }
}




