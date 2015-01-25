package factory.nickel.framework.activity;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import factory.nickel.framework.R;
import factory.nickel.framework.api.ApiManager;
import factory.nickel.framework.api.Pojo;
import factory.nickel.framework.api.RetroFitApi;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

@EActivity(R.layout.activity_retrofit)
public class RetrofitActivity extends AbstractActivity implements Callback<Pojo> {

	@ViewById(R.id.list_response)
	protected ListView mList;

	@Override
	public void init() {
		final String url = "http://www.mocky.io/v2/54c502be30891a9507deeab3";
		RetroFitApi service = new ApiManager<RetroFitApi>().getApiRequest(url, RetroFitApi.class);
		service.getById(10, this);
	}

	@Override
	public void success(Pojo pojo, Response response) {
		List<String> list = new ArrayList<String>();
		list.add(pojo.name);
		mList.setAdapter(new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1
				,list
		));
	}

	@Override
	public void failure(RetrofitError error) {
		Toast.makeText(this, "API ERROR", Toast.LENGTH_SHORT).show();
	}
}
