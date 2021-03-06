package com.blade.system.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @author lyq
 * @create 9/26/19
 */
@Data
public class UserInfoVO {

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 角色列表
     */
    private List<String> roles;

    /**
     * 权限列表
     */
    private List<String> permissions;
}
