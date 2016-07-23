package com.alekseyld.tasklist.presentation.view;

import com.alekseyld.tasklist.presentation.model.TaskModel;

import java.util.Collection;

/**
 * Created by Alekseyld on 22.07.2016.
 */
public interface ITaskList {

    void renderTaskList(Collection<TaskModel> taskModelCollection);

}
