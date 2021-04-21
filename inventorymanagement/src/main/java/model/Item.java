package model;

import jakarta.json.bind.annotation.JsonbAnnotation;

@JsonbAnnotation
public class Item 
{
	private String itemcode;
	private String itemcategory;
	private String itemspecific;
	private int price;

	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getItemcategory() {
		return itemcategory;
	}
	public void setItemcategory(String itemcategory) {
		this.itemcategory = itemcategory;
	}
	public String getItemspecific() {
		return itemspecific;
	}
	public void setItemspecific(String itemspecific) {
		this.itemspecific = itemspecific;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [itemcode=" + itemcode + ", itemcategory=" + itemcategory + ", itemspecific=" + itemspecific
				+ ", price=" + price + "]";
	}

	
	

}
