package factory.nickel.framework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by shingo on 2015/01/24.
 */
public abstract class AbstractListAdapter<T> extends ArrayAdapter<T> {

	private LayoutInflater mInflater;

	public AbstractListAdapter(Context context, List<T> episodeList) {
		super(context, 0, episodeList);
		setup(context);
	}

	private void setup(Context context) {
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public final View getView(int position, View view, ViewGroup container) {
		if (view == null) {
			view = newView(mInflater, position, container);
			if (view == null) {
				throw new IllegalStateException("newView result must not be null.");
			}
		}
		bindView(getItem(position), position, view);
		return view;
	}

	/**
	 * 新規作成されるView
	 *
	 * @param inflater
	 * @param position
	 * @param container
	 * @return
	 */
	public abstract View newView(LayoutInflater inflater, int position, ViewGroup container);

	/**
	 * ViewにBindする
	 * @param item
	 * @param position
	 * @param view
	 */
	public abstract void bindView(T item, int position, View view);
}
