package com.blade.system.controller;

import com.blade.common.response.BaseResult;
import com.blade.system.common.dtos.UserLoginDTO;
import com.blade.system.entity.User;
import com.blade.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lyq
 * @create 6/21/19
 */
@Api(tags = {"用户相关接口"})
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Value("${testKey}")
    private String test;

    @ApiOperation(value = "新增用户实体")
    @ApiParam(name = "user", value = "插入的用户实体")
    @PostMapping("/add")
    public BaseResult create(@RequestBody User user) {
        userService.createUser(user);
        return new BaseResult().success();
    }

    @ApiOperation(value = "根据主键删除用户实体")
    @ApiImplicitParam(name = "id", value = "用户记录主键", paramType = "path", required = true, dataType = "String")
    @DeleteMapping("/{id}")
    @PreAuthorize("ROLE_ADMIN")
    public BaseResult deleteByKey(@PathVariable String id) {
        userService.deleteById(id);
        return new BaseResult().success();
    }

    @ApiOperation(value = "根据主键更新用户实体")
    @ApiParam(name = "user", value = "要更新的用户实体")
    @PutMapping("/update")
    public BaseResult updateByKey(@RequestBody User user) {
        userService.updateById(user);
        return new BaseResult().success();
    }

    @ApiOperation(value = "查询用户列表")
    @GetMapping("/list")
    public BaseResult list() {
        List<User> list = userService.selectList();
        return new BaseResult().success(list);
    }

    @ApiOperation(value = "根据主键获取用户实体")
    @ApiImplicitParam(name = "id", value = "用户实体主键", paramType = "path", required = true, dataType = "String")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('{authority=ROLE_TEST}')")
    public BaseResult listOne(@PathVariable String id) {
        User user = userService.selectByKey(id);
        return new BaseResult().success(user);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public BaseResult login(@RequestBody User user){
        UserLoginDTO dto = userService.login(user);
        return new BaseResult().success(dto);
    }

    @GetMapping("/test")
    public BaseResult test(){
        return new BaseResult().success(test);
    }

}
