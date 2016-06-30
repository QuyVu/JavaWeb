package com.quyvd.model;

import java.util.List;

import com.quyvd.model.User;

public interface UserDao {
	public int addUser(User user);
	public int editUser(User user);
	public User getUserById(int userId);
	public List<User> listAll(int offset);
	public List<User> search(String key, int offset, int limit);
	public int count(String key);
}
