package com.blade.system.base.controller;

import com.blade.common.base.BaseController;
import com.blade.system.base.domain.User;
import com.blade.system.base.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.blade.system.common.vo.UserInfoVO;


/**
 * @author lyq
 * @create 6/21/19
 */
@Api(tags = {"用户相关接口"})
@RestController
@RequestMapping("/users")
public class UserController extends BaseController<UserService,User> {

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public String login(@RequestBody User user){
        String token = service.login(user);
        return "bearer " + token;
    }

    /**
     * 获取当前用户信息，包含用户角色、权限、菜单等
     * @return
     */
    @ApiOperation(value = "获取用户信息（角色、权限、菜单）")
    @GetMapping("/info")
    public UserInfoVO getInfo(){
        UserInfoVO userInfoVO = service.getUserInfo();
        return userInfoVO;
    }
}
