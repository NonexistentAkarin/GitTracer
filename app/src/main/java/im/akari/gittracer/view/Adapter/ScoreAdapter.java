package im.akari.gittracer.view.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import im.akari.gittracer.R;
import im.akari.gittracer.model.entity.StudentScore;
import im.akari.gittracer.view.ViewHolder.ScoreViewHolder;
import im.akari.gittracer.view.activity.common.QuestionAnalysisActivity;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL = 1;
    List<StudentScore> list = Collections.emptyList();
    Context context;
    private int assignmentId;
    private int questionId;
    private View mHeaderView;

    public ScoreAdapter(List<StudentScore> list, Context context) {
        this.list = list;
        this.context = context;
    }


    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null) return TYPE_NORMAL;
        if (position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }

    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == TYPE_HEADER) return new ScoreViewHolder(mHeaderView);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_score, parent, false);
        ScoreViewHolder holder = new ScoreViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ScoreViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) return;

        final int pos = getRealPosition(holder);
        holder.numberText.setText(list.get(pos).getStudentNumber());
        holder.nameText.setText(list.get(pos).getStudentName());
        holder.scoreText.setText(String.valueOf(list.get(pos).getScore()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, QuestionAnalysisActivity.class);
                intent.putExtra("assignmentId", assignmentId);
                intent.putExtra("questionId", questionId);
                intent.putExtra("userId", list.get(pos).getStudentId());
                context.startActivity(intent);
            }
        });
    }

    private int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? list.size() : list.size() + 1;
    }

}
