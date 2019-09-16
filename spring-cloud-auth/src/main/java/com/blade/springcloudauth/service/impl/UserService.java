package com.blade.springcloudauth.service.impl;

import com.blade.springcloudauth.entity.User;
import com.blade.springcloudauth.mapper.UserMapper;
import com.blade.springcloudauth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lyq
 * @create 6/15/19
 */
@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
