package factory.nickel.framework.activity;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;
import org.json.JSONObject;

import factory.nickel.framework.R;

@EActivity(R.layout.activity_volley_sample)
public class VolleySampleActivity extends AbstractActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private RequestQueue mQueue;

    @ViewById(R.id.text_response)
    protected TextView mText;

    @Override
    public void init() {
        // 東京都の天気情報
        String url = "http://weather.livedoor.com/forecast/webservice/json/v1?city=270000";

        mQueue = Volley.newRequestQueue(this);
        mQueue.add(new JsonObjectRequest(Request.Method.GET, url, null, this, this));
    }


    @Override
    public void onResponse(JSONObject response) {
        try {
            String title = response.get("title").toString();
            mText.setText(title);
            Toast.makeText(this, "test", Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
    }
}
