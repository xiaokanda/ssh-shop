package com.pdsu.shop.service;

import java.util.List;

import com.pdsu.shop.entity.PageBean;
import com.pdsu.shop.entity.Product;

public interface ProductService {

	List<Product> findHot();

	List<Product> findNew();

	public Product findByPid(Integer pid);

	public PageBean<Product> findByPageCid(Integer cid, int page);

	public PageBean<Product> findByPageCsid(Integer csid, int page);

	public PageBean<Product> findByPage(Integer page);

	public void save(Product product);

	public void delete(Product product);

	public void update(Product product);
}
