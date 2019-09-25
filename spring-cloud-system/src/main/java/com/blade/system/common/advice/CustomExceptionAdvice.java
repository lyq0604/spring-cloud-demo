package com.blade.system.common.advice;

import com.blade.common.response.BaseResult;
import com.blade.system.common.exceptions.CustomUserException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lyq
 */
@RestController
@ControllerAdvice(basePackages = {"com.blade.system.controller"})
@Slf4j
public class CustomExceptionAdvice {

    /**
     * 处理用户异常
     *
     * @return
     */
    @ExceptionHandler(CustomUserException.class)
    public BaseResult UserExceptionHandler(HttpServletRequest request, CustomUserException e) {
        log.error("用户信息异常：Host:{} invoke URL:{},错误信息：{}", request.getRemoteHost(), request.getRequestURL(), e.getMessage());
        return new BaseResult(e.getCode(), false, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResult ExceptionHandler(HttpServletRequest request,Exception e){
        log.error("运行异常，原因：[{}]",e.getMessage());
        return new BaseResult().error(false,"系统内部发生错误，操作失败，请稍后重试！");
    }

}
