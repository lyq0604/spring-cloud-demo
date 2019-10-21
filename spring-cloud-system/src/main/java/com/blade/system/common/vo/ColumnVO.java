package com.blade.system.common.vo;

import lombok.Data;

/**
 * @author lyq
 * @create 10/18/19
 */
@Data
public class ColumnVO {

    private String columnName;

    private String columnType;

    private String columnComment;

    private Boolean primaryKey;

    /**
     * 检索类型：模糊匹配/精确查询
     */
    private String searchType;

    /**
     * 是否在列表显示
     */
    private Boolean enableListView;

    /**
     * 是否在表单页显示
     */
    private Boolean enableFormView;

    /**
     * 是否列表检索条件
     */
    private Boolean enableListQuery;

}
