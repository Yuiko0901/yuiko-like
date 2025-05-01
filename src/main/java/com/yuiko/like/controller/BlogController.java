package com.yuiko.like.controller;


import com.yuiko.like.common.BaseResponse;
import com.yuiko.like.common.ResultUtils;
import com.yuiko.like.entity.po.Blog;
import com.yuiko.like.entity.vo.BlogVO;
import com.yuiko.like.service.BlogService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;


    @GetMapping("/get")
    public BaseResponse<BlogVO> getBlog(long blogId, HttpServletRequest request ) {
        BlogVO blogVO = blogService.getBlogVOById(blogId, request);
        return ResultUtils.success(blogVO);
    }

    @GetMapping("/list")
    public BaseResponse<List<BlogVO>> list(HttpServletRequest request) {
        List<Blog> blogList = blogService.list();
        List<BlogVO> blogVOList = blogService.getBlogVOList(blogList, request);
        return ResultUtils.success(blogVOList);
    }





}
