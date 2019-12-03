package com.dxc.cafe2.dao;

import java.util.List;

import com.dxc.cafe2.model.Counter;


public interface CounterDao {
	void addItem(Counter item);

	Counter getItem(String id);

	boolean isItemExists(String id);

	void deleteItem(String id);

	void updateItem(Counter item);

	List<Counter> getItems();

	Counter getItemByUserName(String email);
}
