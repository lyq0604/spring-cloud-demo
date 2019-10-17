package com.blade.system.service;

import com.blade.system.common.vo.TableVO;
import com.blade.system.entity.BaseGenerator;
import com.blade.system.mapper.BaseGeneratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.zip.ZipOutputStream;

@Service
public class BaseGeneratorService {

    @Autowired
    private BaseGeneratorMapper baseGeneratorMapper;

    public List<TableVO> selectTableList(String dataBase){
        return baseGeneratorMapper.selectTableList(dataBase);
    }

    public byte[] generate(BaseGenerator generator) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        List<String> tables = generator.getTableList();
        return null;
    }

}
