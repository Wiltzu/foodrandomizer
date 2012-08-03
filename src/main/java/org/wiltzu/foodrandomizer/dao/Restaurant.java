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
	
	public String getMealAsText (Meal meal) {
		Meal searchedMeal = meals.get(meals.indexOf(meal));
		return searchedMeal.toString() + " (" + this.name + ")";
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
