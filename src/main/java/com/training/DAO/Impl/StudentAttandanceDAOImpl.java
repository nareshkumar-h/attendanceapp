package com.training.DAO.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.DTO.StudentAttendanceDTO;
import com.training.Model.Student;
import com.training.Model.StudentAttandance;
import com.training.repository.StudentAttandanceRepository;

/**
 * This class Represents Students Attendance.
 */
@Repository
public class StudentAttandanceDAOImpl implements StudentAttandanceRepository {
	private static final String UPDATEQUERY = "UPDATE attandance SET attended=?,reason=?,modified_date=?,modified_by=? WHERE ID=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private StudentAttandance convert(ResultSet rs) throws SQLException {

		Student s = new Student();
		s.setName(rs.getString("name"));
		s.setDepartment(rs.getString("department"));
		s.setEmail(rs.getString("email"));
		s.setMobileNo(rs.getString("mobile_no"));
		s.setBatchId(rs.getLong("batch_id"));
		StudentAttandance student = new StudentAttandance();
		student.setId(rs.getLong("id"));
		student.setReason(rs.getString("reason"));
		student.setAttended(rs.getBoolean("attended"));
		student.setCreatedDate(rs.getTimestamp(8).toLocalDateTime());
		student.setModifiedDate(rs.getTimestamp(9).toLocalDateTime());
		student.setStudentId(s);

