package com.blade.blog.common;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

/**
 * @author lyq
 * @create 6/21/19
 */
public class GenIdUtil implements GenId<String> {
    @Override
    public String genId(String s, String s1) {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
