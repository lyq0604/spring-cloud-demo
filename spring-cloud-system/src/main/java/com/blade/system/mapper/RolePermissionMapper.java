package com.blade.system.mapper;

import com.blade.system.entity.RolePermission;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
}