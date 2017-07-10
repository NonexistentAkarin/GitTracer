package im.akari.gittracer.view.activity.common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import im.akari.gittracer.R;
import im.akari.gittracer.model.entity.QuestionResult;
import im.akari.gittracer.model.entity.ScoreResult;
import im.akari.gittracer.model.entity.TestResult;
import im.akari.gittracer.presenter.contract.QuestionAnalysisContract;
import im.akari.gittracer.presenter.impl.QuestionAnalysisPresenterImpl;
import im.akari.gittracer.util.TokenBuilder;

/**
 * Created by akari on 2017/6/22.
 */
public class QuestionAnalysisActivity extends AppCompatActivity implements QuestionAnalysisContract.View {

    @BindView(R.id.analysis_title_text)
    TextView titleText;
    @BindView(R.id.analysis_git_text)
    TextView gitText;
    @BindView(R.id.analysis_scored_text)
    TextView scoredText;
    @BindView(R.id.analysis_score_text)
    TextView scoreText;
    @BindView(R.id.analysis_compile_text)
    TextView compileText;
    @BindView(R.id.analysis_testcase_sum_text)
    TextView testcaseSumText;
    @BindView(R.id.analysis_testcase_passed_text)
    TextView testcasePassedText;


    private QuestionAnalysisContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_analysis);
        ButterKnife.bind(this);

        this.presenter = new QuestionAnalysisPresenterImpl(this);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String token = TokenBuilder.getToken(preferences);
        int assignmentId = 0, questionId = 0, stdId = 0;
        Intent intent = getIntent();
        assignmentId = intent.getIntExtra("assignmentId", 38);
        questionId = intent.getIntExtra("questionId", 1);
        stdId = intent.getIntExtra("userId", 227);

        Log.d("assId", assignmentId + "");
        Log.d("quesId", questionId + "");
        Log.d("stdId", stdId + "");

        this.presenter.getQuestionAnalysisByThreeIds(token, assignmentId, stdId, questionId);

    }

    @Override
    public void showAnalysis(QuestionResult analysis) {
        ScoreResult scoreResult = analysis.getScoreResult();
        TestResult testResult = analysis.getTestResult();
        this.titleText.setText(analysis.getQuestionTitle());
        this.gitText.setText(scoreResult.getGit_url());

        String scored = "是";
        if (!scoreResult.isScored()) {
            scored = "否";
        }
        this.scoredText.setText(scored);

        this.scoreText.setText(String.valueOf(scoreResult.getScore()));

        String compiled = "是";
        if (!testResult.isCompile_succeeded()) {
            compiled = "否";
        }
        this.compileText.setText(compiled);

        int passed = 0;
        for (int i = 0; i < testResult.getTestCases().length; i++) {
            if (testResult.getTestCases()[i].isPassed()) {
                passed++;
            }
        }

        this.testcaseSumText.setText(String.valueOf(testResult.getTestCases().length));
        this.testcasePassedText.setText(String.valueOf(passed));
    }
}