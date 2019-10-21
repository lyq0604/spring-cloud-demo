package ${packageName}.${moduleName}.mapper;

import ${packageName}.${moduleName}.domain.${tableInfo.className};
import org.springframework.stereotype.Repository;
import com.blade.common.base.BaseMapper;

@Repository
public interface ${tableInfo.className}Mapper extends BaseMapper<${tableInfo.className}> {
}