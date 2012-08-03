package org.wiltzu.foodrandomizer.service.foodlistprovider.htmlmapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
	private static final String MEAL_CLASS = "meal";
	private static final String MEAL_NAME_CLASS = "mealName";
	private static final String MEAL_PRICE_CLASS = "mealPrice";
	
	@Override
	public List<Restaurant> mapHTML(File file) {
		
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		
		try {
			doc = Jsoup.parse(file, "ISO-8859-1");
			restaurantList = mapData();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return restaurantList;
		
	}
	
	@Override
	public List<Restaurant> mapHTML(URL url) {
		
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		
		try {
			doc = Jsoup.parse(url, HTMLMapper.CONNECTION_TIMEOUT);
			restaurantList = mapData();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return restaurantList;
	}
	
	private List<Restaurant> mapData() {
		String rName;
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		
		Elements restaurants = getRestaurants();
		
		for(Element restaurant: restaurants) {
			rName = getRestaurantName(restaurant);
			List<Meal> meals = getMeals(restaurant);
			Restaurant restaurantInstance = new Restaurant(rName, meals);
			restaurantList.add(restaurantInstance);
		}
		
		return restaurantList;
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
		
		Elements meals = restaurant.getElementsByClass(StudentRestaurantHTMLMapper.MEAL_CLASS);
		for(Element meal: meals) {
			String mealName = getMealName(meal); 
			String mealPrice = getMealPrice(meal);
			mealList.add(new Meal(mealName, mealPrice));
		}
		
		return mealList;
	}

	private String getMealName(Element meal) {
		
		Elements mealNames = meal.getElementsByClass(StudentRestaurantHTMLMapper.MEAL_NAME_CLASS);
		Element mealName = mealNames.get(0);
		
		return mealName.text();
	}
	
	private String getMealPrice(Element meal) {
		Elements mealPrices = meal.getElementsByClass(StudentRestaurantHTMLMapper.MEAL_PRICE_CLASS);
		if(!mealPrices.isEmpty()) {
			Element mealPrice = mealPrices.get(0);
			return mealPrice.text();
		}
		return "Price Unknown";
	}

}
