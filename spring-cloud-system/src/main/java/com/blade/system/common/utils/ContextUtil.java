package com.blade.system.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.Map;

/**
 * @author lyq
 * @create 8/31/19
 */
public class ContextUtil {

    /**
     * 从accessToken中获取额外信息
     * @param
     * @return
     */
    public static Map<String,Object> getExtraInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        return (Map<String, Object>) details.getDecodedDetails();
    }

}
