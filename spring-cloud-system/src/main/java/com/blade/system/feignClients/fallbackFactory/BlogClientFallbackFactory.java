package com.blade.system.feignClients.fallbackFactory;

import com.blade.common.response.BaseResult;
import com.blade.system.feignClients.BlogClient;
import feign.hystrix.FallbackFactory;

/**
 * @author lyq
 * @create 9/22/19
 */
public class BlogClientFallbackFactory implements FallbackFactory<BlogClient> {
    @Override
    public BlogClient create(Throwable throwable) {
        return new BlogClient() {
            @Override
            public BaseResult getBlogsByUserId(String userId) {
                return new BaseResult().success("调用失败逻辑");
            }

            @Override
            public BaseResult insertTestBlog() {
                return new BaseResult().error(false,"调用测试分布式事务失败！");
            }

        };
    }
}
