package com.blade.system.common.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TableVO {

    private String tableName;

    private String tableComment;

    private String tableEngine;

    private String primaryKey;

    private LocalDateTime createTime;

}
