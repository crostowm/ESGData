package com.esg.esgdata.model.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentDao {

    @Autowired
    CommentRepository commentRepository;

    public Comment save(Comment comment) { return commentRepository.save(comment);}

    public List<Comment> getAllComments()
    {
        List<Comment> comments = new ArrayList<>();
        Streamable.of(commentRepository.findAll())
                .forEach(comment -> {
                    comments.add(comment);
                });
        return comments;
    }

    public void deleteComment(int id, LocalDate date)
    {
        System.out.println("Deletind " + id + " " + date);
        commentRepository.deleteById(new CommentId(id, date));
    }

    public List<Comment> getCommentsForDate(LocalDate date) {
        List<Comment> comments = new ArrayList<>();
        Streamable.of(commentRepository.findAll())
                .forEach(comment -> {
                    if(comment.getDate().equals(date))
                        comments.add(comment);
                });
        return comments;
    }

    public List<Comment> getPraisesForDate(LocalDate date) {
        List<Comment> comments = new ArrayList<>();
        Streamable.of(commentRepository.findAll())
                .forEach(comment -> {
                    if(comment.getDate().equals(date) && comment.getType().equals(Comment.PRAISE))
                        comments.add(comment);
                });
        return comments;
    }

    public List<Comment> getRedirectsForDate(LocalDate date) {
        List<Comment> comments = new ArrayList<>();
        Streamable.of(commentRepository.findAll())
                .forEach(comment -> {
                    if(comment.getDate().equals(date) && comment.getType().equals(Comment.REDIRECT))
                        comments.add(comment);
                });
        return comments;
    }

    public List<Comment> getNotesForDate(LocalDate date) {
        List<Comment> comments = new ArrayList<>();
        Streamable.of(commentRepository.findAll())
                .forEach(comment -> {
                    if(comment.getDate().equals(date) && comment.getType().equals(Comment.NOTE))
                        comments.add(comment);
                });
        return comments;
    }
}
