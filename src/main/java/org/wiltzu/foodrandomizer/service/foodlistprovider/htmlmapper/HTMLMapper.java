package org.wiltzu.foodrandomizer.service.foodlistprovider.htmlmapper;

import java.net.URL;

public interface HTMLMapper<T> {
	
	public final int CONNECTION_TIMEOUT = 15000; //milliseconds

	public T[] mapHTML(URL url);
}
