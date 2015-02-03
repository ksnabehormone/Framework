package factory.nickel.framework.utils;

import android.content.Context;
import android.support.v4.app.Fragment;

import factory.nickel.framework.fragment.TestFragment;

/**
 * Created by shingo on 2015/02/03.
 */
public class TestUtils {

	/**
	 * test用のFragmentを生成する
	 * @param context
	 * @return
	 */
	public static Fragment getTestFragment(final Context context) {
		return Fragment.instantiate(context, TestFragment.class.getName());
	}
}
