package com.esg.esgdata.model.task;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Task implements Serializable {

    @Id @Column(length = 10)
    private String taskCode;

    protected TaskCategory category;
    protected String shortDesc, longDesc;
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
}
