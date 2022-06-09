package com.sai.kickboxing_site.services;

import com.sai.kickboxing_site.entities.cost_of_training.TrainingCost;
import com.sai.kickboxing_site.entities.training_schedule.Training;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainingService {
    List<Training> getAllTraining();

    Training save(Training training);

    Training getTrainingById(int id);

    void deleteTrainingById(int id);
}
