package com.sai.kickboxing_site.repositories;

import com.sai.kickboxing_site.models.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {
}
