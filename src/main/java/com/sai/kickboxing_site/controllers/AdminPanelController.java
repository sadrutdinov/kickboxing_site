package com.sai.kickboxing_site.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/admin")
public class AdminPanelController {
    @GetMapping
    public String main() {
        return "admin-panel";
    }
}
