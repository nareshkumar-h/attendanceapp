package com.training.DAO.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.Model.College;
import com.training.repository.CollegeRepository;

@Repository
public class CollegeDAOImpl implements CollegeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private College convert(ResultSet rs) throws SQLException {
		College c = new College();
		c.setId(rs.getLong("id"));
		c.setName(rs.getString("name"));
		return c;
	}

	@Override
	public List<College> getCollegesList() {
		String sql = "SELECT id,name FROM colleges";

		List<College> list = jdbcTemplate.query(sql, new Object[] {}, (rs, rowNum) -> {
			return convert(rs);
		});
		return list;
	}

}