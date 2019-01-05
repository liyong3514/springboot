package com.itheima.ssm.config;

import com.itheima.ssm.service.IUserService;
import com.itheima.ssm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @version 1.0
 * @Author 李永
 * @company wwww.itcast.com
 * TODO
 * @Date 2019\1\1 0001
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,jsr250Enabled = true, securedEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/css/**","/img/**","/plugins/**").permitAll().
                anyRequest().authenticated().
                antMatchers("/**").hasAnyRole("ROLE_ADMIN","ROLE_USER");
        http.formLogin().loginPage("/login.jsp").
                loginProcessingUrl("/login.do").
                failureUrl("/failer.jsp").permitAll().
                defaultSuccessUrl("/index.jsp").
                successForwardUrl("/pages/main.jsp");
        http.logout().logoutUrl("/logout.do").
                logoutSuccessUrl("/login.jsp").permitAll().deleteCookies().invalidateHttpSession(true);
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IUserService userService(){
        return new UserServiceImpl();
    }
}
