package com.sai.kickboxing_site.controllers;

import com.sai.kickboxing_site.models.TrainingCost;
import com.sai.kickboxing_site.models.TrainingType;
import com.sai.kickboxing_site.repositories.TrainingCostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ContextConfiguration
@WebAppConfiguration
class TrainingCostControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TrainingCostRepository trainingCostRepository;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();

        trainingCostRepository.deleteAll();
    }

    @Test
    void showAllTrainingCost() throws Exception {
        mockMvc.perform(get("/training_cost").with(user("user").password("pass").roles("ADMIN")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Таблица стоимости тренировок")));
    }

    @Test
    void addNewTrainingCost() throws Exception {
        mockMvc.perform(get("/training_cost/addNewTrainingCost")
                        .with(user("user").password("pass").roles("ADMIN")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Информация о стоимости тренировки")));
    }

    @Test
    void saveTrainingCost() throws Exception {
        TrainingCost trainingCost = new TrainingCost();
        trainingCost.setDescription("TEST");
        trainingCost.setType(TrainingType.EIGHT);
        trainingCost.setPrice(500);

        mockMvc.perform(get("/training_cost/saveTrainingCost")
                        .with(user("user").password("pass").roles("ADMIN"))
                        .flashAttr("trainingCost", trainingCost))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        List<TrainingCost> trainingCostList = trainingCostRepository.findAll();
        assertThat(trainingCostList.size()).isEqualTo(1);
    }

    @Test
    void updateTrainingCost() throws Exception {
        String description = "К-1 (от 14 лет)";

        TrainingCost trainingCost = new TrainingCost();
        trainingCost.setDescription(description);
        trainingCost.setType(TrainingType.EIGHT);
        trainingCost.setPrice(500);
        trainingCostRepository.save(trainingCost);

        String id = String.valueOf(trainingCost.getId());

        mockMvc.perform(get("/training_cost/updateTrainingCost")
                        .with(user("user").password("pass").roles("ADMIN"))
                        .param("TrainingCostId", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(description)));
    }

    @Test
    void deleteTrainingCost() throws Exception {
        TrainingCost trainingCost = new TrainingCost();
        trainingCost.setDescription("К-1 (от 14 лет)");
        trainingCost.setType(TrainingType.EIGHT);
        trainingCost.setPrice(500);
        trainingCostRepository.save(trainingCost);

        String id = String.valueOf(trainingCost.getId());

        mockMvc.perform(get("/training_cost/deleteTrainingCost")
                        .with(user("user").password("pass").roles("ADMIN"))
                        .param("TrainingCostId", id))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        List<TrainingCost> trainingCostList = trainingCostRepository.findAll();
        assertThat(trainingCostList).isEmpty();
    }
}