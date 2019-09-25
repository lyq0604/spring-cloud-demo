package com.blade.blog.service;

import com.blade.blog.domain.Blog;
import com.blade.blog.mapper.BlogMapper;
import com.blade.common.base.BaseService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
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

    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public void test() throws Exception {
        Blog blog = new Blog();
        blog.setAuthor("txTest");
        blog.setContent("测试分布式事务");
        blog.setCreateTime(new Date());
        mapper.insert(blog);
    }
}
