package com.flyer.springboot.rest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import uk.org.lidalia.sysoutslf4j.context.SysOutOverSLF4J;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.flyer.springboot.rest.dao")
@ComponentScan("com.flyer.springboot.rest")
public class FlyerSpringbootRestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FlyerSpringbootRestApplication.class, args);
        //console -> slf4j
        SysOutOverSLF4J.sendSystemOutAndErrToSLF4J();
    }
}
