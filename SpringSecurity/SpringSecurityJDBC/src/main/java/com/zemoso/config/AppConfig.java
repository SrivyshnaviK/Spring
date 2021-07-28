package com.zemoso.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.zemoso")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {
    @Autowired
    private Environment environment;
    Logger logger = Logger.getLogger(getClass().getName());
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Bean
    public DataSource securityDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        logger.info(">>>jdbc.url+"+environment.getProperty("jdbc.url"));
        logger.info(">>>jdbc.user+"+environment.getProperty("jdbc.user"));
        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        dataSource.setUser(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        dataSource.setInitialPoolSize(getInt("connection.pool.initialPoolSize"));
        dataSource.setMinPoolSize(getInt("connection.pool.minPoolSize"));
        dataSource.setMaxPoolSize(getInt("connection.pool.maxPoolSize"));
        dataSource.setMaxIdleTime(getInt("connection.pool.maxIdleTime"));
        return dataSource;
    }
    private int getInt(String propName){
        return Integer.parseInt(environment.getProperty(propName));
    }
}
