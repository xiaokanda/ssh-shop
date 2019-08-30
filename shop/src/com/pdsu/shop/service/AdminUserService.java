package com.pdsu.shop.service;

import com.pdsu.shop.dao.AdminUserDao;
import com.pdsu.shop.entity.AdminUser;

public interface AdminUserService {
	public void setAdminUserDao(AdminUserDao adminUserDao);
	public AdminUser login(AdminUser adminUser);
}
