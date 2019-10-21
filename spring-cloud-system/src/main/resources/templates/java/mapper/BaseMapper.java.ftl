package ${packageName}.mapper;

import ${packageName}.entity.${tableInfo.className};
import org.springframework.stereotype.Repository;
import java.util.List;
import com.blade.common.base.BaseMapper;

@Repository
public interface ${tableInfo.className}Mapper extends BaseMapper<${tableInfo.className}> {
}