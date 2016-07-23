package com.alekseyld.tasklist.presentation.model;

/**
 * Created by Alekseyld on 22.07.2016.
 */
public class TaskModel {
    private final int id;

    public TaskModel(int id){
        this.id = id;
    }

    private String title;
    private String text;
    private String user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public int getId(){
        return id;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
