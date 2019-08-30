package com.pdsu.shop.service;

import java.util.List;

import com.pdsu.shop.entity.Order;
import com.pdsu.shop.entity.OrderItem;
import com.pdsu.shop.entity.PageBean;

public interface OrderService {
	public void save(Order order);

	public PageBean<Order> findByUid(Integer uid, Integer page);

	public Order findByOid(Integer oid);

	public void update(Order currOrder);

	public PageBean<Order> findAll(Integer page);

	public List<OrderItem> findOrderItem(Integer oid);
}
