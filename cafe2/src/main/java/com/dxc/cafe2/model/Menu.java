package com.dxc.cafe2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Menu {
	@Id
	private String id;
	@DBRef
	private Counter counter;
	private String selectCuisine;
	@DBRef
	private List<Item> menuList;
	
	private String date;

	public Menu() {
		super();
	}

	public Menu(String id, Counter counter, String selectCuisine, List<Item> menuList, String date) {
		super();
		this.id = id;
		this.counter = counter;
		this.selectCuisine = selectCuisine;
		this.menuList = menuList;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	public String getSelectCuisine() {
		return selectCuisine;
	}

	public void setSelectCuisine(String selectCuisine) {
		this.selectCuisine = selectCuisine;
	}

	public List<Item> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Item> menuList) {
		this.menuList = menuList;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", counter=" + counter + ", selectCuisine=" + selectCuisine + ", menuList=" + menuList
				+ ", date=" + date + "]";
	}



	
	

}
