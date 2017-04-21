package com.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.repository.TrainingRepository;

@Service
public class TrainingService {

	@Autowired
	TrainingRepository trainingRepository;
}
