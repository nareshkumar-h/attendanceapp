package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.service.TrainingService;

@RestController
@RequestMapping("/tr")
public class TrainingController {

	@Autowired
	TrainingService trainingService;

	public TrainingService getTrainingService() {
		return trainingService;
	}

	public void setTrainingService(TrainingService trainingService) {
		this.trainingService = trainingService;
	}

}
