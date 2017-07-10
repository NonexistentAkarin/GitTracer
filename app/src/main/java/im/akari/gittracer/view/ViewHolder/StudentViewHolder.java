package im.akari.gittracer.view.ViewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import im.akari.gittracer.R;

/**
 * Created by akari on 2017/6/15.
 */

public class StudentViewHolder extends RecyclerView.ViewHolder {

    public TextView nameText;
    public TextView numberText;
    public TextView emailText;
    public CardView cardView;

    public StudentViewHolder(View itemView) {
        super(itemView);
        this.nameText = (TextView) itemView.findViewById(R.id.student_name_text);
        this.numberText = (TextView) itemView.findViewById(R.id.student_number_text);
        this.emailText = (TextView) itemView.findViewById(R.id.student_email_text);
        this.cardView = (CardView) itemView.findViewById(R.id.student_card_view);

    }
}
