package com.blade.blog.controller;

import com.blade.blog.domain.Blog;
import com.blade.blog.service.BlogService;
import com.blade.common.base.BaseController;
import com.blade.common.response.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController extends BaseController<BlogService,Blog>{

    /**
     * 根据用户id删除博客
     * @return
     */
    @GetMapping("/user/{userId}")
    public BaseResult deleteByUserId(@PathVariable String userId){
        List<Blog> list = service.selectByUserId(userId);
        return new BaseResult().success(list);

    }

    @DeleteMapping("/test")
    public BaseResult test(){
        service.test();
        return new BaseResult().success();
    }

}
