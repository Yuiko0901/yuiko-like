package com.yuiko.like.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuiko.like.entity.po.Blog;
import com.yuiko.like.entity.po.Thumb;
import com.yuiko.like.entity.po.User;
import com.yuiko.like.entity.vo.BlogVO;
import com.yuiko.like.service.BlogService;
import com.yuiko.like.mapper.BlogMapper;
import com.yuiko.like.service.ThumbService;
import com.yuiko.like.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
* @author Yui
* @description 针对表【blog】的数据库操作Service实现
* @createDate 2025-05-01 12:29:58
*/
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
    implements BlogService{


    @Autowired
    private UserService userService;

    @Lazy
    @Autowired
    private ThumbService thumbService;

    @Override
    public BlogVO getBlogVOById(long id, HttpServletRequest request) {
        Blog blog = getById(id);
        User loginUser = userService.getLoginUser(request);


        return this.getBlogVO(blog,loginUser);
    }


    @Override
    public BlogVO getBlogVO(Blog blog, User loginUser) {
        BlogVO blogVO = new BlogVO();
        BeanUtil.copyProperties(blog, blogVO);

        Thumb thumb = thumbService.lambdaQuery()
                .eq(Thumb::getUserId, loginUser.getId())
                .eq(Thumb::getBlogId, blog.getId())
                .one();
        blogVO.setHasThumb(thumb != null);

        return blogVO;
    }


    @Override
    public List<BlogVO> getBlogVOList(List<Blog> blogList, HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        Map<Long, Boolean> blogIdHasThumbMap = new HashMap<>();
        if (ObjUtil.isNotEmpty(loginUser)) {
            Set<Long> blogIdSet = blogList.stream().map(Blog::getId).collect(Collectors.toSet());
            // 获取点赞
            List<Thumb> thumbList = thumbService.lambdaQuery()
                    .eq(Thumb::getUserId, loginUser.getId())
                    .in(Thumb::getBlogId, blogIdSet)
                    .list();

            thumbList.forEach(blogThumb -> blogIdHasThumbMap.put(blogThumb.getBlogId(), true));
        }

        return blogList.stream()
                .map(blog -> {
                    BlogVO blogVO = BeanUtil.copyProperties(blog, BlogVO.class);
                    blogVO.setHasThumb(blogIdHasThumbMap.get(blog.getId()));
                    return blogVO;
                })
                .toList();
    }


}




