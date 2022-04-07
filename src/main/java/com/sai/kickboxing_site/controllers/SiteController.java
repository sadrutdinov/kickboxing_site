package com.sai.kickboxing_site.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class SiteController {

    @GetMapping("/")
    public String showIndex() {
        log.info("new guest");
        return "index";
    }
}
