package com.alekseyld.tasklist.presentation.transfer;

import com.alekseyld.tasklist.domain.Task;
import com.alekseyld.tasklist.presentation.di.ActivityScope;
import com.alekseyld.tasklist.presentation.model.TaskModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

/**
 * Created by Alekseyld on 23.07.2016.
 */
@ActivityScope
public class ModelDataTransfer {

    @Inject
    public ModelDataTransfer() {}

    public TaskModel transform(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        TaskModel taskModel = new TaskModel(task.getId());
        taskModel.setTitle(task.getTitle());
        taskModel.setText(task.getText());
        taskModel.setUser(task.getUser());

        return taskModel;
    }

    public Collection<TaskModel> transform(Collection<Task> taskCollection) {
        Collection<TaskModel> taskModelCollection;

        if (taskCollection != null && !taskCollection.isEmpty()) {
            taskModelCollection = new ArrayList<>();
            for (Task task : taskCollection) {
                taskModelCollection.add(transform(task));
            }
        } else {
            taskModelCollection = Collections.emptyList();
        }

        return taskModelCollection;
    }

}
