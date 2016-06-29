package com.quyvd.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDaoImpl extends JdbcDaoSupport  implements UserDao {

	@Autowired
	public UserDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public int editUser(User user) {
		String sql = "UPDATE data SET name = ?, password = ? WHERE id = ?";
		Object[] params = new Object[] { user.getName(), user.getPassword(), user.getId() };
		try {
			return this.getJdbcTemplate().update(sql, params);
		} catch (CannotGetJdbcConnectionException ex) {
			return -1;
		} catch (DuplicateKeyException e) {
			return 0;
		}
	}

	public User getUserById(int userId) {
		String sql = "SELECT * FROM data WHERE id=?";
		UserMapper uMap = new UserMapper();
		Object[] params = new Object[] {userId};
		User user = this.getJdbcTemplate().queryForObject(sql, params, uMap);
		return user;
	}

	public List<User> listAll() {
		String sql = "SELECT * FROM data order by id limit 10000";
		UserMapper uMap = new UserMapper();
		List<User> list = this.getJdbcTemplate().query(sql, uMap);
		return list;
	}

}
