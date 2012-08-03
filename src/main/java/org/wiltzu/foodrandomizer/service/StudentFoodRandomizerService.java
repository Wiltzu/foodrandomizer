package org.wiltzu.foodrandomizer.service;

import java.util.List;
import java.util.Random;

import org.wiltzu.foodrandomizer.service.foodlistprovider.FoodListProvider;

public class StudentFoodRandomizerService implements FoodRandomizerService {
	
	private FoodListProvider foodListProvider;
	
	@Override
	public void setFoodListProvider(FoodListProvider fListProvider) {
		this.foodListProvider = fListProvider;

	}

	@Override
	public String getFood() {
		// TODO Auto-generated method stub
		return randomizeFood(foodListProvider.getFoodList());
	}
	
	private String randomizeFood(List<String> foodList) {
		int listLength = foodList.size();
		if(listLength > 0) {
			Random r = new Random();
			return foodList.get(r.nextInt(listLength)); 
		}
else return "foodList is empty";
	}

}
