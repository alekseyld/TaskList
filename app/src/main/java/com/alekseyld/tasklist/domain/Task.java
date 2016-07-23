package com.alekseyld.tasklist.domain;

/**
 * Created by Alekseyld on 23.07.2016.
 */
public class Task {
    private final int id;

    public Task(int id){
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
