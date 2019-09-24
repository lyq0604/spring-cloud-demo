package com.blade.system.feignClients;

import com.blade.common.domain.JWT;
import com.blade.system.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lyq
 * @create 8/31/19
 */
@FeignClient(name = "spring-cloud-auth",configuration = {FeignConfiguration.class})
public interface AuthClient {

    /**
     * 获取token
     * @param username 用户名
     * @param password 密码
     * @param grant_type 授权模式
     * @param client_id 客户端id
     * @param client_secret 客户端秘钥
     * @return
     */
    @PostMapping("/oauth/token")
    JWT getToken(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("grant_type") String grant_type,
            @RequestParam("client_id") String client_id, @RequestParam("client_secret") String client_secret);

}
