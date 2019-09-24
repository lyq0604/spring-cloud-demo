package com.blade.system.vo;

import lombok.Data;

import java.util.List;

/**
 * @author lyq
 * @create 9/19/19
 */
@Data
public class UserPermissionVO {

    private String userId;

    private List<String> roleList;

    private List<String> permissionList;

}
