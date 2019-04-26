package com.tencent.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@RestController
public class BackendApplication {

    @GetMapping("/api")
    public String printDate() {
        return new Date().toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, "--spring.application.name=java-backend", "--server.port=9000");
    }

}
