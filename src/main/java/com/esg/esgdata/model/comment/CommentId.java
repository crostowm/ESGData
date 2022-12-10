package com.esg.esgdata.model.comment;

import com.esg.esgdata.model.task.TaskId;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CommentId implements Serializable {

    private int id;
    private LocalDate date;

    public CommentId() {
    }

    public CommentId(int id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentId commentId = (CommentId) o;
        return id == commentId.id &&
                date == commentId.date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }
}
