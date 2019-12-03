package com.dxc.cafe2.dao;

import java.util.List;

import com.dxc.cafe2.model.Item;



public interface ItemDao {
	
	void addItem(Item item);

	Item getItem(String id);

	boolean isItemExists(String id);

	void deleteItem(String id);

	void updateItem(Item item);

	List<Item> getItems();

	List<Item> getItemByCuisine(String[] cuisine);

}
