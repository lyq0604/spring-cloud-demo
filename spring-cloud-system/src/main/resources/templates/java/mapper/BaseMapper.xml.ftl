<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.${tableInfo.className}Mapper">

    <!-- 基本列 -->
    <sql id="baseColumns">
        <#list tableInfo.columnList as column>
            ${column.columnName}<#if column_index != tableInfo.columnList?size-1>,</#if>
        </#list>
    </sql>

    <!-- 基础映射 -->
    <resultMap id="BaseResultMap" type="${packageName}.${tableInfo.className}">
    <#list tableInfo.columnList as column>
        <#if column.primaryKey>
            <id column="${column.columnName}" jdbcType="${column.columnType}" property="${column.attrName}"/>
        <#else>
            <result column="${column.columnName}" jdbcType="${column.columnType}" property="${column.attrName}"/>
        </#if>
    </#list>
    </resultMap>

    <!-- 条件查询列表 -->
    <select id="selectListByEntity" parameterType="${packageName}.entity.${tableInfo.className}" resultMap="BaseResultMap">
        SELECT
            <include refid="baseColumns"/>
        FROM ${tableInfo.tableName}
        <where>
            <#list tableInfo.columnList as column>
                <#if column.searchType == "equals">
                    <if test="${column.attrName} != null and ${column.attrName} != ''">
                        and ${column.columnName} = ${r'#{'}${column.attrName}${r'}'}
                    </if>
                <#else>
                    <if test="${column.attrName} != null and ${column.attrName} != ''">
                        <bind name="${column.attrName}Like" value="'%' + ${column.attrName} + '%'"/>
                        and ${column.columnName} like ${r'#{'}${column.attrName}Like${r'}'}
                    </if>
                </#if>
            </#list>
        </where>
    </select>

</mapper>