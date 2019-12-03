package com.dxc.cafe2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.dxc.cafe2.model.Counter;
import com.dxc.cafe2.model.Item;



@Repository
public class CounterDaoImpl implements CounterDao {
	@Autowired
	MongoTemplate template;
	
	@Override
	public void addItem(Counter item) {
		template.save(item);
	}

	@Override
	public Counter getItem (String id) {
		return template.findById(id, Counter.class);
		
	}

	@Override
	public boolean isItemExists(String id) {
		Counter item=template.findById(id, Counter.class);
		if(item==null)
			return false;
		else
			return true;
		
	}

	@Override
	public  void deleteItem(String id) {
		Counter item =new Counter();
		item.setCounterId(id);;
		template.remove(item);
		
		
	}

	@Override
	public void updateItem(Counter item) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(item.getId()));
		Update update = new Update();
		update.set("counterName", item.getCounterName());
		update.set("counterOwner",item.getCounterOwner());
		template.updateFirst(query, update, Counter.class);
		
	}

	
	@Override
	public List<Counter> getItems() {
		
		return template.findAll(Counter.class);
		
	}
	
	@Override
	public Counter getItemByUserName(String email) {
		return template.findOne(new Query(Criteria.where("counterEmail").is(email)), Counter.class);
	}


	
	

}
