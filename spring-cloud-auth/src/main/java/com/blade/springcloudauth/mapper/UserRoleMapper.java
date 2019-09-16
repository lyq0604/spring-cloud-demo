package com.blade.springcloudauth.mapper;

import com.blade.springcloudauth.entity.Role;
import com.blade.springcloudauth.entity.UserRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserRoleMapper extends Mapper<UserRole> {

    /**
     * 根据用户id获取角色列表
     *
     * @param id
     * @return
     */
    List<Role> getUserRoleByUserId(String id);

}