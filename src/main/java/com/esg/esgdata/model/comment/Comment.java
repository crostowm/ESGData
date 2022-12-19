package com.esg.esgdata.model.comment;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity @IdClass(CommentId.class)
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    public final static String NOTE = "Note", PRAISE = "Praise", REDIRECT = "Redirect";

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    @Id
    protected LocalDate date;
    protected String comment;
    protected String type;

    public Comment(){}

    public Comment(LocalDate date, String comment, String type) {
        this.date = date;
        this.comment = comment;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
