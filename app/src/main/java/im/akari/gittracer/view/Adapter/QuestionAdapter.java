package im.akari.gittracer.view.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import im.akari.gittracer.R;
import im.akari.gittracer.model.entity.Question;
import im.akari.gittracer.view.ViewHolder.QuestionViewHolder;
import im.akari.gittracer.view.activity.common.QuestionAnalysisActivity;
import im.akari.gittracer.view.activity.common.QuestionScoreActivity;
import im.akari.gittracer.view.activity.common.ReadMeActivity;

/**
 * Created by akari on 2017/6/18.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionViewHolder> {
    int assignmentId;
    List<Question> questions;
    Context context;

    public QuestionAdapter(int assignmentId, List<Question> questions, Context context) {
        this.assignmentId = assignmentId;
        this.questions = questions;
        this.context = context;
    }


    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quesion, parent, false);
        QuestionViewHolder holder = new QuestionViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, final int position) {
        holder.titleText.setText(questions.get(position).getTitle());
        holder.despText.setText(questions.get(position).getDescription());
        holder.gitText.setText("Git: " + questions.get(position).getGitUrl());
        holder.difText.setText("难度系数: " + questions.get(position).getDifficulty() + "         上传者: " + questions.get(position).getCreator().getName());
        Glide.with(context).load(R.drawable.material_design_4).fitCenter().into(holder.imageView);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String type = sharedPreferences.getString("type", "student");
        if (type.equals("student")) {
            holder.teacherLayout.setVisibility(View.GONE);
            holder.readMeText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startScrollingActivity(assignmentId, questions.get(position).getId());
                }
            });

            holder.analysisText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startQuestionAnalysisctivity(assignmentId, questions.get(position).getId());
                }
            });

        } else if (type.equals("teacher")) {
            holder.studentLayout.setVisibility(View.GONE);
            holder.scoreText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startQuestionScoreActivity(assignmentId, questions.get(position).getId());
                }
            });

        }


    }

    @Override
    public int getItemCount() {

        return questions == null ? 0 : questions.size();
    }


    private void startQuestionScoreActivity(int assignmentId, int questionId) {
        Intent intent = new Intent(context, QuestionScoreActivity.class);
        intent.putExtra("assignmentId", assignmentId);
        intent.putExtra("questionId", questionId);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private void startScrollingActivity(int assignmentId, int questionId) {
        Intent intent = new Intent(context, ReadMeActivity.class);
        intent.putExtra("assignmentId", assignmentId);
        intent.putExtra("questionId", questionId);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    private void startQuestionAnalysisctivity(int assignmentId, int questionId) {
        Intent intent = new Intent(context, QuestionAnalysisActivity.class);
        intent.putExtra("assignmentId", assignmentId);
        intent.putExtra("questionId", questionId);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
