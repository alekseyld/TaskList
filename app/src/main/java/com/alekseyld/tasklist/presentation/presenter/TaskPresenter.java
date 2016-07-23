package com.alekseyld.tasklist.presentation.presenter;

import android.support.annotation.NonNull;

import com.alekseyld.tasklist.domain.Task;
import com.alekseyld.tasklist.domain.interactor.DefaultSubscriber;
import com.alekseyld.tasklist.domain.interactor.UseCase;
import com.alekseyld.tasklist.presentation.di.ActivityScope;
import com.alekseyld.tasklist.presentation.model.TaskModel;
import com.alekseyld.tasklist.presentation.transfer.ModelDataTransfer;
import com.alekseyld.tasklist.presentation.view.ITaskList;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Alekseyld on 22.07.2016.
 */
@ActivityScope
public class TaskPresenter implements IPresenter {

    private ITaskList view;

    private final UseCase getTaskListUseCase;
    private final ModelDataTransfer modelDataTransfer;

    @Inject
    public TaskPresenter(@Named("userList") UseCase getTaskListUseCase,
                         ModelDataTransfer modelDataTransfer) {
        this.getTaskListUseCase = getTaskListUseCase;
        this.modelDataTransfer = modelDataTransfer;
    }

    public void setView(@NonNull ITaskList view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        this.getTaskListUseCase.unsubscribe();
        this.view = null;
    }

    public void initialize() {
        this.loadUserList();
    }

    private void loadUserList() {;
        this.getUserList();
    }

    private void showUsersCollectionInView(Collection<Task> taskCollection) {
        final Collection<TaskModel> taskModelCollection =
                this.modelDataTransfer.transform(taskCollection);
        this.view.renderTaskList(taskModelCollection);
    }

    private void getUserList() {
        this.getTaskListUseCase.execute(new TaskListSubscriber());
    }

    private final class TaskListSubscriber extends DefaultSubscriber<List<Task>> {

        @Override public void onCompleted() {}
        @Override public void onError(Throwable e) {}

        @Override public void onNext(List<Task> users) {
            TaskPresenter.this.showUsersCollectionInView(users);
        }
    }
}
