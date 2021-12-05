package com.sai.kickboxing_site.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
@Slf4j
public class SiteController {
    @GetMapping("/")
    public String showIndex() {
        log.debug("new guest");
        return "index";
    }
}
