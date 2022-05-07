package com.ds.mdb.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * mqx
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.datasource1")
    public DataSource writeDs() throws Exception {
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.datasource2")
    public DataSource readDs() throws Exception {
        return new DruidDataSource();
    }
}
