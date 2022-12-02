package com.esg.esgdata.model.daydata;

import java.io.Serializable;
import java.util.Objects;

public class DateId implements Serializable {

    private int year;
    private int month;
    private int day;

    public DateId() {
    }

    public DateId(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateId dateId = (DateId) o;
        return year == dateId.year &&
                month == dateId.month &&
                day == dateId.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
