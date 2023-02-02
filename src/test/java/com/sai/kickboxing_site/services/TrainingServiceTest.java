package com.sai.kickboxing_site.services;

import com.sai.kickboxing_site.models.Training;
import com.sai.kickboxing_site.repositories.TrainingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class TrainingServiceTest {

    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private TrainingService trainingService;

    @Test
    void getAllTraining() {
        Training training = initTraining();
        trainingRepository.save(training);

        assertThat(trainingService.getAllTraining().size()).isEqualTo(1);
    }

    @Test
    void save() {
        Training training = initTraining();
        assertDoesNotThrow(() -> trainingService.save(training));

        List<Training> trainingList = trainingRepository.findAll();
        assertThat(trainingList.size()).isEqualTo(1);
    }

    @Test
    void getTrainingById() {
        Training training = initTraining();
        trainingRepository.save(training);
        Training trainingFromDB = trainingService.getTrainingById(training.getId());
        assertThat(training).isEqualTo(trainingFromDB);
    }

    @Test
    void deleteTrainingById() {
        Training training = initTraining();
        trainingRepository.save(training);

        assertDoesNotThrow(() -> trainingService.deleteTrainingById(training.getId()));
        List<Training> trainingList = trainingRepository.findAll();
        assertThat(trainingList).isEmpty();
    }

    private Training initTraining() {
        Training training = new Training();
        training.setTrainingDays("Понедельник");
        training.setTrainingTime("18:30");
        training.setName("Взрослые");
        return training;
    }

    @AfterEach
    void cleanRepository() {
        trainingRepository.deleteAll();
    }
}