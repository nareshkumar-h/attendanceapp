package com.training.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.DTO.StudentAttendanceDTO;
import com.training.Model.StudentAttandance;
import com.training.repository.StudentAttandanceRepository;

@Service
public class StudentAttandanceService {

	@Autowired
	StudentAttandanceRepository studentAttandanceRepository;

	public StudentAttandanceRepository getStudentAttandanceRepository() {
		return studentAttandanceRepository;
	}

	public void setStudentAttandanceRepository(
			StudentAttandanceRepository studentAttandanceRepository) {
		this.studentAttandanceRepository = studentAttandanceRepository;
	}

	public List<StudentAttandance> doGetStudentsByBatchIdAndTrainingDate(
			Long id, String date, String dept) {
		List<StudentAttandance> students = getStudentAttandanceRepository()
				.getStudentsByBatchIdAndTrainingDate(id, date, dept);

		students = students.stream().filter(s -> s != null).map(rh -> {
			if (rh.getCreatedDate().equals(rh.getModifiedDate())) {
				rh.setModified(false);
				return rh;
			} else {
				rh.setModified(true);
				return rh;
			}
		}).collect(Collectors.toList());

		return students;
	}

	public List<StudentAttendanceDTO> doGetStudentAttendanceList(String userName) {
		List<StudentAttendanceDTO> students = studentAttandanceRepository
				.getStudentAttendanceList(userName);
		students = students.stream().filter(s -> s != null).map(rh -> {
			if (rh.getCreatedDate().equals(rh.getModifiedDate())) {
				rh.setModified(false);
				return rh;
			} else {
				rh.setModified(true);
				return rh;
			}
		}).collect(Collectors.toList());

		return students;
	}

	public void doUpdateStudentAttendanceStatus(StudentAttandance student) {

		LocalDateTime today = LocalDateTime.now();
		studentAttandanceRepository.updateStudentAttendanceStatus(student,
				today);
	}

	public void doUpdateAllStudentsAttendanceStatus(
			List<StudentAttandance> student) {

		LocalDateTime today = LocalDateTime.now();
		studentAttandanceRepository.updateAllStudentsAttendanceStatus(student,
				today);
	}

	public void doUpdateStudentAttendance(StudentAttendanceDTO student) {
		LocalDateTime today = LocalDateTime.now();
		studentAttandanceRepository.updateStudentAttendance(student, today);
	}

	public void doUpdateAllTrainingDatesStudentAttendance(
			List<StudentAttendanceDTO> student) {
		LocalDateTime today = LocalDateTime.now();
		studentAttandanceRepository.updateAllStudentAttendance(student, today);
	}

	public List<StudentAttandance> doGetStudentsByBatchIdAndTrainingDate(
			Long id, String date) {
		List<StudentAttandance> students = getStudentAttandanceRepository()
				.getStudentsDepartments(id, date);
		return students;
	}

	public List<StudentAttendanceDTO> doGetStudentAttendanceInReviewList() {
		List<StudentAttendanceDTO> students = getStudentAttandanceRepository()
				.getStudentAttendanceInReviewList();
		return students;
	}

	public List<StudentAttendanceDTO> doGetStudentAttendanceInReviewListByCollege(
			String college) {
		List<StudentAttendanceDTO> students = getStudentAttandanceRepository()
				.getStudentAttendanceInReviewListByCollege(college);
		return students;
	}

	public void doUpdateStudentReviewAttendance(StudentAttendanceDTO student) {
		LocalDateTime today = LocalDateTime.now();
		studentAttandanceRepository.updateStudentReviewAttendance(student,
				today);

	}

	public void doUpdateReviewStatusOfStudent(StudentAttendanceDTO student) {
		LocalDateTime today = LocalDateTime.now();
		studentAttandanceRepository.updateReviewStudentStatus(student, today);
	}

	public void doFreezeAttendanceList(String trDate, boolean status) {
		studentAttandanceRepository.freezeAttendance(trDate, status);
	}

}
