package com.alekseyld.tasklist.presentation.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Alekseyld on 23.07.2016.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {}
