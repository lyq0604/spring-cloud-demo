package com.blade.system.common.enums;

/**
 * @author lyq
 */

public enum UserResponseEnum {

    USER_NOT_FOUND(50001, "用户不存在"),

    USER_AUTHENTICATION_ERROR(50002, "用户或密码不正确");

    private Integer code;

    private String description;

    UserResponseEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
