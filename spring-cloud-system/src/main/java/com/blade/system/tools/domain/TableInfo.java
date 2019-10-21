package com.blade.system.tools.domain;

import lombok.Data;

import java.util.List;

@Data
public class TableInfo {

    /**
     * 数据库名称
     */
    private String database;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表对应类名
     */
    private String className;

    /**
     * 表对应类名小写形式，用于controller构建restful url
     */
    private String classNameLower;

    /**
     * 列
     */
    private List<ColumnInfo> columnList;

}
