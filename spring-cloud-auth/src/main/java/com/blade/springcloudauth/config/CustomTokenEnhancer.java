package com.blade.springcloudauth.config;

import com.blade.springcloudauth.auth.AuthUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.LinkedHashMap;

/**
 * 自定义token增强器,在jwt中封装自定义信息
 *
 * @author lyq
 * @create 8/31/19
 */
public class CustomTokenEnhancer implements TokenEnhancer{
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        AuthUser user = (AuthUser) oAuth2Authentication.getPrincipal();
        LinkedHashMap<String,Object> extraInfo = new LinkedHashMap<>();
        extraInfo.put("userId",user.getId());
        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(extraInfo);
        return oAuth2AccessToken;
    }
}
