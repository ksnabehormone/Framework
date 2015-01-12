package factory.nickel.framework;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import factory.nickel.framework.activity.AbstractActivity;
import factory.nickel.framework.activity.VolleySampleActivity_;

@EActivity(R.layout.activity_main)
public class MainActivity extends AbstractActivity {


    @ViewById(R.id.layout_main_list)
    protected LinearLayout list;

    @Override
    public void init() {
        addButton("Vollyサンプル", VolleySampleActivity_.class);


    }

    /**
     * 画面遷移 ※manifest忘れずに
     *
     * @param forwardTo
     */
    private void forward(final Class<?> forwardTo) {
        Intent intent = new Intent(MainActivity.this, forwardTo);
        startActivity(intent);
    }

    private void addButton(String title, final Class<?> forwardTo) {
        Button view = new Button(this);
        view.setText(title);
        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forward(forwardTo);
            }
        });
        list.addView(view);
    }


}
