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
	
	public String getMealAsText (int index) {
		try {
			  Meal searchedMeal = meals.get(index);
			  return searchedMeal.toString() + " (" + this.name + ")";
		} catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return "ERROR: meals list's index not found";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for(Meal meal : meals) {
			builder.append(meal);
			if(meals.iterator().hasNext()) {
				builder.append("\n");
			}
		}
		
		return name + "\n" + "Meals: " + "\n" + builder;
	}
	
	
}
