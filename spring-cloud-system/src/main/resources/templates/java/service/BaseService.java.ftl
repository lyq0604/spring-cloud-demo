package ${packageName}.${moduleName}.service;

import com.blade.common.base.BaseService;
import ${packageName}.${moduleName}.entity.${tableInfo.className};
import ${packageName}.${moduleName}.mapper.${tableInfo.className}Mapper;
import org.springframework.stereotype.Service;

/**
* @author ${author}
* @create ${date}
*/
@Service
public class ${tableInfo.className}Service extends BaseService<${tableInfo.className}Mapper,${tableInfo.className}>{
}
