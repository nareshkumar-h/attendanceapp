package com.training.DAO.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.Model.Student;
import com.training.Model.StudentAttandance;
import com.training.repository.StudentAttandanceRepository;

/**
 * This class Represents Students Attendance.
 */
@Repository
public class StudentAttandanceDAOImpl implements StudentAttandanceRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private StudentAttandance convert(ResultSet rs) throws SQLException {

		Student s = new Student();
		s.setName(rs.getString("name"));
		s.setDepartment(rs.getString("department"));
		s.setEmail(rs.getString("email"));
		s.setMobileNo(rs.getString("mobile_no"));
		StudentAttandance student = new StudentAttandance();
		student.setId(rs.getLong("id"));
		student.setReason(rs.getString("reason"));
		student.setAttended(rs.getBoolean("attended"));
		student.setStudentId(s);

		return student;

	}

	@Override
	public List<StudentAttandance> getStudentsByBatchIdAndTrainingDate(Long id, String date, String dept) {
		List<StudentAttandance> list = null;
		StringBuilder sql = new StringBuilder(
				"SELECT sa.id, s.name,s.email,s.department,s.mobile_no,sa.attended,sa.reason FROM training t "
						+ "JOIN  attandance sa ON t.id=sa.training_id JOIN students s ON sa.student_id=s.id "
						+ "WHERE t.batch_id=? AND t.training_date=? ");
		if (!dept.equals("null")) {

			sql.append("AND s.department=?");
			list = jdbcTemplate.query(sql.toString(), new Object[] { id, date, dept }, (rs, rowNum) -> {
				return convert(rs);
			});
		} else {
			list = jdbcTemplate.query(sql.toString(), new Object[] { id, date }, (rs, rowNum) -> {
				return convert(rs);
			});
		}

		return list;
	}

	@Override
	public void updateStudentAttendanceStatus(StudentAttandance studentAttandance) {
		String sql = "UPDATE attandance SET attended=?,reason=? WHERE ID=? ";

		Integer rows = jdbcTemplate.update(sql, studentAttandance.isAttended(), studentAttandance.getReason(),
				studentAttandance.getId());

		System.out.println("No of rows Changed:" + rows);
	}

	@Override
	public void updateAllStudentsAttendanceStatus(List<StudentAttandance> studentList) {
		for (StudentAttandance s : studentList) {

			String sql = "UPDATE attandance SET attended=?,reason=? WHERE ID=? ";

			jdbcTemplate.update(sql, s.isAttended(), s.getReason(), s.getId());

		}
	}
}
