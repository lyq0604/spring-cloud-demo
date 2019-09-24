package com.blade.system.mapper;

import com.blade.system.entity.Operation;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface OperationMapper extends Mapper<Operation>{
}