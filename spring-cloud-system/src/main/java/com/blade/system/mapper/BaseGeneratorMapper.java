package com.blade.system.mapper;

import com.blade.system.common.vo.ColumnVO;
import com.blade.system.common.vo.TableVO;
import com.blade.system.entity.ColumnInfo;
import com.blade.system.entity.TableInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseGeneratorMapper {

    /**
     * 查询所有数据库名称
     * @return
     */
    List<String> selectDatabaseInfo();

    /**
     * 查询指定数据库下的所有表信息
     * @return
     */
    List<TableVO> selectTableList(@Param("database") String database,@Param("tableName") String tableName);

    /**
     * 查询指定表的字段信息
     * @param database
     * @param tableName
     * @return
     */
    List<ColumnInfo> selectColumnList(@Param("database") String database, @Param("tableName") String tableName);

    /**
     * 查询主键名称
     * @param tableInfo
     * @return
     */
    String selectPrimaryKey(TableInfo tableInfo);
}
