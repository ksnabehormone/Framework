package factory.nickel.framework.api;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by shingo on 2015/01/24.
 */
public interface RetroFitApi {
	/**
	 * GET送信で/のアクションにリクエストを送信する
 	 * @param id ?id=paramの形で送信
	 * @param cb コールバック
	 */
	@GET("/")
	void getById(@Query("id") int id, Callback<Pojo> cb);
}
