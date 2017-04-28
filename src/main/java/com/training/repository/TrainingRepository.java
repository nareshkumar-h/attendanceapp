package com.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.Model.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

	@Query(value = "SELECT * FROM `training` t WHERE t.batch_id=?1", nativeQuery = true)
	List<Training> getTrainingDatesOfBatch(Long id);

}
