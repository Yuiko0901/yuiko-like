package com.yuiko.like.service;

import com.yuiko.like.entity.po.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuiko.like.entity.po.User;
import com.yuiko.like.entity.vo.BlogVO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
* @author Yui
* @description 针对表【blog】的数据库操作Service
* @createDate 2025-05-01 12:29:58
*/
public interface BlogService extends IService<Blog> {


    BlogVO getBlogVOById(long id, HttpServletRequest request);


    BlogVO getBlogVO(Blog blog, User loginUser);


    List<BlogVO> getBlogVOList(List<Blog> blogList, HttpServletRequest request);




}
