package com.pdsu.shop.service;

import java.util.List;

import com.pdsu.shop.entity.CategorySecond;
import com.pdsu.shop.entity.PageBean;

public interface CategorySecondService {
	public PageBean<CategorySecond> findByPage(Integer page);

	public void save(CategorySecond categorySecond);

	public void delete(CategorySecond categorySecond);

	public CategorySecond findByCsid(Integer csid);

	public void update(CategorySecond categorySecond);

	public List<CategorySecond> findAll();
}
