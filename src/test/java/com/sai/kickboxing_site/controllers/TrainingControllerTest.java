package com.sai.kickboxing_site.controllers;

import com.sai.kickboxing_site.models.Training;
import com.sai.kickboxing_site.repositories.TrainingRepository;
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
class TrainingControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TrainingRepository trainingRepository;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();

        trainingRepository.deleteAll();
    }

    @Test
    void showAllTraining() throws Exception {
        mockMvc.perform(get("/training_schedule").with(user("user").password("pass").roles("ADMIN")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Расписание тренировок")));
    }

    @Test
    void addNewTraining() throws Exception {
        mockMvc.perform(get("/training_schedule/addNewTraining")
                        .with(user("user").password("pass").roles("ADMIN")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Информация о тренировке")));
    }

    @Test
    void saveTraining() throws Exception {
        Training training = new Training();
        training.setTrainingDays("Понедельник");
        training.setTrainingTime("18:30");
        training.setName("Взрослые");

        mockMvc.perform(get("/training_schedule/saveTraining")
                        .with(user("user").password("pass").roles("ADMIN"))
                        .flashAttr("Training", training))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        List<Training> trainingList = trainingRepository.findAll();
        assertThat(trainingList.size()).isEqualTo(1);
    }

    @Test
    void updateTraining() throws Exception {
        String trainingDays = "понедельник тестовое значение";

        Training training = new Training();
        training.setTrainingDays(trainingDays);
        training.setTrainingTime("18:30");
        training.setName("Взрослые");
        trainingRepository.save(training);

        String id = String.valueOf(training.getId());

        mockMvc.perform(get("/training_schedule/updateTraining")
                        .with(user("user").password("pass").roles("ADMIN"))
                        .param("TrainingId", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(trainingDays)));
    }

    @Test
    void deleteTraining() throws Exception {
        Training training = new Training();
        training.setTrainingDays("понедельник тестовое значение");
        training.setTrainingTime("18:30");
        training.setName("Взрослые");
        trainingRepository.save(training);

        String id = String.valueOf(training.getId());

        mockMvc.perform(get("/training_schedule/deleteTraining")
                        .with(user("user").password("pass").roles("ADMIN"))
                        .param("TrainingId", id))
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        List<Training> trainingList = trainingRepository.findAll();
        assertThat(trainingList).isEmpty();
    }
}