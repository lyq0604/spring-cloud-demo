package com.blade.system.base.mapper;

import com.blade.common.base.BaseMapper;
import com.blade.system.base.domain.Menu;
import com.blade.system.base.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lyq
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User getUserByUserName(String username);

    /**
     * 根据用户id获取用户权限
     * @param userId
     * @return
     */
    List<String> getPermissionsByUserId(String userId);

    /**
     * 根据用户id获取菜单列表
     * @param userId
     * @return
     */
    List<Menu> getMenuByUserId(String userId);
}