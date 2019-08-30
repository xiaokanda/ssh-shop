package com.pdsu.shop.service;

import com.pdsu.shop.entity.PageBean;
import com.pdsu.shop.entity.User;

public interface UserService {

	User findByUserName(String username);

	void save(User user);

	User login(User user);

	void update(User user);

	public PageBean<User> findByPage(Integer page);

	public User findByUid(Integer uid);

	public void delete(User existUser);
}
