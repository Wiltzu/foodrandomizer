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

public class StudentHTMLFoodListProvider implements FoodListProvider {

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
			//if(doc.hasClass("restaurant")) {
				System.out.print("oh yeah!!");
				Elements restaurants = doc.getElementsByClass("restaurant");
				Element restaurant = restaurants.get(0);
				System.out.println(restaurant.toString());
			//}
			System.out.println(resource.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
