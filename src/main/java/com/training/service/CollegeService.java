package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Model.College;
import com.training.repository.CollegeRepository;

@Service
public class CollegeService {

	@Autowired
	CollegeRepository collegeRepository;

	public List<College> doGetCollegesList() {
		// TODO Auto-generated method stub
		return collegeRepository.getCollegesList();
	}
}
