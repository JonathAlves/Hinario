package com.newagesoft.hinario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
public class HinarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(HinarioApplication.class, args);
    }

}
