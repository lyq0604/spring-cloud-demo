package com.blade.system.mapper;

import com.blade.system.entity.RolePermission;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface RolePermissionMapper extends Mapper<RolePermission>{
}