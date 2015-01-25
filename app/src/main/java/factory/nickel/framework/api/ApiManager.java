package factory.nickel.framework.api;

import retrofit.RestAdapter;

/**
 * Created by shingo on 2015/01/26.
 */
public class ApiManager<T> {

	public T getApiRequest(final String url, Class<T> clazz) {
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setEndpoint(url)
				.build();
		T service = restAdapter.create(clazz);
		return service;
	}
}
