package com.lz.security.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lz.security.util.BeanMapUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@MapperScan("com.lz.security.mapper")
public class MbConfig {

    @Bean
    public DataSource dataSource(@Autowired DatasourceProperty datasourceProperty) throws Exception {

        Map<Object, Object> objectObjectMap = BeanMapUtils.beanToMap(datasourceProperty);
        return DruidDataSourceFactory.createDataSource(objectObjectMap);
    }

}
