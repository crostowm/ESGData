package com.esg.esgdata.model.execution;

import com.esg.esgdata.model.prep.PrepId;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ExecutionId implements Serializable {
    private LocalDate date;
    private String lunchOrDinner;

    public ExecutionId(){}
    public ExecutionId(LocalDate date, String desc) {
        this.date = date;
        this.lunchOrDinner = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExecutionId executionId = (ExecutionId) o;
        return lunchOrDinner == executionId.lunchOrDinner &&
                date == executionId.date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lunchOrDinner, date);
    }
}
