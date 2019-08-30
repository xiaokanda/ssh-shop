package com.pdsu.shop.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.pdsu.shop.dao.AdminUserDao;
import com.pdsu.shop.entity.AdminUser;

public class AdminUserDaoImpl extends HibernateDaoSupport implements AdminUserDao{

	// Dao完成登录的代码
	public AdminUser login(AdminUser adminUser) {
		String hql = "from AdminUser where username = ? and password = ?";
		List<AdminUser> list = (List<AdminUser>) this.getHibernateTemplate().find(hql, adminUser.getUsername(),adminUser.getPassword());
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
