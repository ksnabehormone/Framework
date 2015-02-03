package factory.nickel.framework.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;
import java.util.List;

import factory.nickel.framework.R;
import factory.nickel.framework.utils.TestUtils;
import factory.nickel.framework.view.CustomPagerSlidingTabStrip;

/**
 * Created by shingo on 2015/02/03.
 */
@EActivity(R.layout.activity_pager_sliding_tab)
public class PagerSlidingTabActivity extends FragmentActivity {

	@AfterViews
	void init() {
		// ViewPagerのインスタンスを取得
		ViewPager pager = (ViewPager) findViewById(R.id.pager);

		// Fragmentのリストを生成
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(TestUtils.getTestFragment(getApplicationContext()));
		fragments.add(TestUtils.getTestFragment(getApplicationContext()));

		// adapterを作成
		TestAdapter adapter = new TestAdapter(getSupportFragmentManager(), fragments);

		// adapterをセットする
		pager.setAdapter(adapter);

		// tabを作成する
		CustomPagerSlidingTabStrip tabs = (CustomPagerSlidingTabStrip)findViewById(R.id.tabs);

		// tabにpagerをセットする
		tabs.setViewPager(pager);
	}

	private class TestAdapter extends FragmentPagerAdapter {
		private List<Fragment> mList;
		public TestAdapter(FragmentManager fm, List<Fragment> list) {
			super(fm);
			mList = list;
		}
		@Override
		public int getCount() {
			return mList.size();
		}

		@Override
		public Fragment getItem(int position) {
			return mList.get(position);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return "Tab" + (position + 1);
		}
	}
}
