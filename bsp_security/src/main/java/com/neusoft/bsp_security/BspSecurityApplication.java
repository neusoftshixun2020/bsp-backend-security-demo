package com.neusoft.bsp_security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan({"com.neusoft.bsp_security.*.mapper"})
@EnableSwagger2
@SpringBootApplication
public class BspSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BspSecurityApplication.class, args);
    }

}
