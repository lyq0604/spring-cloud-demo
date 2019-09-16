package com.blade.blog.mapper;

import com.blade.blog.domain.Blog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface BlogMapper extends Mapper<Blog> {

    /**
     * 根据用户id删除
     * @param userId
     */
    void deleteByUserId(String userId);

}