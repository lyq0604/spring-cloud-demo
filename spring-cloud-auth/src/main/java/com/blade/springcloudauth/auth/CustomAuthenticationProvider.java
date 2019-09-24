package com.blade.springcloudauth.auth;

import com.blade.springcloudauth.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


/**
 * 自定义认证处理
 *
 * @author lyq
 * @create 6/21/19
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        UserDetails userDetails = authService.loadUserByUsername(username);
        if (!userDetails.getPassword().equals(password)) {
            throw new BadCredentialsException("密码不正确！");
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        token.setDetails(userDetails);
        return token;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
