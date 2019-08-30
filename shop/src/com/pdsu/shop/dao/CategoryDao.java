package com.pdsu.shop.dao;

import java.util.List;

import com.pdsu.shop.entity.Category;

public interface CategoryDao {
	public List<Category> findAll();

	public void save(Category category);

	public Category findByCid(Integer cid);

	public void delete(Category category);

	public void update(Category category);
}
