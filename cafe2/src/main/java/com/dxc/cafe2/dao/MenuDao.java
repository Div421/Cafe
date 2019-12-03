package com.dxc.cafe2.dao;

import java.util.List;

import com.dxc.cafe2.model.Counter;
import com.dxc.cafe2.model.Item;
import com.dxc.cafe2.model.Menu;

public interface MenuDao {

	void addItems(Menu menu);
	

	Menu getItem(String id);

	boolean isItemExists(String id);

	void deleteItem(String id);

	

	List<Menu> getItems();




	List<Item> getItemsByCounterId(String id);

	
	void postdata(List<Item> items, Counter counter, String date);


	Menu getMenuByCounterId(String id);



	
	

}
