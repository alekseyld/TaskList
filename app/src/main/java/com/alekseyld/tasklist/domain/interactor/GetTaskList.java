/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alekseyld.tasklist.domain.interactor;

import com.alekseyld.tasklist.domain.executor.PostExecutionThread;
import com.alekseyld.tasklist.domain.executor.ThreadExecutor;
import com.alekseyld.tasklist.domain.repository.TaskRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetTaskList extends UseCase {

  private final TaskRepository taskRepository;

  @Inject
  public GetTaskList(TaskRepository taskRepository, ThreadExecutor threadExecutor,
                     PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.taskRepository = taskRepository;
  }

  @Override public Observable buildUseCaseObservable() {
    return this.taskRepository.tasks();
  }
}
