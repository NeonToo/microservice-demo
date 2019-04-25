package com.tencent.demo.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceZipkinServerApplication.class, args);
    }

}
