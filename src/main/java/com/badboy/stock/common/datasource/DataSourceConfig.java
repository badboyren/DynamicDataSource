package com.badboy.stock.common.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.badboy.stock.mapper")
@EnableTransactionManagement
public class DataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    private Environment env;

    @Bean(name = "badboyDataSource")
    @Qualifier("badboyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.badboy")
    public DataSource badboyDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "badboy1DataSource")
    @Qualifier("badboy1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.badboy1")
    public DataSource badboy1DataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("badboyDataSource") DataSource badboyDataSource,
                                        @Qualifier("badboy1DataSource") DataSource badboy1DataSource) {
    	
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseType.badboy, badboyDataSource);
        targetDataSources.put(DatabaseType.badboy1, badboy1DataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(badboyDataSource);// 默认的datasource设置为myTestDbDataSource

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(
    		@Qualifier("badboyDataSource") DataSource badboyDataSource,
            @Qualifier("badboy1DataSource") DataSource badboy1DataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(this.dataSource(badboyDataSource, badboy1DataSource));
        fb.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations")));
        return fb.getObject();
    }


    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
