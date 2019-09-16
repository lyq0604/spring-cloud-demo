package com.blade.system.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyq
 * @create 8/31/19
 */
@Configuration
public class RequestInterceptConfig implements RequestInterceptor {


    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String BEARER_TOKEN_TYPE = "Bearer";

    //TODO
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String accessToken = "Bearer qwertyuioi";
        requestTemplate.header(AUTHORIZATION_HEADER,
                String.format("%s %s",
                        BEARER_TOKEN_TYPE,
                        accessToken));

    }
}
