package com.blade.system.mapper;

import com.blade.system.entity.UserRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lyq
 */
@Repository
public interface UserRoleMapper extends Mapper<UserRole>{
}