package com.blade.system.base.service;

import com.blade.common.base.BaseService;
import com.blade.system.base.domain.Operation;
import com.blade.system.base.mapper.OperationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyq
 * @create 10/17/19
 */
@Service
public class OperationService extends BaseService<OperationMapper, Operation>{

    /**
     * 根据菜单ID获取按钮列表
     * @param menuId
     * @return
     */
    public List<Operation> selectListByMenuId(String menuId){
        return mapper.selectByMenuId(menuId);
    }

}
