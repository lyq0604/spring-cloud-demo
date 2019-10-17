package com.blade.system.entity;

import lombok.Data;

import java.util.List;

@Data
public class BaseGenerator {

    /**
     * 库
     */
    private String dataBase;

    /**
     * 表
     */
    private List<String> tableList;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 作者
     */
    private String author;

    /**
     * 前端样式：list/tree
     */
    private String viewType;
}
