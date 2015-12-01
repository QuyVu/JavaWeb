package com.quyvd.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountDAO extends JdbcDaoSupport {

	@Autowired
	public AccountDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public Account findAccount(String email) {
		String sql = "Select a.email, a.password from account a where email = ?";
		Object[] params = new Object[] { email };
		AccountMapper mapper = new AccountMapper();
		Account acc = this.getJdbcTemplate().queryForObject(sql, params, mapper);
		return acc;
	}

	public int insertAccount(String email, String password) {
		String sql = "Insert into account (email,password) " + " values (?,?) ";
		Object[] params = new Object[] { email, password };
		try{
		return this.getJdbcTemplate().update(sql, params);
		}
		catch (CannotGetJdbcConnectionException ex){
			return 0;
		}
		catch (DuplicateKeyException e) {
			return -1;
		}
	}
}
