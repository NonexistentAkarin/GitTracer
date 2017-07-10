package im.akari.gittracer.view.ViewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import im.akari.gittracer.R;

/**
 * Created by akari on 2017/6/14.
 * 用于老师查看班级列表
 */

public class GroupViewHolder extends RecyclerView.ViewHolder {

    public TextView nameText;
    public CardView cardView;

    public GroupViewHolder(View itemView) {
        super(itemView);
        nameText = (TextView) itemView.findViewById(R.id.class_name_text);
        cardView = (CardView) itemView.findViewById(R.id.class_card_view);
    }
}
