package com.dxc.cafe2.controller;

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

import com.dxc.cafe2.dao.CounterDao;
import com.dxc.cafe2.dao.MenuDao;
import com.dxc.cafe2.model.Item;
import com.dxc.cafe2.model.Menu;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class MenuController {

	@Autowired
	MenuDao SIMDao;
	CounterDao cDao;

	// getting a single product
	@GetMapping("/{id}")

	public Menu getItem(@PathVariable("id") String id) {

		Menu item = new Menu();
		if (SIMDao.isItemExists(id)) {
			item = SIMDao.getItem(id);
			return item;
		} else {
			return null;
		}

	}

	// deleting product
	@DeleteMapping("/{id}")

	public Menu deleteItem(@PathVariable("id") String id) {
		System.out.println("deleting called" + id);

		if (SIMDao.isItemExists(id)) {
			SIMDao.deleteItem(id);
			return SIMDao.getItem(id);

		} else {
			return null;
		}

	}

	// get all products
	@GetMapping
	public List<Menu> getAllProducts() {
		System.out.println("Fetching all products");
		List<Menu> allItems = SIMDao.getItems();
		return allItems;
	}

	// add product
	@PostMapping("/add")
	public Menu addItem(@RequestBody Menu item) {

		SIMDao.addItems(item);
		return item;

	}

	// get items in menu by counter id
	@GetMapping("itemsById/{id}")
	public List<Item> gett(@PathVariable("id") String id) {
		System.out.println("hello");
		return SIMDao.getItemsByCounterId(id);
	}
	@GetMapping("/menu/{id}")
	public Menu getMenu(@PathVariable("id") String id) {
		System.out.println("hello");
		System.err.println(SIMDao.getMenuByCounterId(id));
		return SIMDao.getMenuByCounterId(id);
	}
	@PostMapping
	public void putt(@RequestBody Menu menu) {
		SIMDao.postdata(menu.getMenuList(), menu.getCounter(), menu.getDate());

	}

}
