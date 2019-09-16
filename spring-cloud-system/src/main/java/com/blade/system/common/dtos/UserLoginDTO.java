package com.blade.system.common.dtos;

import com.blade.common.domain.JWT;
import com.blade.system.entity.User;
import lombok.Data;

/**
 * 用户登录dto
 *
 * @author lyq
 * @create 8/31/19
 */
@Data
public class UserLoginDTO {

    private JWT jwt;

    private User user;

    public UserLoginDTO() {
    }

    public UserLoginDTO(JWT jwt, User user) {
        this.jwt = jwt;
        this.user = user;
    }
}
