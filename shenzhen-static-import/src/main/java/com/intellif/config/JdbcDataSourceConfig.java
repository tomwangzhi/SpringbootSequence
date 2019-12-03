package com.intellif.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 双数据源配置类
 */
@Configuration
public class JdbcDataSourceConfig {

    @Autowired
    PrimaryDataSourceProperty primaryDataSourceProperty;

    @Autowired
    SecondaryDataSourceProperty secondaryDataSourceProperty;


    @Bean(value = "primaryDataSource")
    @Qualifier(value = "primaryDataSource")
    @ConditionalOnClass(value = PrimaryDataSourceProperty.class)
    public DataSource primaryDataSource() throws PropertyVetoException {
        ComboPooledDataSource primaryDataSource = new ComboPooledDataSource();
        primaryDataSource.setJdbcUrl(primaryDataSourceProperty.getUrl());
        primaryDataSource.setUser(primaryDataSourceProperty.getUsername());
        primaryDataSource.setPassword(primaryDataSourceProperty.getPassword());
        primaryDataSource.setDriverClass(primaryDataSourceProperty.getDriveClass());
        primaryDataSource.setMaxPoolSize(primaryDataSourceProperty.getMaxPoolSize());
        primaryDataSource.setInitialPoolSize(primaryDataSourceProperty.getInitPoolSize());
        return primaryDataSource;
    }

    @Bean(value = "secondaryDataSource")
    @Qualifier(value = "secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource() throws PropertyVetoException {
        ComboPooledDataSource secondaryDataSource = new ComboPooledDataSource();
        secondaryDataSource.setJdbcUrl(secondaryDataSourceProperty.getUrl());
        secondaryDataSource.setUser(secondaryDataSourceProperty.getUsername());
        secondaryDataSource.setPassword(secondaryDataSourceProperty.getPassword());
        secondaryDataSource.setDriverClass(secondaryDataSourceProperty.getDriveClass());
        secondaryDataSource.setMaxPoolSize(secondaryDataSourceProperty.getMaxPoolSize());
        secondaryDataSource.setInitialPoolSize(secondaryDataSourceProperty.getInitPoolSize());
        return secondaryDataSource;
    }

}
