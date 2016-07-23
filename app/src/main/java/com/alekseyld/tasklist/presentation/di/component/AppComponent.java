package com.alekseyld.tasklist.presentation.di.component;

import android.content.Context;

import com.alekseyld.tasklist.domain.Task;
import com.alekseyld.tasklist.domain.executor.PostExecutionThread;
import com.alekseyld.tasklist.domain.executor.ThreadExecutor;
import com.alekseyld.tasklist.domain.repository.TaskRepository;
import com.alekseyld.tasklist.presentation.di.module.AppModule;
import com.alekseyld.tasklist.presentation.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alekseyld on 22.07.2016.
 */
@Singleton
@Component(
        modules = AppModule.class
)
public interface AppComponent {
    void inject(MainActivity mainActivity);

    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    TaskRepository taskRepository();
}
