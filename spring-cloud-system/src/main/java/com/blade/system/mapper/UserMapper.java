package com.blade.system.mapper;

import com.blade.system.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User getUserByUserName(String username);

}