package org.wiltzu.foodrandomizer.service;

import org.wiltzu.foodrandomizer.service.foodlistprovider.FoodListProvider;



public interface FoodRandomizerService {

	public void setFoodListProvider (FoodListProvider fListProvider);
	public String getFood();
}
