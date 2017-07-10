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
import im.akari.gittracer.model.entity.Exercise;
import im.akari.gittracer.presenter.contract.ExerciseContract;
import im.akari.gittracer.presenter.impl.ExercisePresenterImpl;
import im.akari.gittracer.util.TokenBuilder;
import im.akari.gittracer.view.Adapter.AssignmentAdapter;
import im.akari.gittracer.view.GridItemDividerDecoration;


public class ExerciseListFragment extends Fragment implements ExerciseContract.View {


    @BindView(R.id.exercise_recycler_view)
    RecyclerView recyclerView;

    AssignmentAdapter adapter;

    private ExerciseContract.Presenter presenter;

    public ExerciseListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ExercisePresenterImpl(this);
        adapter = new AssignmentAdapter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercise_list, container, false);
        ButterKnife.bind(this, view);

        Intent intent = getActivity().getIntent();
        int courseId = (int) intent.getExtras().get("courseId");
        String token = TokenBuilder.getToken(PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext()));

        Log.d("courseId", courseId + "");

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.addItemDecoration(new GridItemDividerDecoration
                (getContext(), R.dimen.divider_height, R.color.divider));

        presenter.getExerciseByCourseId(token, courseId);
        return view;
    }


    @Override
    public void showExercise(List<Exercise> exerciseList) {
        for (Exercise exercise : exerciseList) {
            System.out.println(exercise.getTitle());
        }
        adapter.addAssignments(exerciseList);

    }
}
