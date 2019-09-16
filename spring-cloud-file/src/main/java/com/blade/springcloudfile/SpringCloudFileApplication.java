package com.blade.springcloudfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFileApplication.class, args);
    }

}
