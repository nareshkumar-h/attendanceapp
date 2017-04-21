package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.Model.College;
import com.training.service.CollegeService;

@CrossOrigin
@RestController
@RequestMapping("/colleges")
public class CollegeController {

	@Autowired
	CollegeService collegeService;

	@GetMapping("/list")
	public List<College> getBatches() {
		return collegeService.doGetCollegesList();
	}

}
