package com.tencent.demo.zipkin.web;

import com.tencent.demo.zipkin.web.interceptor.CustomizedHandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired(required = false)
    protected List<CustomizedHandlerInterceptor> customizedHandlerInterceptors;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        logger.debug(" *** Add Customized Interceptors ***");

        if(!CollectionUtils.isEmpty(customizedHandlerInterceptors)) {
            for(final CustomizedHandlerInterceptor customizedHandlerInterceptor: customizedHandlerInterceptors) {
                registry.addInterceptor(customizedHandlerInterceptor);
            }
        }
    }

}
