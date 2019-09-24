package com.blade.system.feignClients;

import com.blade.common.response.BaseResult;
import com.blade.system.config.FeignConfiguration;
import com.blade.system.feignClients.fallbackFactory.BlogClientFallbackFactory;
// import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lyq
 */
@FeignClient(value = "spring-cloud-blog", fallbackFactory = BlogClientFallbackFactory.class, configuration = {FeignConfiguration.class} )
public interface BlogClient {

    /**
     * 根据用户id返回文章
     * @param userId
     * @return
     */
    @GetMapping(value = "/blogs/user/{userId}")
    BaseResult getBlogsByUserId(@PathVariable("userId") String userId);

    // @LcnTransaction
    @DeleteMapping("/blogs/test")
    BaseResult deleteByUserId();

}
