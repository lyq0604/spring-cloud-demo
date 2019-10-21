package com.blade.system.base.mapper;

import com.blade.common.base.BaseMapper;
import com.blade.system.common.vo.MenuTreeNode;
import com.blade.system.base.domain.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 获取菜单树节点集合
     * @return
     */
    List<MenuTreeNode> selectMenuTreeNode();

}