package com.zemoso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{
        User.UserBuilder users=User.withDefaultPasswordEncoder();
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(users.username("John").password("Test").roles("Employee"))
                .withUser(users.username("Mary").password("Test").roles("Employee","Manager"))
                .withUser(users.username("Susan").password("Test").roles("Employee","Admin"));
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
