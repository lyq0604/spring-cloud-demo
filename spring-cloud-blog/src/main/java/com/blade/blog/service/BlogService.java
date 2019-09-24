package com.blade.blog.service;

import com.blade.blog.domain.Blog;
import com.blade.blog.mapper.BlogMapper;
import com.blade.common.base.BaseService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService extends BaseService<BlogMapper,Blog>{

    /**
     * 根据用户id获取文章列表
     * @param userId
     * @return
     */
    public List<Blog> selectByUserId(String userId) {
        return mapper.select(new Blog(userId));
    }

    @Transactional
    @LcnTransaction
    public void test() {
        mapper.deleteByUserId("2");
    }
}
