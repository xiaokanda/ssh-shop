package com.pdsu.shop.dao;

import java.util.List;

import com.pdsu.shop.entity.User;

public interface UserDao {

	User findByUserName(String username);

	void save(User user);

	User login(User user);

	void update(User user);

	public int findCount();

	public List<User> findByPage(int begin, int limit);

	public User findByUid(Integer uid);

	public void delete(User existUser);
}
