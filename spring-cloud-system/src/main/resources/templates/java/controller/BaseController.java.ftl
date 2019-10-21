package ${packageName}.${moduleName}.controller;

import com.blade.common.base.BaseController;
import ${packageName}.${moduleName}.domain.${tableInfo.className};
import ${packageName}.${moduleName}.service.${tableInfo.className}Service;
import org.springframework.web.bind.annotation.*;

/**
  * @author ${author}
  * @create ${date}
*/
@RestController
@RequestMapping("/${tableInfo.classNameLower}s")
public class ${tableInfo.className}Controller extends BaseController<${tableInfo.className}Service,${tableInfo.className}> {
}
