package com.atguigu.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("aaa")
public class GmallOrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GmallOrderServiceApplication.class,args);
    }
}
