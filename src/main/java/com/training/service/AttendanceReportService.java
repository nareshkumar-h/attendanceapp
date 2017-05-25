package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.DTO.StudentAttendanceDTO;
import com.training.repository.AttendanceReportRepository;

@Service
public class AttendanceReportService {

	@Autowired
	AttendanceReportRepository attendanceReportRepository;

	public List<StudentAttendanceDTO> doGetStudentsDeptWiseAttendanceReport(Long id, String dept) {
		return attendanceReportRepository.getStudentsDeptWiseAttendanceReport(id, dept);
	}

}
