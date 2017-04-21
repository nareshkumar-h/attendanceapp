package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Model.Batch;
import com.training.Model.Student;
import com.training.Model.Training;
import com.training.repository.BatchRepository;

@Service
public class BatchService {

	@Autowired
	BatchRepository batchRepository;

	public List<Batch> doGetBatchesBasedOnCollegeId(Long id) {
		return batchRepository.getBatchesBasedOnCollegeId(id);
	}

	public List<Student> doGetDepartmentsOfCollege(Long id) {
		return batchRepository.getDepartmentsByPassingBatchId(id);
	}

	public List<Training> doGetTrainingDatesOfBatch(Long id) {
		return batchRepository.getTrainingDatesOfBatch(id);
	}
}

