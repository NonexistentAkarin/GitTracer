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
import im.akari.gittracer.model.entity.Group;
import im.akari.gittracer.view.ViewHolder.GroupViewHolder;
import im.akari.gittracer.view.activity.teacher.StudentListActivity;

/**
 * Created by akari on 2017/6/14.
 * 用于老师查看班级列表
 */

public class GroupAdapter extends RecyclerView.Adapter<GroupViewHolder> {

    List<Group> list = Collections.emptyList();
    Context context;


    public GroupAdapter(List<Group> groups, Context context) {
        this.list = groups;
        this.context = context;
    }


    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class, parent, false);
        return new GroupViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, final int position) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.nameText.setText(list.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStudentListActivity(list.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private void startStudentListActivity(int groupId) {

        Intent intent = new Intent(context, StudentListActivity.class);
        intent.putExtra("id", groupId);
        context.startActivity(intent);
    }

}
