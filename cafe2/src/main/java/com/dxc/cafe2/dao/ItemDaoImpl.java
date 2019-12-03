package com.dxc.cafe2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.dxc.cafe2.model.Item;




@Repository
public class ItemDaoImpl implements ItemDao{
	
	@Autowired
	MongoTemplate template;
	
	@Override
	public void addItem(Item item) {
		template.save(item);
	}

	@Override
	public Item getItem (String id) {
		return template.findById(id, Item.class);
		
	}

	@Override
	public boolean isItemExists(String id) {
		Item item=template.findById(id, Item.class);
		if(item==null)
			return false;
		else
			return true;
		
	}

	@Override
	public  void deleteItem(String id) {
		Item item =new Item();
		item.setItemId(id);
		template.remove(item);
		
		
	}

	@Override
	public void updateItem(Item item) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(item.getItemId()));
		Update update = new Update();
		update.set("name", item.getItemName());
		update.set("price",item.getItemPrice());
		template.updateFirst(query, update, Item.class);
		
	}

	@Override
	public List<Item> getItems() {
		
		return template.findAll(Item.class);
		
	}
	@Override
	public List<Item> getItemByCuisine(String[] cuisine){
		return template.find(new Query(Criteria.where("itemCuisine").in(cuisine)), Item.class);

	}

}
