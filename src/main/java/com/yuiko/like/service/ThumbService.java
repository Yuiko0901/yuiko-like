package com.yuiko.like.service;

import com.yuiko.like.entity.dto.thumb.DoThumbRequest;
import com.yuiko.like.entity.po.Thumb;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;

/**
* @author Yui
* @description 针对表【thumb】的数据库操作Service
* @createDate 2025-05-01 12:29:58
*/
public interface ThumbService extends IService<Thumb> {
    /**
     * 点赞
     * @param doThumbRequest
     * @param request
     * @return {@link Boolean }
     */
    Boolean doThumb(DoThumbRequest doThumbRequest, HttpServletRequest request);


    Boolean undoThumb(DoThumbRequest doThumbRequest, HttpServletRequest request);

}