		return student;

	}

	@Override
	public List<StudentAttandance> getStudentsByBatchIdAndTrainingDate(Long id, String date, String dept) {
		List<StudentAttandance> list = null;
		StringBuilder sql = new StringBuilder(
				"SELECT sa.id, s.name,s.email,s.department,s.mobile_no,sa.attended,sa.reason,sa.created_date,"
						+ "sa.modified_date,s.batch_id FROM training t "
						+ "JOIN  attandance sa ON t.id=sa.training_id JOIN students s ON sa.student_id=s.id "
						+ "WHERE t.batch_id=? AND t.training_date=? AND s.department=?");

		list = jdbcTemplate.query(sql.toString(), new Object[] { id, date, dept }, (rs, rowNum) -> {
			return convert(rs);
		});
		return list;
	}

	@Override
	public void updateStudentAttendanceStatus(StudentAttandance studentAttandance, LocalDateTime modifiedDate) {
		jdbcTemplate.update(UPDATEQUERY, studentAttandance.isAttended(), studentAttandance.getReason(), modifiedDate,
				studentAttandance.getModifiedBy(), studentAttandance.getId());

	}

	@Override
	public void updateAllStudentsAttendanceStatus(List<StudentAttandance> studentList, LocalDateTime modifiedDate) {
		for (StudentAttandance s : studentList) {

			jdbcTemplate.update(UPDATEQUERY, s.isAttended(), s.getReason(), modifiedDate, s.getModifiedBy(), s.getId());

		}
	}

	@Override
	public void updateStudentAttendance(StudentAttendanceDTO student, LocalDateTime modifiedDate) {
		jdbcTemplate.update(UPDATEQUERY, student.isAttended(), student.getReason(), modifiedDate,
				student.getModifiedBy(), student.getStudentAttendanceId());
	}

	@Override
	public void updateAllStudentAttendance(List<StudentAttendanceDTO> student, LocalDateTime modifiedDate) {
		for (StudentAttendanceDTO s : student) {
			jdbcTemplate.update(UPDATEQUERY, s.isAttended(), s.getReason(), modifiedDate, s.getModifiedBy(),
					s.getStudentAttendanceId());

		}

	}

	@Override
	public List<StudentAttendanceDTO> getStudentAttendanceList(String userName) {
		List<StudentAttendanceDTO> list = null;
		StringBuilder sql = new StringBuilder(
				"SELECT s.name,s.email,s.department,s.mobile_no,a.attended,a.id,a.reason,a.created_date,a.modified_date,"
						+ "c.name,s.batch_id,b.batch_name,t.training_date FROM attandance a JOIN students s ON "
						+ "a.student_id=s.id JOIN batches b ON b.batch_no=s.batch_id JOIN colleges c ON c.`id`=b.`college_id`"
						+ " JOIN training t ON a.training_id=t.id WHERE s.email=?");

		list = jdbcTemplate.query(sql.toString(), new Object[] { userName }, (rs, rowNum) -> {
			return convertToStudentObj(rs);
		});

		return list;
	}

	private StudentAttendanceDTO convertToStudentObj(ResultSet rs) throws SQLException {

		StudentAttendanceDTO student = new StudentAttendanceDTO();
		student.setsName(rs.getString(1));
		student.setEmail(rs.getString("email"));
		student.setDept(rs.getString("department"));
		student.setMobileNo(rs.getString("mobile_no"));
		student.setAttended(rs.getBoolean("attended"));
		student.setStudentAttendanceId(rs.getLong("id"));
		student.setReason(rs.getString("reason"));
		student.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
		student.setModifiedDate(rs.getTimestamp("modified_date").toLocalDateTime());
		student.setCollegeName(rs.getString(10));
		student.setBatchId(rs.getLong("batch_id"));
		student.setBatchName(rs.getString("batch_name"));
		student.setTrDate(rs.getString("training_date"));

		return student;

	}

	@Override
	public List<StudentAttandance> getStudentsDepartments(Long id, String date) {
		List<StudentAttandance> list = null;
		StringBuilder sql = new StringBuilder(
				"SELECT sa.id, s.name,s.email,s.department,s.mobile_no,sa.attended,sa.reason,sa.created_date,"
						+ "sa.modified_date,s.batch_id FROM training t "
						+ "JOIN  attandance sa ON t.id=sa.training_id JOIN students s ON sa.student_id=s.id "
						+ "WHERE t.batch_id=? AND t.training_date=?");

		list = jdbcTemplate.query(sql.toString(), new Object[] { id, date}, (rs, rowNum) -> {
			return convert(rs);
		});
		return list;
	}

	@Override
	public List<StudentAttendanceDTO> getStudentAttendanceInReviewList() {
		List<StudentAttendanceDTO> list = null;
		StringBuilder sql = new StringBuilder(
				"SELECT a.`id`,s.`name`,s.`email`,s.`department`,s.`mobile_no`,a.`reason`,c.`name` FROM attandance a JOIN students s"
				+ " ON s.`id`=a.`student_id` LEFT JOIN `batches` b ON s.`batch_id`=b.`batch_no` LEFT JOIN `colleges` c "
				+ "ON b.`college_id`=c.`id` WHERE a.`review_status`=1;");

		list = jdbcTemplate.query(sql.toString(), new Object[] {  }, (rs, rowNum) -> {
			return convertToStudent(rs);
		});

		return list;
	}
	
	
	private StudentAttendanceDTO convertToStudent(ResultSet rs) throws SQLException {

		StudentAttendanceDTO student = new StudentAttendanceDTO();
		student.setId(rs.getLong("id"));
		student.setsName(rs.getString("name"));
		student.setEmail(rs.getString("email"));
		student.setDept(rs.getString("department"));
		student.setMobileNo(rs.getString("mobile_no"));
		
		student.setReason(rs.getString("reason"));
		//student.setModifiedDate(rs.getTimestamp("modified_date").toLocalDateTime());
		student.setCollegeName(rs.getString(7));
		//
		return student;

	}

	@Override
	public List<StudentAttendanceDTO> getStudentAttendanceInReviewListByCollege(String college) {
		List<StudentAttendanceDTO> list = null;
		StringBuilder sql = new StringBuilder(
				"SELECT a.`id`,s.`name`,s.`email`,s.`department`,s.`mobile_no`,a.`reason`,c.`name` FROM attandance a JOIN students s"
				+ " ON s.`id`=a.`student_id` LEFT JOIN `batches` b ON s.`batch_id`=b.`batch_no` LEFT JOIN `colleges` c "
				+ "ON b.`college_id`=c.`id` WHERE a.`review_status`=1 AND c.`name`=?;");

		list = jdbcTemplate.query(sql.toString(), new Object[] { college }, (rs, rowNum) -> {
			return convertToStudent(rs);
		});

		return list;
	}

	@Override
	public void updateStudentReviewAttendance(StudentAttendanceDTO student,
			LocalDateTime modifiedDate) {
		jdbcTemplate.update("UPDATE attandance a SET a.`modified_by`=?,a.`reviewd_by`=?,a.`review_status`=?,a.`modified_date`=? WHERE a.`id`=?", student.getModifiedBy(),student.getReviewdBy(),student.getReviewStatus(), modifiedDate,
				student.getId());
	
		
	}

	

}
