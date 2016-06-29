package com.quyvd.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.quyvd.model.User;

public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet resSet, int rowNum) throws SQLException {
		int id = resSet.getInt("id");
		String name = resSet.getString("name");
		String password = resSet.getString("password");
		return new User(id,name,password);
	}

}
