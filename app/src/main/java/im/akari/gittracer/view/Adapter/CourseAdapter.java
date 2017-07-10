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
import im.akari.gittracer.model.entity.Course;
import im.akari.gittracer.view.ViewHolder.CourseViewHolder;
import im.akari.gittracer.view.activity.common.PageActivity;

/**
 * Created by akari on 2017/6/16.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {

    List<Course> list = Collections.emptyList();
    Context context;


    public CourseAdapter(List<Course> courses, Context context) {
        this.list = courses;
        this.context = context;
    }


    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
        CourseViewHolder holder = new CourseViewHolder(v);
        return holder;

    }


    @Override
    public void onBindViewHolder(CourseViewHolder holder, final int position) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.nameText.setText(list.get(position).getName());
        holder.idText.setText(String.valueOf(list.get(position).getId()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAssignmentActivity(list.get(position).getId());
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    private void startAssignmentActivity(int courseId) {
        Intent intent = new Intent(context, PageActivity.class);
        intent.putExtra("courseId", courseId);
        context.startActivity(intent);
    }
}
