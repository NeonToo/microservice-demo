package com.tencent.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceBApplication {

    @GetMapping("/services/b")
    @SpanName("java-span-B")
    public String printServiceB() {
        return "--- Java Service_B ---";
    }

    @GetMapping("/services/e")
    @SpanName("java-span-E")
    public String printServiceE() {
        return "--- Java Service_E ---";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceBApplication.class, "--spring.application.name=java-service_B", "--server.port=9000");
    }

}
