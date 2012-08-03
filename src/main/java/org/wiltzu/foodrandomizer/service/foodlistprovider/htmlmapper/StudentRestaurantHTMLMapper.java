package org.wiltzu.foodrandomizer.service.foodlistprovider.htmlmapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.wiltzu.foodrandomizer.dao.Restaurant;

public class StudentRestaurantHTMLMapper implements HTMLMapper<Restaurant> {

	private Document doc;
	private static final String RESTAURANT_CLASS = "restaurant";
	
	@Override
	public Restaurant[] mapHTML(URL url) {
		
		List<String> rNameList = new ArrayList<String>();
	
		try {
			doc = Jsoup.parse(url, HTMLMapper.CONNECTION_TIMEOUT);
			Elements restaurants = getRestaurants();
			
			for(Element restaurant: restaurants) {
				rNameList.add(getRestaurantName(restaurant));
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Elements getRestaurants() {
		return doc.getElementsByClass(StudentRestaurantHTMLMapper.RESTAURANT_CLASS);
	}
	
	private String getRestaurantNames(Element restaurant) {
		
		Elements rNames = restaurant.getElementsByClass("restaurantName");
		Element rName = rNames.get(0);
		
		return rName.text();
	}

}
