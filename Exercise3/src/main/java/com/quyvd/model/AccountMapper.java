package com.quyvd.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountMapper implements RowMapper<Account> {
	 
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        String email = rs.getString("email");
        String password = rs.getString("password");
 
        return new Account(email,password);
    }
 
}