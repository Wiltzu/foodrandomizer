package org.wiltzu.foodrandomizer.service;

import java.util.List;
import java.util.Random;

import org.wiltzu.foodrandomizer.service.foodlistprovider.FoodListProvider;

public class PizzaFoodRandomizerService implements FoodRandomizerService {
	
	private FoodListProvider foodListProvider;
	private int taytteidenLKM;
	
	@Override
	public void setFoodListProvider (FoodListProvider fListProvider) {
		this.foodListProvider = fListProvider;
	}

	public int getTaytteidenLKM() {
		return taytteidenLKM;
	}

	public void setTaytteidenLKM(int taytteidenLKM) {
		this.taytteidenLKM = taytteidenLKM;
	}

	@Override
	public String getFood() {
		// TODO Auto-generated method stub
		return randomizePizza(foodListProvider.getFoodList());
	}
	
	private String randomizePizza(List<String> foodList) {
		if(foodList.size() > 0) {
			Random r = new Random(); //randomoidaan t�ytteit�
			int listLength = foodList.size();
			StringBuilder builder = new StringBuilder(); //luodaan palautettava merkkijono
			
			for(int i = 1; i <= taytteidenLKM; i++) {
				int arvottu = r.nextInt(listLength);
				builder.append(foodList.get(arvottu));
				if(i != (taytteidenLKM)) {builder.append(", ");}
			}
			return builder.toString();
			
		}
else return "foodList is empty";
	}

}
