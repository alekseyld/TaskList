package com.alekseyld.tasklist.domain.repository;

import com.alekseyld.tasklist.domain.Task;

import java.util.List;

import rx.Observable;

/**
 * Created by Alekseyld on 23.07.2016.
 */
public interface TaskRepository {

    Observable<List<Task>> tasks();

}
