package com.training.DAO.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.Model.Batch;
import com.training.Model.Student;
import com.training.Model.Training;
import com.training.repository.BatchRepository;

@Repository
public class BatchDAOImpl implements BatchRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Batch convert(ResultSet rs) throws SQLException {
		Batch b = new Batch();
		b.setBatchId(rs.getLong("batch_no"));
		b.setBatchName(rs.getString("batch_name"));
		return b;

	}

	@Override
	public List<Batch> getBatchesBasedOnCollegeId(Long id) {
		String sql = "SELECT b.batch_no,b.batch_name FROM  batches b WHERE b.college_id=?";

		List<Batch> list = jdbcTemplate.query(sql, new Object[] { id }, (rs, rowNum) -> {
			return convert(rs);
		});
		return list;
	}

	@Override
	public List<Student> getDepartmentsByPassingBatchId(Long id) {
		String sql = "SELECT DISTINCT department FROM students s WHERE s.batch_id=?";

		List<Student> list = jdbcTemplate.query(sql, new Object[] { id }, (rs, rowNum) -> {
			return convertToStudentObj(rs);
		});
		return list;

	}

	private Student convertToStudentObj(ResultSet rs) throws SQLException {
		Student s = new Student();
		s.setDepartment(rs.getString("department"));
		return s;
	}

	@Override
	public List<Training> getTrainingDatesOfBatch(Long id) {
		String sql = "SELECT t.training_date FROM training t WHERE t.batch_id=?";

		List<Training> list = jdbcTemplate.query(sql, new Object[] { id }, (rs, rowNum) -> {
			return convertToTrainingObj(rs);
		});
		return list;
	}

	private Training convertToTrainingObj(ResultSet rs) {
		Training t = new Training();
		try {
			t.setTrDate(rs.getString("training_date"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;

	}

}