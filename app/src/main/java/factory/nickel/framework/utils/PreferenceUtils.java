package factory.nickel.framework.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by shingo on 2015/01/24.
 */
public final class PreferenceUtils {

	protected PreferenceUtils() {

	}

	public static final void remove(Context context, String key) {
		SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit();
		editor.remove(key);
		editor.commit();
	}


	public static final void setString(Context context, String key, String value) {
		SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit();
		editor.putString(key, value);
		editor.commit();
	}

	public static final String getString(Context context, String key) {
		return getString(context, key, null);
	}

	public static final String getString(Context context, String key, String def) {
		String value = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).getString(key, def);
		return value;
	}

	public static final void setInteger(Context context, String key, Integer value) {
		SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public static final Integer getInteger(Context context, String key) {
		return getInteger(context, key, null);
	}

	public static final Integer getInteger(Context context, String key, String def) {
		String value = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).getString(key, def);
		return value == null ? null : Integer.valueOf(value);
	}

}
