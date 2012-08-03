package org.wiltzu.foodrandomizer.service.foodlistprovider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.core.io.Resource;
import org.wiltzu.foodrandomizer.service.foodlistprovider.ResourceHelper.ResourceLoaderHelper;
import org.wiltzu.foodrandomizer.service.foodlistprovider.htmlmapper.HTMLMapper;

public class StudentHTMLFoodListProvider implements HTMLfoodListProvider {

	private String location;
	private ResourceLoaderHelper resourceLoaderHelper;

	@Override
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public void setResourceLoaderHelper(ResourceLoaderHelper rsLoaderHelper) {
		this.resourceLoaderHelper = rsLoaderHelper;
	}

	@Override
	public List<String> getFoodList() {
		// TODO Auto-generated method stub
		return this.parseFoodsFromHTML();
	}
	
	private List<String> parseFoodsFromHTML () {
		
		List<String> foodList = new ArrayList<String>();
		Resource resource = resourceLoaderHelper.getResource(location);
		int timeoutMillis = 30000;
		
		Document doc;
		try {
			doc = Jsoup.parse(resource.getURL(), timeoutMillis);
			Elements restaurants = doc.getElementsByClass("restaurant");
			Element restaurant = restaurants.get(0);
			Elements rNames = restaurant.getElementsByClass("restaurantName");
			Element rName = rNames.get(0);
			Elements meals = restaurant.getElementsByClass("meals");
			Element meal = meals.get(0);
			Elements mealNames = meal.getElementsByClass("mealName");
			Element mealName = mealNames.get(0);
			Elements mealPrices = meal.getElementsByClass("mealPrice");
			Element mealPrice = mealPrices.get(0);
			
	
			System.out.println(rName.text());
			System.out.println(mealName.text());
			System.out.println(mealPrice.text());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public <T> void setHTMLmapper(HTMLMapper<T> htmlmapper) {
		// TODO Auto-generated method stub
		
	}

}
