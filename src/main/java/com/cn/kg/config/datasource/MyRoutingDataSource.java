package com.cn.kg.config.datasource;

/**
 * @program: mvc-template
 * @description: TODO
 * @author: konggang
 * @create: 2019-11-01 23:15
 **/

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class MyRoutingDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }

}