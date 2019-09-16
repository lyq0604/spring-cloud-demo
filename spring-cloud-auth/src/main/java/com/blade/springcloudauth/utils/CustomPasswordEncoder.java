package com.blade.springcloudauth.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author lyq
 * @create 8/15/19
 */
@Component
public class CustomPasswordEncoder implements PasswordEncoder{
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return StringUtils.equals(charSequence,s);
    }
}
