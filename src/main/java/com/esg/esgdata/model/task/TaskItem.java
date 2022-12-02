package com.esg.esgdata.model.task;


import com.esg.esgdata.staff.Employee;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@IdClass(TaskId.class)
public class TaskItem extends Task {
    @Id
    private LocalDate date;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "completed_by_id")
    private Employee completedBy;
    private boolean isActive;

    public void setCompletedBy(Employee completedBy) {
        this.completedBy = completedBy;
    }

    public TaskItem(){
    }
    public TaskItem(String taskCode, TaskCategory category, String shortDesc, String longDesc, int startTimeHr, int startTimeMin, int dueTimeHr, int dueTimeMin, LocalDate date) {
        super(taskCode, category, shortDesc, longDesc, startTimeHr, startTimeMin, dueTimeHr, dueTimeMin);
        this.date = date;
        completedBy = null;
        isActive = false;
    }

    /*
     * Check for null when calling completedBy
     * null = not completed
     */
    public Employee getCompletedBy() {
        return completedBy;
    }

    public void complete(Employee employee)
    {
        completedBy = employee;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {return isActive;}

    public LocalDate getDate() {
        return date;
    }
}
