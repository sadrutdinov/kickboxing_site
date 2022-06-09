package com.sai.kickboxing_site.services;

import com.sai.kickboxing_site.entities.cost_of_training.TrainingCost;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TrainingCostService {
    List<TrainingCost> getAll();

    TrainingCost save(TrainingCost trainingCost);

    TrainingCost getTrainingCost(int id);

    void deleteById(int id);

}
