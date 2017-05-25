package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.DTO.StudentAttendanceDTO;
import com.training.service.AttendanceReportService;

@CrossOrigin
@RestController
@RequestMapping("/attendanceReport")
public class AttendanceReportController {

	@Autowired
	AttendanceReportService attendanceReportService;

	@GetMapping("/Student/batch/{id}/dept/{dept}")
	public List<StudentAttendanceDTO> getDepartmentWiseAttendanceReport(
			@PathVariable("id") Long id, @PathVariable("dept") String dept) {
		return attendanceReportService.doGetStudentsDeptWiseAttendanceReport(
				id, dept);

	}

}
