package com.blade.system.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lyq
 * @create 6/21/19
 */
public class PWDUtil {

    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * 生成密码
     *
     * @param password
     * @return
     */
    public static String generatePwd(String password) {
        return encoder.encode(password);
    }

    /**
     * 校验密码
     *
     * @param password 用户输入明文密码
     * @param dbPwd    数据库存储密码
     * @return
     */
    public static boolean matchPwd(String password, String dbPwd) {
        return encoder.matches(password, dbPwd);
    }


}
