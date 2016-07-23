package com.alekseyld.tasklist.presentation.app;

import android.app.Application;

import com.alekseyld.tasklist.presentation.di.component.AppComponent;
import com.alekseyld.tasklist.presentation.di.component.DaggerAppComponent;
import com.alekseyld.tasklist.presentation.di.module.AppModule;

/**
 * Created by Alekseyld on 22.07.2016.
 */
public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildgraph();
    }

    private void buildgraph() {
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
