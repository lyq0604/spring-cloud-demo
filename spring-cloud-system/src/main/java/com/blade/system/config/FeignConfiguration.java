package com.blade.system.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Feign请求添加Authorization头
 * @author lyq
 * @create 8/31/19
 */
@Configuration
public class FeignConfiguration implements RequestInterceptor {


    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String authorization = attributes.getRequest().getHeader("Authorization");
        requestTemplate.header(AUTHORIZATION_HEADER, authorization);
    }
}
