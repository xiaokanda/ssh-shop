package com.pdsu.shop.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pdsu.shop.dao.CategoryDao;
import com.pdsu.shop.entity.Category;
import com.pdsu.shop.service.CategoryService;

/**
 * 一级分类的业务层对象
 */
@Transactional
public class CategoryServiceImpl implements CategoryService {
	// 注入CategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	// 业务层查询所有一级分类的方法
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	// 业务层保存一级分类的操作
	public void save(Category category) {
		categoryDao.save(category);
	}

	// 业务层根据一级分类id查询一级分类
	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}

	// 业务层删除一级分类
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	// 业务层修改一级分类
	public void update(Category category) {
		categoryDao.update(category);
	}
}
