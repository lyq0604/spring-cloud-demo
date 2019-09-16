package com.blade.springcloudauth.mapper;

import com.blade.springcloudauth.entity.Role;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface RoleMapper extends Mapper<Role> {
}