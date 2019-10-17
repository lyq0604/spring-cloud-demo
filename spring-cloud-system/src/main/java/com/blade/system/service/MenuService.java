package com.blade.system.service;

import com.blade.common.base.BaseService;
import com.blade.common.utils.TreeUtil;
import com.blade.system.common.vo.MenuTreeNode;
import com.blade.system.common.vo.MenuVO;
import com.blade.system.entity.Menu;
import com.blade.system.entity.Operation;
import com.blade.system.mapper.MenuMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lyq
 * @create 10/16/19
 */
@Service
public class MenuService extends BaseService<MenuMapper,Menu>{

    @Autowired
    private OperationService operationService;

    /**
     * 获取菜单树
     * @return
     */
    public List<MenuTreeNode> selectMenuTree() {
        List<MenuTreeNode> menuNodeList = mapper.selectMenuTreeNode();
        List<MenuTreeNode> menus = TreeUtil.build(menuNodeList,"-1");
        return menus;
    }

    /**
     * 获取菜单及其操作按钮
     * @param id
     * @return
     */
    public MenuVO selectMenuVO(String id) {
        Menu menu = selectOneByKey(id);
        MenuVO vo = new MenuVO();
        if (menu != null) {
            List<Operation> operationList = operationService.selectListByMenuId(id);
            BeanUtils.copyProperties(menu,vo);
            vo.setOperationList(operationList);
        }
        return vo;
    }
}
