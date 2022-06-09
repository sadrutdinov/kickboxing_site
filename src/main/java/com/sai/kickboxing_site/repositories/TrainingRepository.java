package com.sai.kickboxing_site.repositories;

import com.sai.kickboxing_site.entities.training_schedule.Training;
import org.springframework.data.repository.CrudRepository;

public interface TrainingRepository extends CrudRepository<Training, Integer> {
}
