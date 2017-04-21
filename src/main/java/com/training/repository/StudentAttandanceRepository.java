package com.training.repository;

import java.util.List;

import com.training.Model.StudentAttandance;

public interface StudentAttandanceRepository {

	List<StudentAttandance> getStudentsByBatchIdAndTrainingDate(Long id, String date, String dept);

	void updateStudentAttendanceStatus(StudentAttandance student);

	void updateAllStudentsAttendanceStatus(List<StudentAttandance> student);

}
