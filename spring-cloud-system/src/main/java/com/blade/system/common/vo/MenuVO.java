package com.blade.system.common.vo;

import com.blade.system.entity.Menu;
import com.blade.system.entity.Operation;
import lombok.Data;

import java.util.List;

/**
 * @author lyq
 * @create 10/17/19
 */
@Data
public class MenuVO extends Menu{

    private List<Operation> operationList ;

}
