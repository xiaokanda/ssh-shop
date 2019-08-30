package com.pdsu.shop.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.pdsu.shop.dao.UserDao;
import com.pdsu.shop.entity.PageHibernateCallback;
import com.pdsu.shop.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	// 按照名字查找用户
	public User findByUserName(String username) {
		String hql = "from User where username = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 保存用户
	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	// 用户登录
	public User login(User user) {
		String hql = "from User where username = ? and password = ? and state = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getUsername(), user.getPassword(), 1);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	public int findCount() {
		String hql = "select count(*) from User";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<User> findByPage(int begin, int limit) {
		String hql = "from User";
		List<User> list = this.getHibernateTemplate().execute(new PageHibernateCallback<User>(hql, null, begin, limit));
		return list;
	}

	public User findByUid(Integer uid) {
		return this.getHibernateTemplate().get(User.class, uid);
	}

	public void delete(User existUser) {
		this.getHibernateTemplate().delete(existUser);
	}

}
