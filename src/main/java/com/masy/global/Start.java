package com.masy.global;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Start {

    public static void main(String[] args) {
        System.out.println("==========项目启动==========");
        SpringApplication.run(Start.class,args);
        System.out.println("==========启动完成==========");
    }
}
