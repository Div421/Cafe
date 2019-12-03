package com.dxc.cafe2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="items")
public class Item {
	
	@Id
	private String id;
	private String itemName;
	private String itemDesc;
	private String itemPrice;
	private String itemCuisine;
	
	private int itemQuantity=1;

	public Item() {
		super();
	}

	public Item(String itemId, String itemName, String itemDesc, String itemPrice, String itemCuisine
			) {
		super();
		this.id = itemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
		this.itemCuisine = itemCuisine;
		
	}
	

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}



	public String getItemId() {
		return id;
	}

	public void setItemId(String itemId) {
		this.id = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCuisine() {
		return itemCuisine;
	}

	public void setItemCuisine(String itemCuisine) {
		this.itemCuisine = itemCuisine;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", itemPrice=" + itemPrice
				+ ", itemCuisine=" + itemCuisine + ", itemQuantity=" + itemQuantity + "]";
	}

	

}
