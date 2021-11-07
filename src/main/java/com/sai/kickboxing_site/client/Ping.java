package com.sai.kickboxing_site.client;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class Ping {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final String url = "https://yandex.ru/";

    @Scheduled(fixedRate = 60000)
    public void ping() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        System.out.printf("current time: %s, url: %s, status code: %s\n", dateFormat.format(new Date()), url, response.getStatusCode());


    }
}
