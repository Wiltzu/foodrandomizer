package org.wiltzu.foodrandomizer.service.foodlistprovider;

import org.wiltzu.foodrandomizer.service.foodlistprovider.htmlmapper.HTMLMapper;

public interface HTMLfoodListProvider extends FoodListProvider {

	public <T> void setHtmlMapper(HTMLMapper<T> htmlMapper);
}
