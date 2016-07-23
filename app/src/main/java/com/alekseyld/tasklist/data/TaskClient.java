package com.alekseyld.tasklist.data;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alekseyld on 21.07.2016.
 */
public final class TaskClient {

    private static TaskService taskService = null;

    public static TaskService getClient() {
        if(taskService == null) {
            final OkHttpClient client = new OkHttpClient();
            client.interceptors().add(new FakeInterceptor());

            final Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                            // Endpoint
                    .baseUrl(TaskService.URI)
                    .client(client)
                    .build();

            taskService = retrofit.create(TaskService.class);
        }
        return taskService;
    }
}
