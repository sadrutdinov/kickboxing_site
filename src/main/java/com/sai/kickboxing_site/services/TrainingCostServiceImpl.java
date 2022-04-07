package com.sai.kickboxing_site.services;

import com.sai.kickboxing_site.entities.cost_of_training.TrainingCost;
import com.sai.kickboxing_site.repositories.TrainingCostRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class TrainingCostServiceImpl implements TrainingCostService {


    private TrainingCostRepository repository;

    @Override
    public Iterable<TrainingCost> getAll() {
        return repository.findAll();
    }

    @Override
    public TrainingCost save(TrainingCost trainingCost) {
        return repository.save(trainingCost);
    }

    @Override
    public TrainingCost getTrainingCost(int id) {
        Optional<TrainingCost> trainingCost = repository.findById(id);
        return trainingCost.orElse(null);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
