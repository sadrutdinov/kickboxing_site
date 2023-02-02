package com.sai.kickboxing_site.services;

import com.sai.kickboxing_site.models.Training;
import com.sai.kickboxing_site.repositories.TrainingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<Training> getAllTraining() {
        List<Training> trainings = trainingRepository.findAll();
        trainings.sort(Comparator.comparing(Training::getName).reversed());
        return trainings;
    }

    public Training getTrainingById(int id) {
        Optional<Training> training = trainingRepository.findById(id);
        return training.orElse(null);
    }

    @Transactional
    public Training save(Training training) {
        return trainingRepository.save(training);
    }

    @Transactional
    public void deleteTrainingById(int id) {
        trainingRepository.deleteById(id);
    }
}
