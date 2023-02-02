package com.sai.kickboxing_site.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ConfigSmokeTest {

    @Autowired
    private MvcConfig mvcConfig;
    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @Test
    public void contextLoads() {
        assertThat(mvcConfig).isNotNull();
        assertThat(webSecurityConfig).isNotNull();
    }
}