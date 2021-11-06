package com.sai.kickboxing_site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {
    @GetMapping("/")
    public String showIndex() {
        return "index";
    }
}
