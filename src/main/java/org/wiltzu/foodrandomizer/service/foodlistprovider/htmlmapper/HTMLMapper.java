package org.wiltzu.foodrandomizer.service.foodlistprovider.htmlmapper;

import java.net.URL;
import java.util.List;

public interface HTMLMapper<T> {
	
	public final int CONNECTION_TIMEOUT = 15000; //milliseconds

	public List<T> mapHTML(URL url);
}
