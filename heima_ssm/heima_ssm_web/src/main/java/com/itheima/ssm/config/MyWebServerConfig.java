package com.itheima.ssm.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @version 1.0
 * @Author 李永
 * @company wwww.itcast.com
 * TODO
 * @Date 2019\1\2 0002
 **/
@Configuration
public class MyWebServerConfig  {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return factory -> {
            ErrorPage errorPage = new ErrorPage(HttpStatus.FORBIDDEN, "/403.jsp");
            factory.addErrorPages(errorPage);
        };
    }
}
