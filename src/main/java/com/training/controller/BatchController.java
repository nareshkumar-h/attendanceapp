package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.Model.Batch;
import com.training.Model.Student;
import com.training.Model.Training;
import com.training.service.BatchService;

@CrossOrigin
@RestController
@RequestMapping("/batches")
public class BatchController {

	@Autowired
	BatchService batchService;

	@GetMapping("/id/{id}")
	public List<Batch> getBatchesForCollege(@PathVariable("id") Long id) {
		return batchService.doGetBatchesBasedOnCollegeId(id);
	}

	@GetMapping("/batch/id/{id}")
	public List<Student> getDepartmentsOfCollege(@PathVariable("id") Long id) {
		return batchService.doGetDepartmentsOfCollege(id);
	}

	@GetMapping("/id/{id}/trDates")
	public List<Training> getTrainingDatesOfBatch(@PathVariable("id") Long id) {
		return batchService.doGetTrainingDatesOfBatch(id);
	}

}
