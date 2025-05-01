package com.yuiko.like.service;

import com.yuiko.like.entity.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;

/**
* @author Yui
* @description 针对表【user】的数据库操作Service
* @createDate 2025-05-01 12:29:58
*/
public interface UserService extends IService<User> {

    User getLoginUser(HttpServletRequest request);

}
