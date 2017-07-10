package im.akari.gittracer.view.ViewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import im.akari.gittracer.R;

/**
 * Created by akari on 2017/6/15.
 */

public class ScoreViewHolder extends RecyclerView.ViewHolder {

    public TextView nameText;
    public TextView numberText;
    public TextView scoreText;
    public CardView cardView;

    public ScoreViewHolder(View itemView) {
        super(itemView);
        this.nameText = (TextView) itemView.findViewById(R.id.name);
        this.numberText = (TextView) itemView.findViewById(R.id.number);
        this.scoreText = (TextView) itemView.findViewById(R.id.score);
        this.cardView = (CardView) itemView.findViewById(R.id.score_card_view);
    }
}
