package im.akari.gittracer.view.activity.common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import im.akari.gittracer.R;
import im.akari.gittracer.model.entity.QuestionScore;
import im.akari.gittracer.model.entity.StudentScore;
import im.akari.gittracer.presenter.contract.QuestionScoreContract;
import im.akari.gittracer.presenter.impl.QuestionScorePresenterImpl;
import im.akari.gittracer.util.TokenBuilder;
import im.akari.gittracer.view.Adapter.ScoreAdapter;
import im.akari.gittracer.view.Adapter.ScoreValueFormatter;

/**
 * Created by akari on 2017/6/22.
 */

public class QuestionScoreActivity extends AppCompatActivity implements QuestionScoreContract.View {

    View scoreHeader;
    BarChart barChart;
    @BindView(R.id.question_score_recycler_view)
    RecyclerView recyclerView;

    private int assignmentId = 0, questionId = 0;

    private QuestionScoreContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_score);
        ButterKnife.bind(this);

        this.presenter = new QuestionScorePresenterImpl(this);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String token = TokenBuilder.getToken(preferences);
        Intent intent = getIntent();
        assignmentId = intent.getIntExtra("assignmentId", 38);
        questionId = intent.getIntExtra("questionId", 1);

        Log.d("assignmentId", assignmentId + "");
        Log.d("questionId", questionId + "");

        this.presenter.getQuestionScoreBy(token, assignmentId, questionId);
    }


    @Override
    public void showScoreGraph(QuestionScore questionScore) {
        scoreHeader = LayoutInflater.from(getApplicationContext()).inflate(R.layout.head_score, null);
        barChart = (BarChart) scoreHeader.findViewById(R.id.question_score_chart);
        TextView questionNameText = (TextView) scoreHeader.findViewById(R.id.question_name);
        TextView descriptionText = (TextView) scoreHeader.findViewById(R.id.description);

        questionNameText.setText(questionScore.getQuestionInfo().getTitle());
        descriptionText.setText(questionScore.getQuestionInfo().getDescription());

        List<BarEntry> scoreData = new ArrayList<>();
        for (int score = 10; score <= 100; score += 10) {
            float count = 0;
            for (StudentScore stuScore : questionScore.getStudentScores()) {
                double currScore = stuScore.getScore();
                if (score == 100) {
                    if (currScore >= score - 10 && currScore <= score) {
                        count++;
                    }
                }
                if (currScore >= score - 10 && currScore < score) {
                    count++;
                }
            }
            scoreData.add(new BarEntry(score / 10, count));
        }
        BarDataSet scoreSet = new BarDataSet(scoreData, "分数");
        scoreSet.setColor(getApplicationContext().getColor(R.color.colorPrimary));
        barChart.setData(new BarData(scoreSet));

        //config x-axis
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new ScoreValueFormatter());
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        //config right y-axis to make it disappear
        barChart.getAxisRight().setEnabled(false);

        //config legend to make it disappear since there's only a legend
        barChart.getLegend().setEnabled(false);

        //disable description
        barChart.getDescription().setEnabled(false);

        barChart.invalidate();
    }

    @Override
    public void showScoreList(QuestionScore questionScore) {
        ScoreAdapter adapter = new ScoreAdapter(Arrays.asList(questionScore.getStudentScores()), getApplicationContext());
        adapter.setQuestionId(questionId);
        adapter.setAssignmentId(assignmentId);
        adapter.setHeaderView(scoreHeader);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }
}