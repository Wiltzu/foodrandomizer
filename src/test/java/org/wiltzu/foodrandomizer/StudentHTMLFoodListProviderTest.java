package org.wiltzu.foodrandomizer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wiltzu.foodrandomizer.service.foodlistprovider.StudentHTMLFoodListProvider;

import junit.framework.TestCase;

public class StudentHTMLFoodListProviderTest extends TestCase {

	private ApplicationContext ctx;
	private StudentHTMLFoodListProvider studentFoodListProvider;
	
	
	public StudentHTMLFoodListProviderTest() throws ClassNotFoundException {
		
		ctx = new ClassPathXmlApplicationContext("test-spring.xml");
		studentFoodListProvider = (StudentHTMLFoodListProvider) ctx.getBean("studentFoodListProvider");
		
	}

	public void testGetFoodList() {
	List<String> foodList = studentFoodListProvider.getFoodList();
	List<String> expected = new ArrayList<String>();
	expected.add("Hampurilainen, 2,60 (Assarin ullakko)");
	assertEquals(expected, foodList);
		

	}

}
