package com.alekseyld.tasklist.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alekseyld.tasklist.R;
import com.alekseyld.tasklist.presentation.model.TaskModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alekseyld on 22.07.2016.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.UserViewHolder>  {

    private List<TaskModel> taskList;
    private final LayoutInflater layoutInflater;

    @Inject
    public ListAdapter(Context context){
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.taskList = Collections.emptyList();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_task, parent, false);
        return new UserViewHolder(view);
    }

    public void setUsersCollection(Collection<TaskModel> taskList) {
        if (taskList == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
        this.taskList = (List<TaskModel>) taskList;
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final TaskModel userModel = this.taskList.get(position);
        holder.title.setText(userModel.getTitle());
        holder.text.setText(userModel.getText());
        holder.user.setText(userModel.getUser());
    }

    @Override
    public int getItemCount() {
        return (this.taskList != null) ? this.taskList.size() : 0;
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title) TextView title;
        @BindView(R.id.text) TextView text;
        @BindView(R.id.user) TextView user;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
