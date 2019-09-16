package com.blade.config.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 配置中心属性
 *
 * @author lyq
 * @create 9/10/19
 */
@Data
public class Property {

    private String id;

    private String key;

    private String value;

    private String application;

    private String profile;

    private String label;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
