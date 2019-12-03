package com.dxc.cafe2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.cafe2.dao.ItemDao;
import com.dxc.cafe2.model.Item;



@RestController
@RequestMapping("/items")
@CrossOrigin(origins= {"http://localhost:3000","http://localhost:4200"})
public class ItemController {
	
	@Autowired
	ItemDao SIMDao;
	
		
	//getting a single product
	@GetMapping("/{id}")
	
	public Item getItem(@PathVariable("id")String id) {
		
		Item item = new Item();
		if(SIMDao.isItemExists(id))
		{
			item= SIMDao.getItem(id);
			return item;
		}
		else {
			return null;
		}
		
	}
	//deleting product
	@DeleteMapping("/{id}")
	
	public Item deleteItem(@PathVariable("id")String id) {
		System.out.println("deleting called"+id);
		
		if(SIMDao.isItemExists(id))
		{
			SIMDao.deleteItem(id);
			return SIMDao.getItem(id);
			
		}
		else {
			return null;
		}
		
	}
	//get all products
		@GetMapping
		public List<Item> getAllProducts() {
			System.out.println("Fetching all products");
			List<Item> allItems=SIMDao.getItems();
			return allItems;
		}
		//add product
				@PostMapping
				public Item addItem(@RequestBody Item item) {
					System.out.println(item);
					if(SIMDao.isItemExists(item.getItemId()))
					{
						return item;
					}
					else
					{
						SIMDao.addItem(item);
						return item;
					}
					
				}
	//items by cuisine
				@GetMapping("/findbycuisine/{cuisine}")
				public List<Item> getItemByCuisine(@PathVariable String[] cuisine ) {
					
					List<Item> item = new ArrayList();
					
						item= SIMDao.getItemByCuisine(cuisine);
						return item;
					
				}			


}
