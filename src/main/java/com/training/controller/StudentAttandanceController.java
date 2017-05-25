package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.DTO.StudentAttendanceDTO;
import com.training.Model.StudentAttandance;
import com.training.service.StudentAttandanceService;

@CrossOrigin
@RestController
@RequestMapping("/attendance")
public class StudentAttandanceController {

	@Autowired
	StudentAttandanceService studentAttandanceService;

	@GetMapping("/Student/batch/{id}/trainingDate/{date}/dept/{dept}")
	public List<StudentAttandance> getBatches(@PathVariable("id") Long id,
			@PathVariable("date") String date, @PathVariable("dept") String dept) {
		return studentAttandanceService.doGetStudentsByBatchIdAndTrainingDate(
				id, date, dept);
	}

	@GetMapping("/Student/batch/{id}/trainingDate/{date}")
	public List<StudentAttandance> getBatchesForAllDepartments(
			@PathVariable("id") Long id, @PathVariable("date") String date) {
		return studentAttandanceService.doGetStudentsByBatchIdAndTrainingDate(
				id, date);
	}
	
	@GetMapping("/student")
	public List<StudentAttendanceDTO> getStudentAttendanceList(
			@RequestParam(value = "userName") String userName) {
		return studentAttandanceService.doGetStudentAttendanceList(userName);
	}

	@PutMapping("student/update")
	public void updateStudentAttendance(
			@RequestBody StudentAttendanceDTO student) {
		studentAttandanceService.doUpdateStudentAttendance(student);
	}

	@PutMapping
	public void updateStudentList(@RequestBody List<StudentAttandance> student) {
		studentAttandanceService.doUpdateAllStudentsAttendanceStatus(student);
	}

	@PutMapping("/update")
	public void updateStudent(@RequestBody StudentAttandance student) {
		studentAttandanceService.doUpdateStudentAttendanceStatus(student);
	}

	@PutMapping("/updateAll")
	public void updateAllTrainingDatesStudentAttendance(
			@RequestBody List<StudentAttendanceDTO> student) {
		studentAttandanceService
				.doUpdateAllTrainingDatesStudentAttendance(student);
	}

	@GetMapping("/studentReview")
	public List<StudentAttendanceDTO> getStudentAttendanceInReviewList() {
		return studentAttandanceService.doGetStudentAttendanceInReviewList();
	}

	@GetMapping("/InReview/byCollege/{college}")
	public List<StudentAttendanceDTO> getStudentAttendanceInReviewListByCollege(
			@PathVariable("college") String college) {
		return studentAttandanceService
				.doGetStudentAttendanceInReviewListByCollege(college);
	}

	@PutMapping("/review/update")
	public void updateStudentReviewAttendance(
			@RequestBody StudentAttendanceDTO student) {
		studentAttandanceService.doUpdateStudentReviewAttendance(student);
	}

	@PutMapping("/request/byStudent")
	public void updateReviewStatusOfStudent(
			@RequestBody StudentAttendanceDTO student) {
		studentAttandanceService.doUpdateReviewStatusOfStudent(student);
	}

	@PutMapping("/freezeAttendance")
	public void updateReviewStatusOfList(
			@RequestParam(value = "trDate") String trDate,
			@RequestParam(value = "freezed") boolean status) {
		System.out.println(trDate + " " + status);
		studentAttandanceService.doFreezeAttendanceList(trDate, status);
	}
}
