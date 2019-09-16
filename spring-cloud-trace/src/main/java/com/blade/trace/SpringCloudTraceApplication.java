package com.blade.trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author lyq
 */
@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class SpringCloudTraceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTraceApplication.class, args);
	}

}
