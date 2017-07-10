package im.akari.gittracer.view.activity.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import im.akari.gittracer.R;
import im.akari.gittracer.model.entity.Question;
import im.akari.gittracer.view.Adapter.QuestionAdapter;

public class QuestionListActivity extends AppCompatActivity {

    @BindView(R.id.question_recycler_view)
    RecyclerView recyclerView;

    private QuestionAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);
        ButterKnife.bind(this);

        List<Question> questions = (List<Question>) getIntent().getExtras().get("questionList");
        int assignmentId = getIntent().getIntExtra("assignmentId", 38);
        initViews(assignmentId, questions);

    }


    public void initViews(int assignmentId, List<Question> questions) {

        adapter = new QuestionAdapter(assignmentId, questions, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }
}
