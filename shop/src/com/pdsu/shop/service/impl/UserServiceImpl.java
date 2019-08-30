package com.pdsu.shop.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pdsu.shop.dao.UserDao;
import com.pdsu.shop.entity.PageBean;
import com.pdsu.shop.entity.User;
import com.pdsu.shop.service.UserService;
import com.pdsu.shop.utils.MD5Utils;

@Transactional
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	// 按照名字查询用户
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	// 保存用户
	public void save(User user) {
		user.setState(1);
		user.setPassword(MD5Utils.md5(user.getPassword()));
		userDao.save(user);
	}

	@Override
	// 用户登录
	public User login(User user) {
		user.setPassword(MD5Utils.md5(user.getPassword()));
		return userDao.login(user);
	}

	@Override
	public void update(User user) {
		user.setState(1);
		user.setPassword(MD5Utils.md5(user.getPassword()));
		userDao.update(user);
	}

	// 业务层用户查询所有
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = userDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1) * limit;
		List<User> list = userDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	public User findByUid(Integer uid) {
		return userDao.findByUid(uid);
	}

	public void delete(User existUser) {
		userDao.delete(existUser);
	}
}
