package com.training.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.training.DTO.StudentAttendanceDTO;
import com.training.Model.StudentAttandance;

public interface StudentAttandanceRepository {

	List<StudentAttandance> getStudentsByBatchIdAndTrainingDate(Long id,
			String date, String dept);

	void updateStudentAttendanceStatus(StudentAttandance student,
			LocalDateTime modifiedDate);

	void updateAllStudentsAttendanceStatus(List<StudentAttandance> student,
			LocalDateTime modifiedDate);

	List<StudentAttendanceDTO> getStudentAttendanceList(String userName);

	void updateStudentAttendance(StudentAttendanceDTO student,
			LocalDateTime modifiedDate);

	void updateAllStudentAttendance(List<StudentAttendanceDTO> student,
			LocalDateTime today);

	List<StudentAttandance> getStudentsDepartments(Long id, String date);

	List<StudentAttendanceDTO> getStudentAttendanceInReviewList();

	List<StudentAttendanceDTO> getStudentAttendanceInReviewListByCollege(
			String college);

	void updateStudentReviewAttendance(StudentAttendanceDTO student,
			LocalDateTime today);

	void updateReviewStudentStatus(StudentAttendanceDTO student,
			LocalDateTime today);

	void freezeAttendance(String trDate, boolean status);

}
