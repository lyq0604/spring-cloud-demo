package com.blade.springcloudauth.auth;

import com.blade.springcloudauth.entity.Role;
import com.blade.springcloudauth.entity.User;
import com.blade.springcloudauth.mapper.UserMapper;
import com.blade.springcloudauth.mapper.UserRoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyq
 * @create 6/18/19
 */
@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.getUserByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<Role> roleList = userRoleMapper.getUserRoleByUserId(user.getId());

        AuthUser authUser = new AuthUser();
        BeanUtils.copyProperties(user, authUser);
        authUser.setRoles(roleList);

        return authUser;
    }
}
