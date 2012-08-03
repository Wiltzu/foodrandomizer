package org.wiltzu.foodrandomizer.service.foodlistprovider.htmlmapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.wiltzu.foodrandomizer.dao.Meal;
import org.wiltzu.foodrandomizer.dao.Restaurant;

public class StudentRestaurantHTMLMapper implements HTMLMapper<Restaurant> {

	private Document doc;
	
	private static final String RESTAURANT_CLASS = "restaurant";
	private static final String RESTAURANT_NAME_CLASS = "restaurantName";
	private static final String MEALS_CLASS = "meals";
	
	@Override
	public Restaurant[] mapHTML(URL url) {
		
		List<String> rNameList = new ArrayList<String>();
		
		try {
			doc = Jsoup.parse(url, HTMLMapper.CONNECTION_TIMEOUT);
			Elements restaurants = getRestaurants();
			
			for(Element restaurant: restaurants) {
				rNameList.add(getRestaurantName(restaurant));
				List<Meal> meals = getMeals(restaurant);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Elements getRestaurants() {
		return doc.getElementsByClass(StudentRestaurantHTMLMapper.RESTAURANT_CLASS);
	}
	
	private String getRestaurantName(Element restaurant) {
		
		Elements rNames = restaurant.getElementsByClass(StudentRestaurantHTMLMapper.RESTAURANT_NAME_CLASS);
		Element rName = rNames.get(0);
		
		return rName.text();
	}
	
	private List<Meal> getMeals(Element restaurant) {
		List<Meal> mealList = new ArrayList<Meal>();
		
		Elements meals = restaurant.getElementsByClass(StudentRestaurantHTMLMapper.MEALS_CLASS);
		for(Element meal: meals) {
			String mealName = getMealName(meal); 
			String mealPrice = getMealPrice(meal);
			mealList.add(new Meal(mealName, mealPrice));
		}
		
		return mealList;
	}

	private String getMealName(Element meal) {
		
		Elements mealNames = meal.getElementsByClass("mealName");
		Element mealName = mealNames.get(0);
		
		return mealName.text();
	}
	
	private String getMealPrice(Element meal) {
		Elements mealPrices = meal.getElementsByClass("mealPrice");
		Element mealPrice = mealPrices.get(0);
		
		return mealPrice.text();
	}

}
