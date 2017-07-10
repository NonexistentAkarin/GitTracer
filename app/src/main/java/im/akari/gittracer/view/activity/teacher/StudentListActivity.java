package im.akari.gittracer.view.activity.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import im.akari.gittracer.R;
import im.akari.gittracer.model.entity.Student;
import im.akari.gittracer.presenter.contract.GroupDetailContract;
import im.akari.gittracer.presenter.impl.GroupDetailPresenterImpl;
import im.akari.gittracer.util.TokenBuilder;
import im.akari.gittracer.view.Adapter.StudentAdapter;

public class StudentListActivity extends AppCompatActivity implements GroupDetailContract.View {

    @BindView(R.id.student_recycler_view)
    RecyclerView recyclerView;

    private GroupDetailContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        ButterKnife.bind(this);

        this.presenter = new GroupDetailPresenterImpl(this);

        Intent intent = getIntent();
        int id = intent.getIntExtra("groupId", 1);
        String token = TokenBuilder.getToken
                (PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        presenter.getStudentsByGroupId(token, id);
    }


    @Override
    public void showStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getName());
        }

        StudentAdapter adapter = new StudentAdapter(students, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }
}
