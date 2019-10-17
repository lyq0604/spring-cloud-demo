package com.blade.system.controller;

import com.blade.common.base.BaseController;
import com.blade.system.common.vo.MenuTreeNode;
import com.blade.system.common.vo.MenuVO;
import com.blade.system.entity.Menu;
import com.blade.system.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lyq
 * @create 10/16/19
 */
@RestController
@RequestMapping("/menus")
@ApiOperation(value = "菜单管理相关接口")
public class MenuController extends BaseController<MenuService,Menu>{

    @GetMapping("/tree")
    public List<MenuTreeNode> selectMenuTree(){
        return service.selectMenuTree();
    }

    @GetMapping("/vo/{id}")
    public MenuVO selectMenuVO(@PathVariable String id){
        return service.selectMenuVO(id);
    }

    @DeleteMapping("/batchDelete")
    public boolean deleteByIds(@RequestBody List<String> idList){
        System.out.println(idList);
        return false;
    }
}
