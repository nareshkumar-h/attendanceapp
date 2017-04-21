package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.Model.StudentAttandance;
import com.training.repository.StudentAttandanceRepository;

@Service
public class StudentAttandanceService {

	@Autowired
	StudentAttandanceRepository studentAttandanceRepository;

	public StudentAttandanceRepository getStudentAttandanceRepository() {
		return studentAttandanceRepository;
	}

	public void setStudentAttandanceRepository(StudentAttandanceRepository studentAttandanceRepository) {
		this.studentAttandanceRepository = studentAttandanceRepository;
	}

	public List<StudentAttandance> doGetStudentsByBatchIdAndTrainingDate(Long id, String date, String dept) {

		return getStudentAttandanceRepository().getStudentsByBatchIdAndTrainingDate(id, date, dept);
	}

	public void doUpdateStudentAttendanceStatus(StudentAttandance student) {

		studentAttandanceRepository.updateStudentAttendanceStatus(student);
	}

	public void doUpdateAllStudentsAttendanceStatus(List<StudentAttandance> student) {

		studentAttandanceRepository.updateAllStudentsAttendanceStatus(student);
	}

}
