package com.tencent.demo.zipkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@RestController
@CrossOrigin  // for cross-origin JS
public class ServiceAApplication {

    private static final String BASE_URL = "http://localhost:9000";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String callServiceA() {
        return "*** Java Service_A *** calls: " + restTemplate.getForObject(BASE_URL + "/services/b", String.class);
    }

    @GetMapping("/services/c")
    public String callServiceC() {
        String resFromC = restTemplate.getForObject("http://localhost:8081/", String.class);

        return "*** Java Service_A *** calls: " + resFromC;
    }

    @GetMapping("/services/d")
    public String callServiceD() {
        String resFromD = restTemplate.getForObject("http://localhost:9001/services/d", String.class);

        return "*** Java Service_A *** calls: " + resFromD;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
//        return new RestTemplate();

//        return new ZipkinRestTemplateCustomizer() {
//
//            @Override
//            public void customize(RestTemplate restTemplate) {
//
//            }
//            new RestTemplateBuilder()
//                    .additionalInterceptors(TracingClientHttpRequestInterceptor.create(httpTracing))
//                    .build();
//        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, "--spring.application.name=java-service_A");
    }

}
