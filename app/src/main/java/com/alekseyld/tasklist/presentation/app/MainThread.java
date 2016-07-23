package com.alekseyld.tasklist.presentation.app;

import com.alekseyld.tasklist.domain.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Alekseyld on 23.07.2016.
 */
@Singleton
public class MainThread implements PostExecutionThread {
    @Inject
    public MainThread() {}

    @Override public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
