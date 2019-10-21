package com.blade.system.base.controller;

import com.blade.common.base.BaseController;
import com.blade.system.base.domain.Role;
import com.blade.system.base.service.RoleService;
import org.springframework.web.bind.annotation.*;

/**
  * @author lyq
  * @create 2019-10-21T21:13:43.792
*/
@RestController
@RequestMapping("/roles")
public class RoleController extends BaseController<RoleService,Role> {
}
