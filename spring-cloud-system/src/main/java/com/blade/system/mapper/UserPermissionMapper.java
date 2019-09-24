package com.blade.system.mapper;

import com.blade.system.entity.UserPermission;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserPermissionMapper extends Mapper<UserPermission> {
}