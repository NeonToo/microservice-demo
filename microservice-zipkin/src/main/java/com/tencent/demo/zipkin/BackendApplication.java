package com.tencent.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BackendApplication {

    @GetMapping("/jv1")
    public String printService1() {
        return "--- Java Backend Service1 ---";
    }

    @GetMapping("/jv2")
    public String printService2() {
        return "*** Java Backend Service2 *** calls " + printService1();
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, "--spring.application.name=java-backend", "--server.port=9000");
    }

}
