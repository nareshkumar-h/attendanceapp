package com.training.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.training.Model.Batch;
import com.training.Model.Student;
import com.training.Model.Training;

public interface BatchRepository {

	List<Batch> getBatchesBasedOnCollegeId(@Param("id") Long id);

	List<Student> getDepartmentsByPassingBatchId(Long id);

	List<Training> getTrainingDatesOfBatch(Long id);

}
