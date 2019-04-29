package com.tencent.demo.zipkin.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CrossServiceInterceptor implements ClientHttpRequestInterceptor {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)  throws IOException {

        String spanID = request.getHeaders().get("X-B3-SpanId").get(0);

        logger.info("SpanID: " + spanID);

        return execution.execute(request, body);
    }

}
