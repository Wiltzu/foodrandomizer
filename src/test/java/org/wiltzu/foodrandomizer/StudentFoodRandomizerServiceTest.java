package org.wiltzu.foodrandomizer;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wiltzu.foodrandomizer.service.StudentFoodRandomizerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-spring.xml" })
public class StudentFoodRandomizerServiceTest extends
		AbstractJUnit4SpringContextTests {

	@Autowired
	private StudentFoodRandomizerService studentFoodRandomizerService;

	@Test
	public void testGetFood() {
		String actual = studentFoodRandomizerService.getFood();
		System.out.println(actual);
		assertNotNull(actual);
	}

}
