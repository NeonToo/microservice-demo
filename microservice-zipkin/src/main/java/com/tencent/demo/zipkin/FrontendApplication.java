package com.tencent.demo.zipkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@RestController
@CrossOrigin  // for cross-origin JS
public class FrontendApplication {

    private static final String BASE_URL = "http://localhost:9000";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String callBackend() {
        return "Java Service_A calls: " + restTemplate.getForObject(BASE_URL + "/services/b", String.class);
    }

    @GetMapping("/services/d")
    public String callServiceC() {
        String resFromD = restTemplate.getForObject("http://localhost:9002/services/d", String.class);

        return "Java Service_A calls: " + resFromD;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(FrontendApplication.class, "--spring.application.name=java-frontend");
    }

}
