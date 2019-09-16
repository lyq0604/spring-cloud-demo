package com.blade.system.common.exceptions;

import com.blade.system.common.enums.UserResponseEnum;

/**
 * @author lyq
 */
public class CustomUserException extends RuntimeException {

    private Integer code;

    public CustomUserException(UserResponseEnum userResponseEnum) {
        super(userResponseEnum.getDescription());
        this.code = userResponseEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
