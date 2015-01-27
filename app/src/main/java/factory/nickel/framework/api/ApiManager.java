package factory.nickel.framework.api;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by shingo on 2015/01/26.
 */
public class ApiManager<T> {

	public T getApiRequest(final String url, Class<T> clazz) {
		// OkHttpをクライントに使うにはOkHttp UrlConnectionが必要
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setClient(new OkClient(new OkHttpClient()))
				.setEndpoint(url)
				.build();
		T service = restAdapter.create(clazz);
		return service;
	}
}
