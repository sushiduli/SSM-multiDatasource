package com.cn.kg.config.datasource;


import cn.hutool.core.io.resource.ClassPathResource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.cn.kg.config.datasource.constants.DBTypeEnum;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 关于数据源配置，参考SpringBoot官方文档第79章《Data Access》
 * 79. Data Access
 * 79.1 Configure a Custom DataSource
 * 79.2 Configure Two DataSources
 */

@Configuration
public class DataSourceConfig {

    /**
     * 作用是为了让Spring能够解析属性占位符，
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    private DataSource generateDataSource(String propertiesFile){
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource(propertiesFile).getStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            return DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public DataSource masterDataSource() {
        return generateDataSource("properties/db-master.properties");
    }

    @Bean
    public DataSource slave1DataSource() {
        return generateDataSource("properties/db-slave1.properties");
    }

    @Bean
    public DataSource slave2DataSource() {
        return generateDataSource("properties/db-slave2.properties");
    }

    @Bean
    public DataSource myRoutingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                          @Qualifier("slave1DataSource") DataSource slave1DataSource,
                                          @Qualifier("slave2DataSource") DataSource slave2DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MASTER, masterDataSource);
        targetDataSources.put(DBTypeEnum.SLAVE1, slave1DataSource);
        targetDataSources.put(DBTypeEnum.SLAVE2, slave2DataSource);
        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();
        myRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
        myRoutingDataSource.setTargetDataSources(targetDataSources);
        return myRoutingDataSource;
    }

}
