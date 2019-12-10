package com.example.demo.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement  //开启事务的管理
public class TransactionManagementConfiguration implements TransactionManagementConfigurer {  //继承一个接口 实现这个接口的方法

    @Autowired
    private DataSource dataSource; // Transaction需要一个成员变量 有了dataSource才能基于事物的管理
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
