package com.blade.springcloudauth.config;

import com.blade.springcloudauth.auth.AuthService;
import com.blade.springcloudauth.auth.CustomAuthenticationProvider;
import com.blade.springcloudauth.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 作为资源服务器对外暴露获取JWT的接口
 *
 * @author lyq
 * @create 6/18/19
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthService authService;
    @Autowired
    CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    /**
     * 自定义登录认证
     */
    @Autowired
    CustomAuthenticationProvider provider;

    @Autowired
    CustomPasswordEncoder customPasswordEncoder;

    /**
     * 密码模式下必须注入的bean authenticationManagerBean
     * 认证是由 AuthenticationManager 来管理的，
     * 但是真正进行认证的是 AuthenticationManager 中定义的AuthenticationProvider。
     *  AuthenticationManager 中可以定义有多个 AuthenticationProvider
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 安全配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint)
            .and()
            .authorizeRequests()
            .antMatchers("/oauth/token").permitAll()
            .antMatchers("/actuator/**").permitAll()
            .anyRequest().authenticated()//所有请求都需要认证后才可访问
            .and()
            .httpBasic();
    }

    /**
     * 用户信息配置
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
        auth.userDetailsService(authService).passwordEncoder(customPasswordEncoder);
    }

}
