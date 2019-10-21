package com.blade.system.mapper;


import com.blade.common.base.BaseMapper;
import com.blade.system.entity.Operation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lyq
 */
@Repository
public interface OperationMapper extends BaseMapper<Operation> {

    /**
     * 根据菜单id获取按钮列表
     * @param menuId
     * @return
     */
    List<Operation> selectByMenuId(String menuId);

}