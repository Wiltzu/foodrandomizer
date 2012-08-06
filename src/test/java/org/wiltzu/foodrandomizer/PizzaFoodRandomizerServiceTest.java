package org.wiltzu.foodrandomizer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wiltzu.foodrandomizer.service.PizzaFoodRandomizerService;

import junit.framework.TestCase;

public class PizzaFoodRandomizerServiceTest extends TestCase {

	private ApplicationContext ctx;
	private PizzaFoodRandomizerService pizzaFoodRandomizer;
	private PizzaFoodRandomizerService pizzaFoodRandomizerEmpty;
	

	public PizzaFoodRandomizerServiceTest() throws Exception {
		ctx = new ClassPathXmlApplicationContext("test-spring.xml");
		pizzaFoodRandomizer = (PizzaFoodRandomizerService) ctx.getBean("pizzaFoodRandomizerService");
		pizzaFoodRandomizerEmpty = (PizzaFoodRandomizerService) ctx.getBean("pizzaFoodRandomizerServiceEmpty");
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetTaytteidenLKM() {
		assertEquals(4, pizzaFoodRandomizer.getTaytteidenLKM());
		assertEquals(0, pizzaFoodRandomizerEmpty.getTaytteidenLKM());
	}

	public void testGetFood() {
		assertNotSame("foodList is empty",pizzaFoodRandomizer.getFood());
		assertEquals("", pizzaFoodRandomizerEmpty.getFood());
	}

}
