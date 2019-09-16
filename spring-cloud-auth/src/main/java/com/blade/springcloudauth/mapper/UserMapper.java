package com.blade.springcloudauth.mapper;

import com.blade.springcloudauth.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author lyq
 */
@Repository
public interface UserMapper extends Mapper<User> {

    User getUserByUserName(String username);

}