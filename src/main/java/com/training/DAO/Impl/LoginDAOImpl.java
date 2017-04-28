package com.training.DAO.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.Model.Role;
import com.training.Model.Users;
import com.training.repository.LoginRepository;

@Repository
public class LoginDAOImpl implements LoginRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Users convert(ResultSet rs) throws SQLException {
		Users u = new Users();
		u.setUserId(rs.getLong("id"));
		u.setName(rs.getString("name"));
		u.setUserName(rs.getString("userName"));
		u.setPassword(rs.getString("password"));
		Role r = new Role();
		r.setRoleName(rs.getString("role_name"));
		u.setRole(r);
		return u;
	}

	@Override
	public List<Users> getFindByUserName(String userName) {
		String sql = "SELECT u.id,u.name,u.userName,u.password,r.role_name FROM users u JOIN role r ON u.role=r.id WHERE u.userName=?";

		List<Users> list = jdbcTemplate.query(sql, new Object[] { userName }, (rs, rowNum) -> {
			return convert(rs);
		});
		return list;
	}
}