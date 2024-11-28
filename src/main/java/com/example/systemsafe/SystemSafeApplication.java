package com.example.systemsafe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.example.systemsafe.mapper")
@SpringBootApplication
public class SystemSafeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemSafeApplication.class, args);
    }

}
