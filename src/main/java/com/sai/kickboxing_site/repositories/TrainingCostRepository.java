package com.sai.kickboxing_site.repositories;

import com.sai.kickboxing_site.entities.cost_of_training.TrainingCost;
import org.springframework.data.repository.CrudRepository;

public interface TrainingCostRepository extends CrudRepository<TrainingCost, Integer> {
}
