package com.dxc.cafe2.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.dxc.cafe2.model.Counter;
import com.dxc.cafe2.model.Item;
import com.dxc.cafe2.model.Menu;

@Repository
public class MenuDaoImpl implements MenuDao {
	@Autowired
	ItemDao itemDao;

	@Autowired
	MongoTemplate template;

	@Override
	public void addItems(Menu m) {
		System.out.println(m);
		template.save(m);
	}

	@Override
	public Menu getItem(String id) {
		return template.findById(id, Menu.class);

	}

	@Override
	public boolean isItemExists(String id) {
		Menu item = template.findById(id, Menu.class);
		if (item == null)
			return false;
		else
			return true;

	}

	@Override
	public void deleteItem(String id) {
		Menu item = new Menu();
		item.setId(id);
		template.remove(item);

	}

	@Override
	public List<Menu> getItems() {

		return template.findAll(Menu.class);

	}

	
	@Override
	public List<Item> getItemsByCounterId(String id) {
		System.out.println("Hiii");
		Menu m = template.findOne(new Query(Criteria.where("counter.id").is(id)), Menu.class);
		System.out.println("Menu" + m);
		//return m;
		return m.getMenuList();

	}
	
	@Override
	public Menu getMenuByCounterId(String id) {
		System.out.println("Hiii");
		Menu m = template.findOne(new Query(Criteria.where("counter.id").is(id)), Menu.class);
		System.err.println("Menu" + m);
		return m;
		//return m.getMenuList();

	}
	
	
	//receive counter id & list of item ids --> create menu object
	@Override
	public void postdata(List<Item> items,Counter counter, String date) {
		
		List<Item> itemList = new ArrayList();
//		for (String id: ids) {
//			 Item itm =itemDao.getItem(id);
//			 itemList.add(itm);
//	         System.out.println(id);
//	      }
		Query query = new Query();
		query.addCriteria(Criteria.where("counter.id").is(counter.getId()));

		Update update = new Update();
		update.set("counter", counter);
		update.set("menuList", items);
		update.set("date", date);
		
		System.out.println("Query "+query);
		
		template.upsert(query, update, Menu.class);

		Menu menu = template.findOne(query, Menu.class);
		
		addItems(menu);
		
	}
	
	
}
