package com.blade.system.feignClients;

import com.blade.common.response.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "spring-cloud-blog",path = "/blogs")
public interface BlogClient {

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.DELETE)
    BaseResult deleteBlogByKey(@PathVariable("userId") String userId);

}
