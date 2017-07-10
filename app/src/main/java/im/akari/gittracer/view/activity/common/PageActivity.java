package im.akari.gittracer.view.activity.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;
import im.akari.gittracer.R;
import im.akari.gittracer.view.Adapter.MyPagerAdapter;
import im.akari.gittracer.view.fragment.common.ExamListFragment;
import im.akari.gittracer.view.fragment.common.ExerciseListFragment;
import im.akari.gittracer.view.fragment.common.HomeworkListFragment;

public class PageActivity extends AppCompatActivity {
    private final String[] mTitles = {"作业", "练习", "考试"};
    private CoordinatorTabLayout mCoordinatorTabLayout;
    private int[] mImageArray, mColorArray;
    private ArrayList<Fragment> mFragments;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_page);
        initFragments();
        initViewPager();
        mImageArray = new int[]{
                R.drawable.material_design_3,
                R.drawable.material_design_1,
                R.drawable.material_design_2};
        mColorArray = new int[]{
                R.color.colorPrimary,
                R.color.colorRealAccent,
                R.color.colorAccent};

        mCoordinatorTabLayout = (CoordinatorTabLayout) findViewById(R.id.coordinatortablayout);
        mCoordinatorTabLayout.setBackEnable(true)
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(mViewPager);
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(new HomeworkListFragment());
        mFragments.add(new ExerciseListFragment());
        mFragments.add(new ExamListFragment());
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
