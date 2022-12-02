package com.esg.esgdata.model.task;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TaskId implements Serializable {
    private String taskCode;
    private LocalDate date;

    public TaskId() {
    }

    public TaskId(String taskCode, LocalDate date) {
        this.taskCode = taskCode;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskId taskId = (TaskId) o;
        return taskCode == taskId.taskCode &&
                date == taskId.date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskCode, date);
    }

    public String getTaskCode() {
        return taskCode;
    }

    public LocalDate getDate() {
        return date;
    }
}