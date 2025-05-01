package com.yuiko.like;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yuiko.like.mapper")
@SpringBootApplication
public class YuikoLikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuikoLikeApplication.class, args);
    }

}
