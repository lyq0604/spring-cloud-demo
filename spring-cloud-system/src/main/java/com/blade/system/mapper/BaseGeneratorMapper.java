package com.blade.system.mapper;

import com.blade.system.common.vo.TableVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseGeneratorMapper {

    List<TableVO> selectTableList(String dataBase);

}
