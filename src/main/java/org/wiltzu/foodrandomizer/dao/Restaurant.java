package org.wiltzu.foodrandomizer.dao;

import java.util.List;

public class Restaurant {

	String name;
	List<Meal> meals;
	
	
	public Restaurant(String name, List<Meal> meals) {
		setName(name);
		setMeals(meals);
	}
	
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public List<Meal> getMeals() {
		return meals;
	}
	private void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
}
