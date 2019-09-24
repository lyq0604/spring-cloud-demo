package com.blade.system.controller;

import com.blade.common.base.BaseController;
import com.blade.common.response.BaseResult;
import com.blade.system.common.dtos.UserLoginDTO;
import com.blade.system.entity.User;
import com.blade.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


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
    public BaseResult login(@RequestBody User user){
        String token = service.login(user);
        return new BaseResult().success(token);
    }

    @GetMapping("/testTx")
    public BaseResult test(){
        service.test();
        return new BaseResult().success();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/test1")
    public BaseResult test1(){
        return new BaseResult().success();
    }

}
