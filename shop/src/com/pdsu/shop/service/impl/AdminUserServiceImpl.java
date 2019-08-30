package com.pdsu.shop.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.pdsu.shop.dao.AdminUserDao;
import com.pdsu.shop.entity.AdminUser;
import com.pdsu.shop.service.AdminUserService;

@Transactional
public class AdminUserServiceImpl implements AdminUserService{
	// 注入Dao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	
}
