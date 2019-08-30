package com.pdsu.shop.dao;

import java.util.List;

import com.pdsu.shop.entity.CategorySecond;

public interface CategorySecondDao {
	public int findCount();

	public List<CategorySecond> findByPage(int begin, int limit);

	public void save(CategorySecond categorySecond);

	public void delete(CategorySecond categorySecond);

	public CategorySecond findByCsid(Integer csid);

	public void update(CategorySecond categorySecond);

	public List<CategorySecond> findAll();
}
