package com.esg.esgdata.model.task;

import javax.persistence.Entity;

@Entity
public class TaskTemplate extends Task{

    public TaskTemplate(){
    }
    public TaskTemplate(String taskCode, TaskCategory category, String shortDesc, String longDesc)
    {
        this.taskCode = taskCode;
        this.category = category;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        switch (category)
        {
            case Open:
                startTimeHr = 4;
                dueTimeHr = 10;
                startTimeMin = 0;
                dueTimeMin = 0;
                break;
            case ALCU:
                startTimeHr = 13;
                dueTimeHr = 15;
                startTimeMin = 0;
                dueTimeMin = 0;
                break;
            case ADCU:
                startTimeHr = 18;
                dueTimeHr = 21;
                startTimeMin = 30;
                dueTimeMin = 0;
                break;
            case Close:
                startTimeHr = 20;
                dueTimeHr = 23;
                startTimeMin = 0;
                dueTimeMin = 0;
                break;
            default:
                startTimeHr = 4;
                dueTimeHr = 23;
                startTimeMin = 0;
                dueTimeMin = 0;
        }
    }
    public TaskTemplate(String taskCode, TaskCategory category, String shortDesc, String longDesc, int startTimeHr, int startTimeMin, int dueTimeHr, int dueTimeMin) {
        super(taskCode, category, shortDesc, longDesc, startTimeHr, startTimeMin, dueTimeHr, dueTimeMin);
    }
}
