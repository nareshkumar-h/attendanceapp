package com.training.repository;

import java.util.List;

import com.training.DTO.StudentAttendanceDTO;

public interface AttendanceReportRepository {

	List<StudentAttendanceDTO> getStudentsDeptWiseAttendanceReport(Long id,
			String dept);

}
