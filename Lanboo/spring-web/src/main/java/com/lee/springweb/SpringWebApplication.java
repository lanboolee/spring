package com.lee.springweb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import sun.rmi.runtime.Log;

@SpringBootApplication
@Slf4j
public class SpringWebApplication {
    public static void main(String[] args) {

        SpringApplication.run(SpringWebApplication.class, args);
        log.info("-------------------------------启动完成-----------------------");
    }
}
