package org.wiltzu.foodrandomizer;



import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wiltzu.foodrandomizer.service.foodlistprovider.SimpleFileFoodListProvider;

import junit.framework.TestCase;

public class SimpleFileProviderTest extends TestCase {
	
	private ApplicationContext ctx;
	private SimpleFileFoodListProvider foodListProvider;

	protected void setUp() throws Exception {
		super.setUp();
		ctx = new ClassPathXmlApplicationContext("test-spring.xml");
		foodListProvider = (SimpleFileFoodListProvider) ctx.getBean("foodListFileProvider");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testgetFoodList() {
		List<String> expected = new ArrayList<String>();
		expected.add("kebab");
		expected.add("juusto");
		
		List<String> actual = foodListProvider.getFoodList();;
		
		assertEquals(expected, actual);
		
	}
}
