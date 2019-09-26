package com.blade.system.common.advice;

import com.alibaba.fastjson.JSON;
import com.blade.common.response.BaseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 返回值统一封装
 *
 * @author lyq
 * @create 9/26/19
 */
@RestController
@ControllerAdvice(basePackages = { "com.blade.system.controller" })
public class ResponseAdvice implements ResponseBodyAdvice<Object>{
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        BaseResult result;
        if (body == null) {
            result = new BaseResult().success();
        } else if (body instanceof BaseResult) {
            result = (BaseResult) body;
        } else {
            result = new BaseResult().success(body);
        }
        //处理返回值是String的情况
        if (body instanceof String) {
            return JSON.toJSONString(result);
        }
        return result;
    }
}
