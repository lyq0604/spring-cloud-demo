package com.blade.blog;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.blade.blog.mapper"})
@EnableDistributedTransaction
public class SpringCloudBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBlogApplication.class, args);
    }

}
