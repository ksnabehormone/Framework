package factory.nickel.framework.activity;

import android.widget.ListView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import factory.nickel.framework.R;
import factory.nickel.framework.adapter.GlideImageListAdapter;
import factory.nickel.framework.utils.MockUtils;

/**
 * Created by shingo on 2015/01/28.
 */
@EActivity(R.layout.activity_glide)
public class GlideActivity extends AbstractActivity {
	@ViewById(R.id.list_item)
	protected ListView mLIst;

	@Override
	public void init() {
		List<String> list = new ArrayList<String>();
		for (int i=0 ;i < 20; i++) {
			list.add(MockUtils.MOCK_IMAGE);
		}
		GlideImageListAdapter adapter = new GlideImageListAdapter(this, list);
		mLIst.setAdapter(adapter);
	}
}
