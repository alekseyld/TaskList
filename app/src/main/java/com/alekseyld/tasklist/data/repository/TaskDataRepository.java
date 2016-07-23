package com.alekseyld.tasklist.data.repository;

import com.alekseyld.tasklist.domain.Task;
import com.alekseyld.tasklist.domain.repository.TaskRepository;

import java.util.List;

import rx.Observable;

/**
 * Created by Alekseyld on 23.07.2016.
 */
public class TaskDataRepository implements TaskRepository {
    @Override
    public Observable<List<Task>> tasks() {
        return null;
    }
}
