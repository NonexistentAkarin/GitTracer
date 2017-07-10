package im.akari.gittracer.view.ViewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import im.akari.gittracer.R;

/**
 * Created by akari on 2017/6/16.
 */

public class CourseViewHolder extends RecyclerView.ViewHolder {

    public TextView nameText;
    public TextView idText;
    public CardView cardView;

    public CourseViewHolder(View itemView) {
        super(itemView);
        nameText = (TextView) itemView.findViewById(R.id.course_name);
        idText = (TextView) itemView.findViewById(R.id.course_id);
        cardView = (CardView) itemView.findViewById(R.id.course_card_view);
    }
}