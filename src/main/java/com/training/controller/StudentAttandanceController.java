package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.Model.StudentAttandance;
import com.training.service.StudentAttandanceService;

@CrossOrigin
@RestController
@RequestMapping("/attandance")
public class StudentAttandanceController {

	@Autowired
	StudentAttandanceService studentAttandanceService;

	@GetMapping("/Student/batch/{id}/trainingDate/{date}/dept/{dept}")
	public List<StudentAttandance> getBatches(@PathVariable("id") Long id, @PathVariable("date") String date,
			@PathVariable("dept") String dept) {
		return studentAttandanceService.doGetStudentsByBatchIdAndTrainingDate(id, date, dept);
	}

	@GetMapping("/Student/batch/{id}/trainingDate/{date}")
	public List<StudentAttandance> getBatches(@PathVariable("id") Long id, @PathVariable("date") String date) {
		return studentAttandanceService.doGetStudentsByBatchIdAndTrainingDate(id, date, null);
	}

	
	@PutMapping("/update")
	public void updateStudent(@RequestBody StudentAttandance student) {
		studentAttandanceService.doUpdateStudentAttendanceStatus(student);
	}

	@PutMapping
	public void updateStudentList(@RequestBody List<StudentAttandance> student) {
		studentAttandanceService.doUpdateAllStudentsAttendanceStatus(student);
	}

}
