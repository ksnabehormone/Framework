package factory.nickel.framework.activity;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import factory.nickel.framework.R;
import factory.nickel.framework.utils.MockUtils;

@EActivity(R.layout.activity_picasso)
public class PicassoActivity extends AbstractActivity {

	@ViewById(R.id.img_picasso)
	protected ImageView mImage;

	@Override
	public void init() {
		/**
		 * with:downloader,cache,requesttransfarを初期化
		 */
		Picasso.with(this).load(MockUtils.MOCK_IMAGE)
				.resize(100, 100)
				.centerCrop()
				.into(mImage);
	}
}
