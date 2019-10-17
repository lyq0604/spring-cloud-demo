package com.blade.system.entity;

import lombok.Data;

import java.util.List;

@Data
public class TableInfo extends BaseGenerator{

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表主键名称
     */
    private String primaryKey;

    /**
     * 注释
     */
    private String tableComment;

    /**
     * 表对应类名
     */
    private String className;

    private List<ColumnInfo> columnList;

}
