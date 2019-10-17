package com.blade.system.controller;

import com.blade.system.common.vo.TableVO;
import com.blade.system.entity.BaseGenerator;
import com.blade.system.service.BaseGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generator")
public class BaseGeneratorController {

    @Autowired
    private BaseGeneratorService baseGeneratorService;

    @GetMapping("/tables/{dataBase}")
    public List<TableVO> selectTableList(@PathVariable String dataBase){
        return baseGeneratorService.selectTableList(dataBase);
    }

    @PostMapping("/generate")
    public byte[] generate(@RequestBody BaseGenerator generator){
        return baseGeneratorService.generate(generator);
    }

}
