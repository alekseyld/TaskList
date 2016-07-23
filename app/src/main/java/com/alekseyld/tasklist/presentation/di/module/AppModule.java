package com.alekseyld.tasklist.presentation.di.module;

import android.content.Context;

import com.alekseyld.tasklist.data.executor.JobExecutor;
import com.alekseyld.tasklist.data.repository.TaskDataRepository;
import com.alekseyld.tasklist.domain.executor.PostExecutionThread;
import com.alekseyld.tasklist.domain.executor.ThreadExecutor;
import com.alekseyld.tasklist.domain.repository.TaskRepository;
import com.alekseyld.tasklist.presentation.app.App;
import com.alekseyld.tasklist.presentation.app.MainThread;
import com.alekseyld.tasklist.presentation.di.component.AppComponent;
import com.alekseyld.tasklist.presentation.presenter.TaskPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alekseyld on 22.07.2016.
 */
@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(MainThread mainThread) {
        return mainThread;
    }

    @Provides @Singleton
    TaskRepository provideUserRepository(TaskDataRepository taskDataRepository) {
        return taskDataRepository;
    }

}
