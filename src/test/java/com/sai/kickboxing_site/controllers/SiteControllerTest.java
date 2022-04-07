package com.sai.kickboxing_site.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class SiteControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void showIndex() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testUnknownUrl() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/unknownUrl")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}