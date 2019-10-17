package com.blade.system.entity;

import lombok.Data;

@Data
public class ColumnInfo extends BaseGenerator{

    /**
     * 字段名
     */
    private String columnName;

    /**
     * 字段类型
     */
    private String dataType;

    /**
     * 属性名
     */
    private String attrName;

    /**
     * 属性类型
     */
    private String attrType;

    /**
     * 列注释
     */
    private String columnComment;
}
