package com.training.DAO.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.DTO.StudentAttendanceDTO;
import com.training.repository.AttendanceReportRepository;

@Repository
public class AttendanceReportDAOImpl implements AttendanceReportRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private StudentAttendanceDTO convert(ResultSet rs) throws SQLException {
		StudentAttendanceDTO student = new StudentAttendanceDTO();
		student.setTotalAttended(rs.getLong(1));
		student.setsName(rs.getString(2));
		student.setEmail(rs.getString(3));
		student.setDept(rs.getString(4));
		student.setTotalSession(rs.getLong(5));
		student.setAttendancePercentage(rs.getLong(6));
		return student;
	}

	@Override
	public List<StudentAttendanceDTO> getStudentsDeptWiseAttendanceReport(
			Long id, String dept) {
		StringBuilder sql = new StringBuilder(
				"SELECT (SELECT COUNT(*) FROM attendance WHERE student_id=a.student_id AND attended=1) totalAttended,a.name AS sName,a.email AS email,a.department dept,"
						+ "a.total_session totalSession,attendance_percentage((SELECT COUNT(*) FROM attendance "
						+ "WHERE student_id = a.student_id AND attended = 1),a.total_session)  AS attendancePercentage "
						+ "FROM (SELECT aa.student_id,s.name,s.email,s.department,COUNT(aa.id) AS total_session "
						+ "FROM attendance aa JOIN students s ON aa.student_id = s.id WHERE s.batch_id =? ");

		if (dept.equals("null")) {

			sql.append("GROUP BY student_id) a ORDER BY attendancePercentage DESC , a.department ");

			return jdbcTemplate.query(sql.toString(), new Object[] { id }, (rs,
					rowNum) -> {
				return convert(rs);
			});

		} else {
			sql.append("AND s.department=? GROUP BY student_id) a ORDER BY attendancePercentage DESC , a.department");
			return jdbcTemplate.query(sql.toString(),
					new Object[] { id, dept }, (rs, rowNum) -> {
						return convert(rs);
					});
		}

	}

}
