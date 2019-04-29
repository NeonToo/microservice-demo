package com.tencent.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BackendApplication {

    @GetMapping("/services/b")
    public String printServiceB() {
        return "--- Java Service_B ---";
    }

    @GetMapping("/services/e")
    public String printServiceE() {
        return "--- Java Service_E ---";
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, "--spring.application.name=java-backend", "--server.port=9000");
    }

}
