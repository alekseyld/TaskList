package com.alekseyld.tasklist.presentation.view;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alekseyld.tasklist.R;
import com.alekseyld.tasklist.presentation.adapter.ListAdapter;
import com.alekseyld.tasklist.presentation.model.TaskModel;
import com.alekseyld.tasklist.presentation.presenter.TaskPresenter;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Alekseyld on 22.07.2016.
 */
public class TaskFragment extends Fragment implements ITaskList{

    @Inject TaskPresenter userListPresenter;
    @Inject ListAdapter listAdapter;

    @BindView(R.id.list_tasks) RecyclerView list_tasks;

    private Unbinder unbinder;

    public TaskFragment(){
        setRetainInstance(true);
    }

    private void setupRecyclerView() {
        this.list_tasks.setLayoutManager(new LinearLayoutManager(this.getActivity().getApplicationContext()));
        this.list_tasks.setAdapter(listAdapter);
    }

    @Override
    public void renderTaskList(Collection<TaskModel> taskModelCollection) {
        if (taskModelCollection != null) {
            this.listAdapter.setUsersCollection(taskModelCollection);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_task_list, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        setupRecyclerView();

        return fragmentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        list_tasks.setAdapter(null);
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.userListPresenter.destroy();
    }

    private void loadUserList(){

    }
}
