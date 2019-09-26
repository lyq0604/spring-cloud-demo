package com.blade.system.mapper;

import com.blade.system.entity.Role;
import com.blade.system.entity.UserRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lyq
 */
@Repository
public interface UserRoleMapper extends Mapper<UserRole>{

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    List<Role> getRolesByUserId(String userId);

}