package org.wiltzu.foodrandomizer.dao;

import java.util.Set;

public class Restaurant {

	String name;
	Set<Meal> meals;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Meal> getMeals() {
		return meals;
	}
	public void setMeals(Set<Meal> meals) {
		this.meals = meals;
	}
}
