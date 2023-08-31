package com.transactional.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@ComponentScan
@Configuration
@EnableTransactionManagement
public class MySqlConfig {
    /**
     * 配置Druid数据源
     */
    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        //为了方便，直接硬编码了，我们可以通过@Value引入外部配置，
        //如果使用Spring boot就更简单了，直接使用@ConfigurationProperties引入外部配置
        //简单的配置数据库连接信息，其他连接池信息采用默认配置
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/springdao?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf8");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        return druidDataSource;
    }

    /**
     * 配置JdbcTemplate
     * 直接使用spring-jdbc来操作某一个数据库，不使用其他外部数据库框架
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        //传入一个数据源
        return new JdbcTemplate(druidDataSource());
    }


    /**
     * 配置DataSourceTransactionManager
     * 用于管理某一个数据库的事务
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        //传入一个数据源
        return new DataSourceTransactionManager(druidDataSource());
    }

    /**
     * 事务管理器
     * @param dataSource
     * @return
     * JpaTransactionManager：如果你用jpa来操作db，那么需要用这个管理器来帮你控制事务。
     * DataSourceTransactionManager：如果你用是指定数据源的方式，比如操作数据库用的是：JdbcTemplate、mybatis、ibatis，那么需要用这个管理器来帮你控制事务。
     * HibernateTransactionManager：如果你用hibernate来操作db，那么需要用这个管理器来帮你控制事务。
     * JtaTransactionManager：如果你用的是java中的jta来操作db，这种通常是分布式事务，此时需要用这种管理器来控制事务。
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 事务模板
     * @param transactionManager
     * @return
     */
    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }
}
