package com.blade.blog.service;

import com.blade.blog.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    BlogMapper blogMapper;

    /**
     * 根据主键删除
     * @param id
     */
    public void deleteByKey(String id) {
        blogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据用户id删除博客
     * @param userId
     */
    public void deleteByUserId(String userId) {
        blogMapper.deleteByUserId(userId);
    }
}
