package im.akari.gittracer.view.activity.common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import im.akari.gittracer.R;
import im.akari.gittracer.model.entity.ReadMe;
import im.akari.gittracer.presenter.contract.ReadMeContract;
import im.akari.gittracer.presenter.impl.ReadMePresenterImpl;
import im.akari.gittracer.util.TokenBuilder;

public class ReadMeActivity extends AppCompatActivity implements ReadMeContract.View {

    private ImageView image_scrolling_top;
    private TextView scroll_text;
    private ReadMeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readme);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_scrolling);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, R.string.large_text);
                intent.setType("text/plain");
                startActivity(intent);
            }
        });

        image_scrolling_top = (ImageView) findViewById(R.id.image_scrolling_top);
        scroll_text = (TextView) findViewById(R.id.tv_scrolling);
        Glide.with(this).load(R.drawable.material_design_5).fitCenter().into(image_scrolling_top);

        this.presenter = new ReadMePresenterImpl(this);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String token = TokenBuilder.getToken(preferences);
        int assignmentId = 0, questionId = 0, stdId = 0;
        Intent intent = getIntent();
        assignmentId = intent.getIntExtra("assignmentId", 38);
        questionId = intent.getIntExtra("questionId", 1);
        stdId = preferences.getInt("userId", 227);

        Log.d("assId", assignmentId + "");
        Log.d("quesId", questionId + "");
        Log.d("stdId", stdId + "");

        this.presenter.getReadMeByThreeIds(token, assignmentId, stdId, questionId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

            CollapsingToolbarLayout collapsing_toolbar_layout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
            collapsing_toolbar_layout.setExpandedTitleTextColor(ColorStateList.valueOf(Color.TRANSPARENT));
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    public void showReadMe(ReadMe readMe) {
        this.scroll_text.setText(readMe.getContent());
    }
}
