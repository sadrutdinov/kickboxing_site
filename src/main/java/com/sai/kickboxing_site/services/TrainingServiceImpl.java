package com.sai.kickboxing_site.services;

import com.sai.kickboxing_site.entities.training_schedule.Training;
import com.sai.kickboxing_site.repositories.TrainingRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class TrainingServiceImpl implements TrainingService {

    private TrainingRepository repository;

    @Override
    public List<Training> getAllTraining() {
        List<Training> allTraining =
                StreamSupport.stream(repository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return allTraining;
    }

    @Override
    public Training save(Training training) {
        return repository.save(training);
    }

    @Override
    public Training getTrainingById(int id) {
        Optional<Training> training = repository.findById(id);
        return training.orElse(null);
    }

    @Override
    public void deleteTrainingById(int id) {
        repository.deleteById(id);
    }
}
