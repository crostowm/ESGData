package com.esg.esgdata.model.task;

import javax.persistence.Entity;

@Entity
public class TaskTemplate extends Task{

    public TaskTemplate(){
    }

    public TaskTemplate(String taskCode, TaskCategory category, String shortDesc, String longDesc, int startTimeHr, int startTimeMin, int dueTimeHr, int dueTimeMin) {
        super(taskCode, category, shortDesc, longDesc, startTimeHr, startTimeMin, dueTimeHr, dueTimeMin);
    }
}
