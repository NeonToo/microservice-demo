package com.tencent.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceBApplication {

    @GetMapping("/services/b")
    public String printServiceB() {
        return "*** Java Service_B ***";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceBApplication.class, "--spring.application.name=java-service_B", "--server.port=9000");
    }

}
