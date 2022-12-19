package com.esg.esgdata.model.task;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(length = 25)
    protected String taskCode;
    @Enumerated(EnumType.STRING)
    protected TaskCategory category;
    protected String shortDesc;
    @Column(length = 800)
    protected String longDesc;
    protected int startTimeHr, startTimeMin, dueTimeHr, dueTimeMin;

    public Task(){};

    public Task(String taskCode, TaskCategory category, String shortDesc, String longDesc, int startTimeHr, int startTimeMin, int dueTimeHr, int dueTimeMin) {
        this.taskCode = taskCode;
        this.category = category;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.startTimeHr = startTimeHr;
        this.startTimeMin = startTimeMin;
        this.dueTimeHr = dueTimeHr;
        this.dueTimeMin = dueTimeMin;
    }

    public TaskCategory getCategory() {
        return category;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public int getStartTimeHr() {
        return startTimeHr;
    }

    public int getStartTimeMin() {
        return startTimeMin;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public void setCategory(TaskCategory category) {
        this.category = category;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public void setStartTimeHr(int startTimeHr) {
        this.startTimeHr = startTimeHr;
    }

    public void setStartTimeMin(int startTimeMin) {
        this.startTimeMin = startTimeMin;
    }

    public int getDueTimeHr() {
        return dueTimeHr;
    }

    public void setDueTimeHr(int dueTimeHr) {
        this.dueTimeHr = dueTimeHr;
    }

    public int getDueTimeMin() {
        return dueTimeMin;
    }

    public void setDueTimeMin(int dueTimeMin) {
        this.dueTimeMin = dueTimeMin;
    }
}
