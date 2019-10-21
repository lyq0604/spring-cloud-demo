package com.blade.system.tools.controller;

import com.blade.system.common.vo.TableVO;
import com.blade.system.tools.domain.Generator;
import com.blade.system.tools.domain.ColumnInfo;
import com.blade.system.tools.service.GeneratorService;
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
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @ApiOperation("查询所有数据库")
    @GetMapping("/databases")
    public List<String> selectDatabaseList(){
        return generatorService.selectDatabaseList();
    }

    @ApiOperation("查询指定库下的所有表")
    @GetMapping("/tables")
    public List<TableVO> selectTableList(@RequestParam("database") String database,@RequestParam("tableName") String tableName){
        return generatorService.selectTableList(database,tableName);
    }

    @ApiOperation("查询指定表的字段")
    @GetMapping("/columns")
    public List<ColumnInfo> selectColumnList(@RequestParam("database") String database, @RequestParam("tableName") String tableName){
        return generatorService.selectColumnList(database,tableName);
    }

    @ApiOperation("生成代码")
    @PostMapping("/generate")
    public byte[] generate(@RequestBody Generator generator){
        return generatorService.generate(generator);
    }

}
