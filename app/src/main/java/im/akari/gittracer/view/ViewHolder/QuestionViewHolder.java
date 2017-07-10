package im.akari.gittracer.view.ViewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import im.akari.gittracer.R;

/**
 * Created by akari on 2017/6/18.
 */

public class QuestionViewHolder extends RecyclerView.ViewHolder {

    public TextView titleText;
    public TextView despText;
    public TextView difText;
    public TextView gitText;
    public TextView scoreText;
    public TextView readMeText;
    public TextView analysisText;

    public LinearLayout studentLayout;
    public LinearLayout teacherLayout;
    public CardView cardView;
    public ImageView imageView;

    public QuestionViewHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.question_card_view);
        studentLayout = (LinearLayout) itemView.findViewById(R.id.question_for_student);
        teacherLayout = (LinearLayout) itemView.findViewById(R.id.question_for_teacher);

        titleText = (TextView) itemView.findViewById(R.id.question_title_text);
        despText = (TextView) itemView.findViewById(R.id.question_desp_text);
        difText = (TextView) itemView.findViewById(R.id.question_dif_text);
        gitText = (TextView) itemView.findViewById(R.id.question_git_text);
        scoreText = (TextView) itemView.findViewById(R.id.question_score_text);
        readMeText = (TextView) itemView.findViewById(R.id.question_readme_text);
        analysisText = (TextView) itemView.findViewById(R.id.question_analysis_text);
        imageView = (ImageView) itemView.findViewById(R.id.img_card_main);
    }
}
