package org.wiltzu.foodrandomizer.service.foodlistprovider;

import java.util.List;

import org.wiltzu.foodrandomizer.service.foodlistprovider.ResourceHelper.ResourceLoaderHelper;

public abstract class AbstractFoodListProvider implements FoodListProvider {

	protected String location;
	protected ResourceLoaderHelper resourceLoaderHelper;
	
	@Override
	public void setLocation(String location) {
		this.location = location;

	}

	@Override
	public void setResourceLoaderHelper(ResourceLoaderHelper rsLoaderHelper) {
		// TODO Auto-generated method stub
		this.resourceLoaderHelper = rsLoaderHelper;
	}

	@Override
	public abstract List<String> getFoodList();

}
