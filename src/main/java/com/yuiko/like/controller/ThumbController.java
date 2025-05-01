package com.yuiko.like.controller;

import com.yuiko.like.common.BaseResponse;
import com.yuiko.like.common.ResultUtils;
import com.yuiko.like.entity.dto.thumb.DoThumbRequest;
import com.yuiko.like.entity.po.Thumb;
import com.yuiko.like.service.ThumbService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thumb")
public class ThumbController {

    @Autowired
    private ThumbService thumbService;

    @PostMapping("/do")
    public BaseResponse<Boolean> doThumb(@RequestBody DoThumbRequest doThumbRequest, HttpServletRequest request) {
        thumbService.doThumb(doThumbRequest, request);
        return ResultUtils.success(true);
    }

    @PostMapping("/undo")
    public BaseResponse<Boolean> undoThumb(@RequestBody DoThumbRequest doThumbRequest, HttpServletRequest request) {
        thumbService.undoThumb(doThumbRequest, request);
        return ResultUtils.success(true);
    }

}
