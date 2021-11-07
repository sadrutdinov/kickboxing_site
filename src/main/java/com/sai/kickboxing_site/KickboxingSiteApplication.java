package com.sai.kickboxing_site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KickboxingSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(KickboxingSiteApplication.class, args);
    }

}
