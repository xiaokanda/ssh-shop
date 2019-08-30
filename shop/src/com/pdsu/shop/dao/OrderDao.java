package com.pdsu.shop.dao;

import java.util.List;

import com.pdsu.shop.entity.Order;
import com.pdsu.shop.entity.OrderItem;

public interface OrderDao {
	public void save(Order order);

	public int findCountByUid(Integer uid);

	public List<Order> findPageByUid(Integer uid, int begin, int limit);

	public Order findByOid(Integer oid);

	public void update(Order currOrder);

	public int findCount();

	public List<Order> findByPage(int begin, int limit);

	public List<OrderItem> findOrderItem(Integer oid);
}
