package org.wiltzu.foodrandomizer.dao;

public class Meal {

	private String name;
	private String price;

	public Meal(String name, String price) {
		setName(name);
		setPrice(price);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	private void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return getName() + ", " + getPrice();
	}
}
