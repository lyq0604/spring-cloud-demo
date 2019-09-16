package com.blade.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * @author lyq
 * @create 6/21/19
 */
@Configuration
public class TkMapperConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.blade.blog.mapper");
        Properties propertiesMapper = new Properties();
        //主键UUID回写方法执行顺序,默认AFTER,可选值为(BEFORE|AFTER)
        propertiesMapper.setProperty("ORDER", "AFTER");
        mapperScannerConfigurer.setProperties(propertiesMapper);
        return mapperScannerConfigurer;
    }


}
