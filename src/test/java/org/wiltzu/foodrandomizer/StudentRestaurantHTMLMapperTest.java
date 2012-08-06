package org.wiltzu.foodrandomizer;

import java.net.URL;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wiltzu.foodrandomizer.dao.Restaurant;
import org.wiltzu.foodrandomizer.service.foodlistprovider.htmlmapper.StudentRestaurantHTMLMapper;

import junit.framework.TestCase;

public class StudentRestaurantHTMLMapperTest extends TestCase {

	ApplicationContext ctx;
	StudentRestaurantHTMLMapper restaurantHTMLMapper;
	private URL url;

	
	public StudentRestaurantHTMLMapperTest() {
		
		ctx = new ClassPathXmlApplicationContext("test-spring.xml");
		restaurantHTMLMapper = (StudentRestaurantHTMLMapper) ctx.getBean("studentRestaurantHTMLMapper");
		url = (URL) ctx.getBean("url");
	}
	
	
	public void testMapHTML() {
		List<Restaurant> restaurants = restaurantHTMLMapper.mapHTML(url);
		assertNotNull(restaurants);
		
		for(Restaurant restaurant : restaurants) {
			assertNotNull(restaurant.toString());
		}
	}
	

	

}
