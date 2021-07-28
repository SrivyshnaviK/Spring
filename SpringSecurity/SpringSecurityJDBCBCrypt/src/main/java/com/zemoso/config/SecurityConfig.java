package com.zemoso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{
        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource);
    }
    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/").hasRole("Employee")
                .antMatchers("/managers/**").hasRole("Manager")
                .antMatchers("/admins/**").hasRole("Admin")//restricting access
                .and().formLogin().loginPage("/showLoginPage")
                .loginProcessingUrl("/authenticateUser").permitAll().permitAll()
                .and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/accessDeniedPage");
    }
}
