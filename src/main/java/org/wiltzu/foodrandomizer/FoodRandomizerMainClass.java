package org.wiltzu.foodrandomizer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wiltzu.foodrandomizer.service.FoodRandomizerService;

public class FoodRandomizerMainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		FoodRandomizerService foodRandomizer = (FoodRandomizerService) ctx.getBean("pizzaFoodRandomizerService");
		System.out.println(foodRandomizer.getFood());

	}

}
