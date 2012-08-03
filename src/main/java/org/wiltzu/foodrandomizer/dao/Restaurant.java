package org.wiltzu.foodrandomizer.dao;

import java.util.List;

public class Restaurant {

	String name;
	List<Meal> meals;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Meal> getMeals() {
		return meals;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
}
