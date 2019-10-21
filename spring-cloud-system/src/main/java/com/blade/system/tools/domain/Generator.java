package com.blade.system.tools.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Generator {

    /**
     * 包名
     */
    private String packageName;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 作者
     */
    private String author;

    /**
     * 前端样式：list/tree
     */
    private String viewType;

    /**
     * 是否生成Form组件
     */
    private Boolean enableForm;

    /**
     * 表信息
     */
    private TableInfo tableInfo;

    /**
     * 代码生成日期
     */
    private LocalDateTime date;
}
