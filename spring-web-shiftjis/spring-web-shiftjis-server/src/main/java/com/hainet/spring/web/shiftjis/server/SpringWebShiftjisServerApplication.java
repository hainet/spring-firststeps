package com.hainet.spring.web.shiftjis.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringWebShiftjisServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebShiftjisServerApplication.class, args);
    }

    @PostMapping(value = "", produces = "text/plain;charset=shift_jis")
    public String post(@RequestParam final String name) {
        System.out.println(name);

        return name;
    }
}
