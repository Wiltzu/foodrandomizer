package org.wiltzu.foodrandomizer.service.foodlistprovider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import org.springframework.core.io.Resource;
import org.wiltzu.foodrandomizer.service.foodlistprovider.ResourceHelper.ResourceLoaderHelper;

public class SimpleFileFoodListProvider implements FoodListProvider {

	private String filePath;
	private ResourceLoaderHelper resourceLoaderHelper;
	
	@Override
	public void setFilePath(String filePath) {
		// TODO Auto-generated method stub
		this.filePath = filePath;
	}
	
	@Override
	public void setResourceLoaderHelper(ResourceLoaderHelper rsLoaderHelper) {
		this.resourceLoaderHelper = rsLoaderHelper;
	}

	@Override
	public List<String> getFoodList() {
		// TODO Auto-generated method stub
		
		return readFileInput();
	}
	
	private List<String> readFileInput() {
		
		List<String> foodList = new ArrayList<String>();
		Resource resource = resourceLoaderHelper.getResource(filePath);
		
		if(resource.exists()) {
			
			try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream())))
			{	
				
				String line;
				while((line = br.readLine()) != null) {
					foodList.add(line);
				}

			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}
		
		return foodList;
	}
	
	
}
