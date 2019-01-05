package com.itheima.ssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 * @version 1.0
 * @Author 李永
 * @company wwww.itcast.com
 * TODO
 * @Date 2018\12\31 0031
 **/


@SpringBootApplication
@EnableTransactionManagement
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class);
    }

}
