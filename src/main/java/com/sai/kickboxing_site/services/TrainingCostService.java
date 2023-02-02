package com.sai.kickboxing_site.services;

import com.sai.kickboxing_site.models.TrainingCost;
import com.sai.kickboxing_site.repositories.TrainingCostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TrainingCostService {
    private final TrainingCostRepository trainingCostRepository;

    public TrainingCostService(TrainingCostRepository trainingCostRepository) {
        this.trainingCostRepository = trainingCostRepository;
    }

    public List<TrainingCost> getAll() {
        List<TrainingCost> trainingCosts = trainingCostRepository.findAll();
        trainingCosts.sort(Comparator.comparing(TrainingCost::getDescription)
                .reversed().thenComparing(TrainingCost::getPrice));
        return trainingCosts;
    }

    public TrainingCost getTrainingCostById(int id) {
        Optional<TrainingCost> trainingCost = trainingCostRepository.findById(id);
        return trainingCost.orElse(null);
    }

    @Transactional
    public TrainingCost save(TrainingCost trainingCost) {
        return trainingCostRepository.save(trainingCost);
    }

    @Transactional
    public void deleteTrainingCostById(int id) {
        trainingCostRepository.deleteById(id);
    }
}
