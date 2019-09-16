package com.blade.blog.controller;

import com.blade.blog.service.BlogService;
import com.blade.common.response.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    /**
     * 根据主键删除
     * @return
     */
    @DeleteMapping("/{id}")
    public BaseResult deleteByKey(@PathVariable String id){
        blogService.deleteByKey(id);
        return new BaseResult().success();
    }

    /**
     * 根据用户id删除博客
     * @return
     */
    @DeleteMapping("/user/{userId}")
    public BaseResult deleteByUserId(@PathVariable String userId){
        blogService.deleteByUserId(userId);
        return new BaseResult().success();

    }

}
