package com.blade.system.controller;

import com.blade.common.base.BaseController;
import com.blade.system.entity.Operation;
import com.blade.system.service.OperationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyq
 * @create 10/17/19
 */
@RestController
@RequestMapping("/operations")
public class OperationController extends BaseController<OperationService,Operation>{
}
