package im.akari.gittracer.view.fragment.common;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import im.akari.gittracer.R;
import im.akari.gittracer.model.entity.Exam;
import im.akari.gittracer.presenter.contract.ExamContract;
import im.akari.gittracer.presenter.impl.ExamPresenterImpl;
import im.akari.gittracer.util.TokenBuilder;
import im.akari.gittracer.view.Adapter.AssignmentAdapter;
import im.akari.gittracer.view.GridItemDividerDecoration;

public class ExamListFragment extends Fragment implements ExamContract.View {


    @BindView(R.id.exam_recycler_view)
    RecyclerView recyclerView;

    AssignmentAdapter adapter;
    private ExamContract.Presenter presenter;

    public ExamListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ExamPresenterImpl(this);
        adapter = new AssignmentAdapter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exam_list, container, false);
        ButterKnife.bind(this, view);

        Intent intent = getActivity().getIntent();
        int courseId = (int) intent.getExtras().get("courseId");
        String token = TokenBuilder.getToken(PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext()));

        Log.d("courseId", courseId + "");

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.addItemDecoration(new GridItemDividerDecoration
                (getContext(), R.dimen.divider_height, R.color.divider));

        presenter.getExamByCourseId(token, courseId);
        return view;
    }


    @Override
    public void showExam(List<Exam> examList) {
        for (Exam exam : examList) {
            System.out.println(exam.getTitle());
        }
        adapter.addAssignments(examList);

    }
}
