package com.blade.gateway.fallback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyq
 * @create 19-8-13
 */
@RestController
public class DefaultFallback {

    @GetMapping("/fallback")
    public Map defaultFallbackHandler(){
        Map<String,Object> result = new HashMap<>(2);
        result.put("code",500);
        result.put("message","服务器繁忙，请稍后重试！");
        return result;
    }

}
