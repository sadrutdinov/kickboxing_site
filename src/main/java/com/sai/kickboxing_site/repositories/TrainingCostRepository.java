package com.sai.kickboxing_site.repositories;

import com.sai.kickboxing_site.models.TrainingCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCostRepository extends JpaRepository<TrainingCost, Integer> {
}
