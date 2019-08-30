package com.pdsu.shop.dao;

import java.util.List;

import com.pdsu.shop.entity.Product;

public interface ProductDao {

	public List<Product> findHot();

	public List<Product> findNew();

	public Product findByPid(Integer pid);

	public int findCountCid(Integer cid);

	public List<Product> findByPageCid(Integer cid, int begin, int limit);

	public int findCountCsid(Integer csid);

	public List<Product> findByPageCsid(Integer csid, int begin, int limit);

	public int findCount();

	public List<Product> findByPage(int begin, int limit);

	public void save(Product product);

	public void delete(Product product);

	public void update(Product product);
}
