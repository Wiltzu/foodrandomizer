package org.wiltzu.foodrandomizer.service.foodlistprovider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import org.wiltzu.foodrandomizer.dao.Restaurant;
import org.wiltzu.foodrandomizer.service.foodlistprovider.ResourceHelper.ResourceLoaderHelper;
import org.wiltzu.foodrandomizer.service.foodlistprovider.htmlmapper.HTMLMapper;

public class StudentHTMLFoodListProvider implements HTMLfoodListProvider {

	private String location;
	private ResourceLoaderHelper resourceLoaderHelper;
	private HTMLMapper<Restaurant> htmlMapper;

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
		Resource resource = resourceLoaderHelper.getResource(location);
		List<String> foods = new ArrayList<String>();
		try {
			List<Restaurant> restaurants;
			if(resource instanceof ClassPathResource) {
				restaurants = htmlMapper.mapHTML(resource.getFile());
			}
			else {
				restaurants = htmlMapper.mapHTML(resource.getURL());
			}
			for(Restaurant restaurant : restaurants) {
				
				int size = restaurant.getMeals().size();
				
				for(int i = 0; i < size; i++) {
					foods.add(restaurant.getMealAsText(i));
				}
			}
			return foods;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> void setHtmlMapper(HTMLMapper<T> htmlMapper) {
		
		this.htmlMapper = (HTMLMapper<Restaurant>) htmlMapper;
	}

}
