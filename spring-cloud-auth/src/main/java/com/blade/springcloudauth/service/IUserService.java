package com.blade.springcloudauth.service;

import com.blade.springcloudauth.entity.Role;
import com.blade.springcloudauth.entity.User;

import java.util.List;

/**
 * @author lyq
 * @create 6/15/19
 */
public interface IUserService {

    User getUserById(String id);

    List<Role> getRolesByUserId(String userId);

}
