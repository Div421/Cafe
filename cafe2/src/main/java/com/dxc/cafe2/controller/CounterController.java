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
import com.dxc.cafe2.dao.ItemDao;
import com.dxc.cafe2.model.Counter;

@RestController
//@RequestMapping("/counters")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class CounterController {

	@Autowired
	CounterDao SIMDao;

	@GetMapping("/counterss/{email}")
	public Counter getItemByEmail(@PathVariable("email") String email) {
		return SIMDao.getItemByUserName(email);
	}

	// getting a single product
	@GetMapping("/counters/{id}")

	public Counter getItem(@PathVariable("id") String id) {

		Counter item = new Counter();
		if (SIMDao.isItemExists(id)) {
			item = SIMDao.getItem(id);
			return item;
		} else {
			return null;
		}

	}

	// deleting product
	@DeleteMapping("/counters/{id}")

	public Counter deleteItem(@PathVariable("id") String id) {
		System.out.println("deleting called" + id);

		if (SIMDao.isItemExists(id)) {
			SIMDao.deleteItem(id);
			return SIMDao.getItem(id);

		} else {
			return null;
		}

	}

	// get all products
	@GetMapping("/counters")
	public List<Counter> getAllProducts() {
		System.out.println("Fetching all products");
		List<Counter> allItems = SIMDao.getItems();
		return allItems;
	}

	// add product
	@PostMapping("/counters")
	public Counter addItem(@RequestBody Counter item) {
		System.out.println(item);
		if (SIMDao.isItemExists(item.getId())) {
			return item;
		} else {
			SIMDao.addItem(item);
			return item;
		}

	}

}
