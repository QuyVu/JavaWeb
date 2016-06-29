package com.quyvd.model;

import java.util.List;

import com.quyvd.model.User;

public interface UserDao {
	public int editUser(User user);

	public User getUserById(int userId);

	public List<User> listAll();
}
