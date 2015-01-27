package factory.nickel.framework.activity;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import factory.nickel.framework.R;
import factory.nickel.framework.api.Pojo;
import factory.nickel.framework.utils.LogUtils;
import factory.nickel.framework.utils.MockUtils;

/**
 * Created by shingo on 2015/01/26.
 */
@EActivity(R.layout.activity_ok_http)
public class OkHttpActivity extends AbstractActivity {

	@ViewById(R.id.list_response)
	protected ListView mList;

	@Override
	public void init() {
		getRequest();
	}

	public void getRequest() {
		new AsyncTask<Void, Void, String>() {
			@Override
			protected String doInBackground(Void... params) {
				String result = null;

				// リクエストオブジェクト
				Request request = new Request.Builder()
						.url(MockUtils.MOCK_URL)
						.get()
						.build();

				// クライアントオブジェクトを作成
				OkHttpClient client = new OkHttpClient();

				// リクエスト結果を受け取る
				try {
					Response response = client.newCall(request).execute();
					result = response.body().string();

				} catch (IOException e) {
					e.printStackTrace();
				}
				return result;
			}

			@Override
			protected void onPostExecute(String result) {
				LogUtils.d(result);
				Toast.makeText(OkHttpActivity.this, result, Toast.LENGTH_SHORT).show();
			}
		}.execute();
	}

	public void setList() {
		List<String> list = new ArrayList<String>();
		Pojo pojo = new Pojo();
		list.add(pojo.name);
		mList.setAdapter(new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1
				, list
		));
	}
}

