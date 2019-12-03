package com.dxc.cafe2.model;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class ItemQuantity {
	private String id;
	@DBRef
	private Item item;
	private int quant;
	public ItemQuantity(String id, Item item, int quant) {
		super();
		this.id = id;
		this.item = item;
		this.quant = quant;
	}
	
	public ItemQuantity() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	

}
