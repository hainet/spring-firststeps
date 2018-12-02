package com.hainet.spring.web.shiftjis.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Configuration
public class WebConfig {

    @Bean
    public RestTemplate restTemplate() {
        final RestTemplate restTemplate = new RestTemplate();

        CollectionUtils.findValueOfType(
                restTemplate.getMessageConverters(),
                StringHttpMessageConverter.class
        ).setDefaultCharset(Charset.forName("shift_jis"));

        return restTemplate;
    }
}
