package com.hainet.spring.web.shiftjis.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@SpringBootApplication
public class SpringWebShiftjisClientApplication {

    private final RestTemplate restTemplate;

    public SpringWebShiftjisClientApplication(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(SpringWebShiftjisClientApplication.class, args);

        final SpringWebShiftjisClientApplication app = context.getBean(SpringWebShiftjisClientApplication.class);
        app.post();

        context.close();
    }

    public void post() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(MediaType.APPLICATION_FORM_URLENCODED, Charset.forName("shift_jis")));

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", "はいね");

        System.out.println(restTemplate.postForObject(
                "http://localhost:8081",
                new HttpEntity<>(map, headers),
                String.class)
        );
    }
}
