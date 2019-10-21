package com.blade.system.controller;

import com.blade.system.common.vo.ColumnVO;
import com.blade.system.common.vo.TableVO;
import com.blade.system.entity.BaseGenerator;
import com.blade.system.entity.ColumnInfo;
import com.blade.system.entity.TableInfo;
import com.blade.system.service.BaseGeneratorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lyq
 */
@RestController
@RequestMapping("/generator")
@ApiOperation(value = "代码生成器相关接口")
public class BaseGeneratorController {

    @Autowired
    private BaseGeneratorService baseGeneratorService;

    @ApiOperation("查询所有数据库")
    @GetMapping("/databases")
    public List<String> selectDatabaseList(){
        return baseGeneratorService.selectDatabaseList();
    }

    @ApiOperation("查询指定库下的所有表")
    @GetMapping("/tables")
    public List<TableVO> selectTableList(@RequestParam("database") String database,@RequestParam("tableName") String tableName){
        return baseGeneratorService.selectTableList(database,tableName);
    }

    @ApiOperation("查询指定表的字段")
    @GetMapping("/columns")
    public List<ColumnInfo> selectColumnList(@RequestParam("database") String database, @RequestParam("tableName") String tableName){
        return baseGeneratorService.selectColumnList(database,tableName);
    }

    @ApiOperation("生成代码")
    @PostMapping("/generate")
    public byte[] generate(@RequestBody BaseGenerator generator){
        return baseGeneratorService.generate(generator);
    }

}
