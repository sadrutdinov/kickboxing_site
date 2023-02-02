package com.sai.kickboxing_site.services;

import com.sai.kickboxing_site.models.TrainingCost;
import com.sai.kickboxing_site.models.TrainingType;
import com.sai.kickboxing_site.repositories.TrainingCostRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class TrainingCostServiceTest {

    @Autowired
    private TrainingCostRepository trainingCostRepository;
    @Autowired
    private TrainingCostService trainingCostService;

    @Test
    void getAll() {
        TrainingCost trainingCost = initTrainingCost();
        trainingCostRepository.save(trainingCost);
        assertThat(trainingCostService.getAll().size()).isEqualTo(1);
    }

    @Test
    void save() {
        TrainingCost trainingCost = initTrainingCost();
        assertDoesNotThrow(() -> trainingCostService.save(trainingCost));

        List<TrainingCost> trainingCostList = trainingCostRepository.findAll();
        assertThat(trainingCostList.size()).isEqualTo(1);
    }

    @Test
    void getTrainingCost() {
        TrainingCost trainingCost = initTrainingCost();
        trainingCostRepository.save(trainingCost);
        TrainingCost trainingCostFromDB = trainingCostService.getTrainingCostById(trainingCost.getId());
        assertThat(trainingCost).isEqualTo(trainingCostFromDB);
    }

    @Test
    void deleteById() {
        TrainingCost trainingCost = initTrainingCost();
        trainingCostRepository.save(trainingCost);

        assertDoesNotThrow(() -> trainingCostService.deleteTrainingCostById(trainingCost.getId()));
        List<TrainingCost> trainingCostList = trainingCostRepository.findAll();
        assertThat(trainingCostList).isEmpty();
    }

    private TrainingCost initTrainingCost() {
        TrainingCost trainingCost = new TrainingCost();
        trainingCost.setDescription("TEST");
        trainingCost.setType(TrainingType.EIGHT);
        trainingCost.setPrice(500);
        return trainingCost;
    }

    @AfterEach
    void cleanRepository() {
        trainingCostRepository.deleteAll();
    }
}