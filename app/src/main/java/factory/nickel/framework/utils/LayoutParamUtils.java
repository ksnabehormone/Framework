package factory.nickel.framework.utils;

import android.widget.LinearLayout;

/**
 * Created by shingo on 2015/01/24.
 */
public final class LayoutParamUtils {

	public static LinearLayout.LayoutParams getParamMW() {
		return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
	}

	public static LinearLayout.LayoutParams getParamMM() {
		return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
	}
}
