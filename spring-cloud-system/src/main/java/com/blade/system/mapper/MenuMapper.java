package com.blade.system.mapper;

import com.blade.common.base.BaseMapper;
import com.blade.system.common.vo.MenuTreeNode;
import com.blade.system.entity.Menu;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 获取菜单树节点集合
     * @return
     */
    List<MenuTreeNode> selectMenuTreeNode();

}