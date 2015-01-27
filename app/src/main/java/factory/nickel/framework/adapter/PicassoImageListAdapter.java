package factory.nickel.framework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import factory.nickel.framework.R;

/**
 * Created by shingo on 2015/01/27.
 */
public class PicassoImageListAdapter extends AbstractListAdapter<String> {
	public PicassoImageListAdapter(Context context, List<String> list) {
		super(context, list);

	}
	@Override
	public View newView(LayoutInflater inflater, int position, ViewGroup container) {
		View view = inflater.inflate(R.layout.adapter_image_list, container, false);
		ViewHolder holder = new ViewHolder(view);
		view.setTag(holder);
		return view;
	}

	@Override
	public void bindView(String item, int position, View view) {
		ViewHolder holder = (ViewHolder) view.getTag();
	}

	private static class ViewHolder {
		private ImageView mImage;

		ViewHolder(View view) {
			this.mImage = (ImageView) view.findViewById(R.id.image_list);
		}

	}
}
