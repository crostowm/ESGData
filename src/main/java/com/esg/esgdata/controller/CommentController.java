package com.esg.esgdata.controller;

import com.esg.esgdata.model.comment.Comment;
import com.esg.esgdata.model.comment.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentDao commentDao;

    @GetMapping("/comment/get-all")
    public List<Comment> getComment() {
        return commentDao.getAllComments();
    }

    @GetMapping("/comment/get/{date}")
    public List<Comment> getCommentForDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return commentDao.getCommentsForDate(date);
    }

    @GetMapping("/comment/get-praises/{date}")
    public List<Comment> getPraisesForDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return commentDao.getPraisesForDate(date);
    }

    @GetMapping("/comment/get-redirects/{date}")
    public List<Comment> getRedirectsForDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return commentDao.getRedirectsForDate(date);
    }

    @GetMapping("/comment/get-notes/{date}")
    public List<Comment> getNotesForDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return commentDao.getNotesForDate(date);
    }

    @PostMapping("/comment/save")
    public Comment saveComment(@RequestBody Comment comment) {
        return commentDao.save(comment);
    }
}
