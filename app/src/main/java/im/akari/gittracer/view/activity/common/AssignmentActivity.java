package im.akari.gittracer.view.activity.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import im.akari.gittracer.R;
import im.akari.gittracer.view.fragment.common.ExamListFragment;
import im.akari.gittracer.view.fragment.common.ExerciseListFragment;
import im.akari.gittracer.view.fragment.common.HomeworkListFragment;

public class AssignmentActivity extends AppCompatActivity {

    @BindView(R.id.assign_navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_assign_homework:
                    selectedFragment = new HomeworkListFragment();
                    break;
                case R.id.navigation_assign_exercise:
                    selectedFragment = new ExerciseListFragment();
                    break;
                case R.id.navigation_assign_exam:
                    selectedFragment = new ExamListFragment();
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.assign_fragment_container, selectedFragment);
            transaction.commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.assign_fragment_container, new HomeworkListFragment());
        transaction.commit();
    }

}
