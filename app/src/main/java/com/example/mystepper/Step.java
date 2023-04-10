package com.example.mystepper;

/**
 * Created by Md Minhajul Islam on 10/04/2023.
 */
public class Step {
    private int id;
    private String title;
    private boolean completed;
    private int stepType; // added field to indicate type of step

    public Step(int id,String title, boolean completed, int stepType) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.stepType = stepType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getStepType() {
        return stepType;
    }

    public void setStepType(int stepType) {
        this.stepType = stepType;
    }
}
