package com.blade.manager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagerServer
@EnableAutoConfiguration(exclude = {DruidDataSourceAutoConfigure.class})
public class SpringCloudTxManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTxManagerApplication.class, args);
	}

}
