package org.wiltzu.foodrandomizer.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wiltzu.foodrandomizer.service.StudentFoodRandomizerService;

import junit.framework.TestCase;

public class StudentFoodRandomizerServiceTest extends TestCase {

	ApplicationContext ctx;
	StudentFoodRandomizerService studentFoodRandomizerService;
	
	public StudentFoodRandomizerServiceTest() {
		ctx = new ClassPathXmlApplicationContext("test-spring.xml");
		studentFoodRandomizerService = (StudentFoodRandomizerService) ctx.getBean("studentFoodRandomizerService");
		
	}
	
	public void testGetFood() {
		String actual = studentFoodRandomizerService.getFood();
		System.out.print(actual);
		assertNotNull(actual);
	}

}
